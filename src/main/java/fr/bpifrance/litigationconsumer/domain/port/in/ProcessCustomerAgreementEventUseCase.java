package fr.bpifrance.litigationconsumer.domain.port.in;

import fr.bpifrance.litigationconsumer.domain.model.CustomerAgreement;

public interface ProcessCustomerAgreementEventUseCase {

  void processEvent(CustomerAgreement event);
}
