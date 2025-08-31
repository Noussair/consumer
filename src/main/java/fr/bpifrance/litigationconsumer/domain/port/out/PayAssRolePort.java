package fr.bpifrance.litigationconsumer.domain.port.out;

import fr.bpifrance.litigationconsumer.domain.model.InsurancePay;

public interface PayAssRolePort {
  void addPayAssRole(InsurancePay insurancePay);
}
