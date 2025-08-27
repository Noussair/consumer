package fr.bpifrance.litigationconsumer.infrastructure.adapter.out.rest;

import fr.bpifrance.litigationconsumer.domain.port.out.LegacyProductCodePort;
import fr.bpifrance.litigationconsumer.infrastructure.client.rest.ApiConsRestClient;
import fr.bpifrance.litigationconsumer.infrastructure.client.config.RestClientProperties.RestClientConfig;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.TupcodeDto;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LegacyProductCodeAdapter implements LegacyProductCodePort {

  private final ApiConsRestClient apiConsRestClient;
  private final RestClientConfig restClientConfig;

  @Override
  public List<String> getListLegacyProductCode() {

    List<String> listLegacyproductCode =
        apiConsRestClient
            .getLegacyProductCodes(
                restClientConfig.getLegacyProductCodeObjectCode(),
                restClientConfig.getLegacyProductCodeObjectReference())
            .stream()
            .map(TupcodeDto::value)
            .filter(Objects::nonNull)
            .toList();
    return listLegacyproductCode;
  }
}
