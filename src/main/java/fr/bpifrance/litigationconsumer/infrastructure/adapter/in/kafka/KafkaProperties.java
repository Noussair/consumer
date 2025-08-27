package fr.bpifrance.litigationconsumer.infrastructure.adapter.in.kafka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProperties {

    @Bean
    @ConfigurationProperties(prefix = "kafka")
    public KafkaConfig kafkaConfig() {
        return new KafkaConfig();
    }

    @Getter
    @Setter
    public static class KafkaConfig {
        private String brokers;
        private String app;
        private String domain;
        private String clientId;
        private String groupId;
        private String username;
        private String password;
        private String readTopic;
        private String outputTopic;
        private Integer concurrency;
        private String fallbackTopic;
    }
}
