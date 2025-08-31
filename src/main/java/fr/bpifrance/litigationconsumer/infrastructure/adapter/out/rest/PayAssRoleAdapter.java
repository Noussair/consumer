package fr.bpifrance.litigationconsumer.infrastructure.adapter.out.rest;

import fr.bpifrance.litigationconsumer.domain.model.AddPayAssRoleResponse;
import fr.bpifrance.litigationconsumer.domain.model.InsurancePay;
import fr.bpifrance.litigationconsumer.domain.port.out.PayAssRolePort;
import fr.bpifrance.litigationconsumer.infrastructure.adapter.out.rest.mapper.PayAssRoleMapper;
import fr.bpifrance.litigationconsumer.infrastructure.client.config.RestClientProperties.RestClientConfig;
import fr.bpifrance.litigationconsumer.infrastructure.client.rest.ApiConsRestClient;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.ApiUpdateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PayAssRoleAdapter implements PayAssRolePort {

  private final ApiConsRestClient apiConsRestClient;
  private final RestClientConfig restClientConfig;
  private final PayAssRoleMapper mapper;

  @Override
  public AddPayAssRoleResponse addPayAssRole(InsurancePay insurancePay) {
    final ApiUpdateResponseDto apiUpdateResponseDto = new ApiUpdateResponseDto();
    return mapper.toDomain(apiUpdateResponseDto);
  }
}
