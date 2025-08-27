package fr.bpifrance.litigationconsumer.domain.port.out;

import fr.bpifrance.litigationconsumer.domain.model.PartyRole;

public interface PartyRolePort {
  PartyRole getCustomerAgreementRelatedPartyRole(String idRef);
}
