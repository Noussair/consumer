package fr.bpifrance.litigationconsumer.infrastructure.adapter.out.rest.mapper;

import fr.bpifrance.litigationconsumer.domain.model.PartyRole;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.PartyRoleResponseDto;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class PartyRoleMapper {
  public PartyRole toDomain(PartyRoleResponseDto response) {
    if (response == null
        || response.getPayload() == null
        || response.getPayload().getEntity() == null) {
      return null;
    }

    PartyRoleResponseDto.entity responseEntity = response.getPayload().getEntity();
    PartyRole.entity domainEntity =
        PartyRole.entity
            .builder()
            .domain(responseEntity.getDomain())
            .type(responseEntity.getType())
            .idRef(responseEntity.getIdRef())
            .build();

    if (responseEntity.getEventCode() != null) {
      PartyRole.eventCode domainEventCode =
          PartyRole.eventCode
              .builder()
              .operationCode(responseEntity.getEventCode().getOperationCode())
              .reasonCode(responseEntity.getEventCode().getReasonCode())
              .build();
      domainEntity.setEventCode(domainEventCode);
    }

    if (responseEntity.getData() != null) {
      PartyRoleResponseDto.data responseData = responseEntity.getData();
      PartyRole.data domainData =
          PartyRole.data
              .builder()
              .partyRoleCode(responseData.getPartyRoleCode())
              .partyRoleReference(responseData.getPartyRoleReference())
              .partyReference(responseData.getPartyReference())
              .eventIdentifier(responseData.getEventIdentifier())
              .terminationDate(responseData.getTerminationDate())
              .localPartyIdentifier(responseData.getLocalPartyIdentifier())
              .customerAgreementLocIdentifier(responseData.getCustomerAgreementLocIdentifier())
              .activationDate(responseData.getActivationDate())
              .customerAgreementReference(responseData.getCustomerAgreementReference())
              .build();

      if (responseData.getParRolesAdresses() != null) {
        domainData.setParRolesAdresses(
            responseData.getParRolesAdresses().stream()
                .map(this::toDomain)
                .collect(Collectors.toList()));
      } else {
        domainData.setParRolesAdresses(Collections.emptyList());
      }

      if (responseData.getParRolesPaymentsModes() != null) {
        domainData.setParRolesPaymentsModes(
            responseData.getParRolesPaymentsModes().stream()
                .map(this::toDomain)
                .collect(Collectors.toList()));
      } else {
        domainData.setParRolesPaymentsModes(Collections.emptyList());
      }
      domainEntity.setData(domainData);
    }

    if (responseEntity.getLinks() != null) {
      domainEntity.setLinks(
          responseEntity.getLinks().stream().map(this::toDomain).collect(Collectors.toList()));
    } else {
      domainEntity.setLinks(Collections.emptyList());
    }

    PartyRole.payload domainPayload = PartyRole.payload.builder().entity(domainEntity).build();

    return PartyRole.builder().payload(domainPayload).build();
  }

  private PartyRole.parRolesAdresses toDomain(PartyRoleResponseDto.parRolesAdresses response) {
    if (response == null) {
      return null;
    }
    return PartyRole.parRolesAdresses
        .builder()
        .activationdate(response.getActivationdate())
        .address1(response.getAddress1())
        .address3(response.getAddress3())
        .countrycode(response.getCountrycode())
        .build();
  }

  private PartyRole.parRolesPaymentsModes toDomain(
      PartyRoleResponseDto.parRolesPaymentsModes response) {
    if (response == null) {
      return null;
    }
    return PartyRole.parRolesPaymentsModes
        .builder()
        .paymentModeCode(response.getPaymentModeCode())
        .partyIBAN(response.getPartyIBAN())
        .activationDate(response.getActivationDate())
        .paymentModeType(response.getPaymentModeType())
        .build();
  }

  private PartyRole.links toDomain(PartyRoleResponseDto.links response) {
    if (response == null) {
      return null;
    }
    return PartyRole.links.builder().idRef(response.getIdRef()).type(response.getType()).build();
  }
}
