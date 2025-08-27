package fr.bpifrance.litigationconsumer.infrastructure.adapter.in.kafka;

import fr.bpifrance.litigationconsumer.domain.port.in.ProcessCustomerAgreementEventUseCase;
import fr.bpifrance.litigationconsumer.infrastructure.adapter.in.kafka.mapper.EventMapper;
import fr.bpifrance.oso.framework.oggy.common.security.SaslSslSecurity;
import fr.bpifrance.oso.framework.oggy.common.security.Security;
import fr.bpifrance.oso.framework.oggy.consumer.EventConsumer;
import fr.bpifrance.oso.framework.oggy.consumer.SingleTopicConsumerBootstrap;
import fr.bpifrance.oso.framework.oggy.event.metadata.Source;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

import static fr.bpifrance.litigationconsumer.infrastructure.adapter.in.kafka.KafkaProperties.KafkaConfig;
import static fr.bpifrance.oso.framework.oggy.consumer.EventConsumerBuilder.builder;

@Configuration
@AllArgsConstructor
public class KafkaEventConsumer {

  private final ProcessCustomerAgreementEventUseCase processUseCase;
  private final EventMapper eventMapper;
  private final KafkaConfig kafkaConfig;

  @Bean
  public EventConsumer consumer() throws IOException {
    final SingleTopicConsumerBootstrap consumerBootstrap =
        new SingleTopicConsumerBootstrap(
            kafkaConfig.getBrokers(),
            kafkaConfig.getClientId(),
            kafkaConfig.getGroupId(),
            kafkaConfig.getReadTopic());

    final Source source = new Source(kafkaConfig.getApp(), kafkaConfig.getDomain());
    final Security security =
        new SaslSslSecurity(kafkaConfig.getUsername(), kafkaConfig.getPassword());

    return builder()
        .bootstrap(consumerBootstrap)
        .source(source)
        .consumer(
            (headers, event) -> {
              eventMapper.toCustomerAgreementEvent(event).ifPresent(processUseCase::processEvent);
            })
        .security(security)
        .disableTimestampPreservation()
        .build();
  }
}
