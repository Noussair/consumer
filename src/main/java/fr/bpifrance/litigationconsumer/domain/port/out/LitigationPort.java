package fr.bpifrance.litigationconsumer.domain.port.out;

import fr.bpifrance.litigationconsumer.domain.model.CustomerAgreement;

public interface LitigationPort {
  void addPayAssRole(CustomerAgreement customerAgreement);
}
