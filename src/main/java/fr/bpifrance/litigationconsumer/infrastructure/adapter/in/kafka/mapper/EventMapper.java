package fr.bpifrance.litigationconsumer.infrastructure.adapter.in.kafka.mapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.bpifrance.litigationconsumer.domain.model.CustomerAgreement;
import fr.bpifrance.oso.framework.oggy.event.Event;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
@Slf4j
public class EventMapper {

  private final ObjectMapper objectMapper;

  public Optional<CustomerAgreement> toCustomerAgreementEvent(Event oggyEvent) {
    try {
      Object payloadObject = oggyEvent.getPayload();
      CustomerAgreement customerAgreement =
          objectMapper.convertValue(payloadObject, CustomerAgreement.class);
      return Optional.of(customerAgreement);

    } catch (Exception e) {
      log.error(
          "Failed to map Oggy event payload to CustomerAgreement. Check the event structure. Event ID: {}",
          e);
      return Optional.empty();
    }
  }
}
