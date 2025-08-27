package fr.bpifrance.litigationconsumer.infrastructure.adapter.out.rest;

import com.fasterxml.jackson.databind.JsonNode;
import fr.bpifrance.litigationconsumer.domain.model.PartyRole;
import fr.bpifrance.litigationconsumer.domain.port.out.PartyRolePort;
import fr.bpifrance.litigationconsumer.infrastructure.adapter.out.rest.mapper.PartyRoleMapper;
import fr.bpifrance.litigationconsumer.infrastructure.client.rest.ApiKifRestClient;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.PartyRoleResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PartyRoleAdapter implements PartyRolePort {

  private final ApiKifRestClient apiKifRestClient;
  private final PartyRoleMapper partyRoleMapper;

  @Override
  public PartyRole getCustomerAgreementRelatedPartyRole(String idRef) {
    PartyRoleResponseDto partyRoleResponseDto = apiKifRestClient.getPartyRole(idRef);
    return partyRoleMapper.toDomain(partyRoleResponseDto);
  }
}
