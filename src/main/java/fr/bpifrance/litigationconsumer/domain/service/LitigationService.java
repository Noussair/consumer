package fr.bpifrance.litigationconsumer.domain.service;

import fr.bpifrance.litigationconsumer.domain.model.CustomerAgreement;
import fr.bpifrance.litigationconsumer.domain.model.InsurancePay;
import fr.bpifrance.litigationconsumer.domain.port.in.ProcessCustomerAgreementEventUseCase;
import fr.bpifrance.litigationconsumer.domain.port.out.PayAssRolePort;
import fr.bpifrance.litigationconsumer.domain.port.out.LocalPartyIdentifierPort;
import fr.bpifrance.litigationconsumer.domain.port.out.PartyRolePort;
import fr.bpifrance.litigationconsumer.infrastructure.cache.LegacyProductCodeCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class LitigationService implements ProcessCustomerAgreementEventUseCase {

  private final LegacyProductCodeCache legacyProductCodeCache;
  private final PartyRolePort partyRolePort;
  private final PayAssRolePort payAssRolePort;
  private final LocalPartyIdentifierPort localPartyIdentifierPort;

  @Override
  public void processEvent(CustomerAgreement customerAgreement) {
    String idRef = customerAgreement.getEntity().getIdRef();

    if (isEventEligibleForProcessing(customerAgreement)) {
      log.info("Event for agreement {} is eligible. Processing...", idRef);
      String dosnum =
          customerAgreement.getEntity().getData().getCustomerAgreementReference().split("/")[0];
      String managementEntity =
          customerAgreement.getEntity().getData().getCustomerAgreementManagementEntity();
      /*PartyRole partyRole =
          partyRolePort.getCustomerAgreementRelatedPartyRole(
              "partyRole-".concat(customerAgreementCode).concat("-1"));
      InsurancePay insurancePay = extractInsurancePayInfos(partyRole);
      //      InsurancePay insurancePay = new InsurancePay();*/
      String localPartyIdentifier = localPartyIdentifierPort.getLocalPartyIdentifier(dosnum);
      InsurancePay insurancePay = extractInsurancePayInfos(managementEntity, localPartyIdentifier);
      payAssRolePort.addPayAssRole(customerAgreement);
    } else {
      log.info("Event for agreement {} is not eligible. Skipping.", idRef);
    }
  }

  private InsurancePay extractInsurancePayInfos(
      String managementEntity, String localPartyIdentifier) {
    return new InsurancePay(localPartyIdentifier, "PAYASS", managementEntity);
  }

  private boolean isEventEligibleForProcessing(CustomerAgreement event) {
    return hasValidManagingEntity(event) && hasValidEventCodes(event);
    //  && hasValidLegacyProductCode(event);
  }

  private boolean hasValidManagingEntity(CustomerAgreement event) {
    return "CTX".equals(event.getEntity().getData().getManagingEntity());
  }

  private boolean hasValidEventCodes(CustomerAgreement event) {
    CustomerAgreement.EventCode eventCode = event.getEntity().getEventCode();
    return "CTR_FIN_PRT_SEC_MOD".equals(eventCode.getOperationCode())
        && "APD".equals(eventCode.getReasonCode());
  }

  private boolean hasValidLegacyProductCode(CustomerAgreement event) {
    String legacyProductCode = event.getEntity().getData().getLegacyProductCode();
    if (legacyProductCode == null || legacyProductCode.isBlank()) {
      return false;
    }
    return legacyProductCodeCache.getLegacyProductCodes().contains(legacyProductCode);
  }
}
