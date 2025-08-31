package fr.bpifrance.litigationconsumer.domain.port.out;

import fr.bpifrance.litigationconsumer.domain.model.AddPayAssRoleResponse;
import fr.bpifrance.litigationconsumer.domain.model.InsurancePay;

public interface PayAssRolePort {
  AddPayAssRoleResponse addPayAssRole(InsurancePay insurancePay);
}
