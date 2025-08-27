package fr.bpifrance.litigationconsumer.infrastructure.adapter.out.rest;

import fr.bpifrance.litigationconsumer.domain.model.CustomerAgreement;
import fr.bpifrance.litigationconsumer.domain.port.out.LitigationPort;

import org.springframework.stereotype.Component;

@Component
public class LitigationAdapter implements LitigationPort {

  @Override
  public void addPayAssRole(CustomerAgreement customerAgreement) {
    // Since there is no REST layer, we can log the action for now.
    System.out.println("Updating litigation ");
  }
}
