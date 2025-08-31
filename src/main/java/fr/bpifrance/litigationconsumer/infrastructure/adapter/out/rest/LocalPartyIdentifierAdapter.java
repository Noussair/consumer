package fr.bpifrance.litigationconsumer.infrastructure.adapter.out.rest;

import fr.bpifrance.litigationconsumer.domain.port.out.LocalPartyIdentifierPort;
import fr.bpifrance.litigationconsumer.infrastructure.client.config.RestClientProperties.RestClientConfig;
import fr.bpifrance.litigationconsumer.infrastructure.client.rest.ApiConsRestClient;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.LocalPartyIdentifierDto;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocalPartyIdentifierAdapter implements LocalPartyIdentifierPort {

  private final ApiConsRestClient apiConsRestClient;
  private final RestClientConfig restClientConfig;

  @Override
  public String getLocalPartyIdentifier(String dosnum) {
    List<LocalPartyIdentifierDto> localPartyIdentifierDto =
        apiConsRestClient.getLocalPartyIdentifier(
            restClientConfig.getLocalIdentifierObjectCode(), dosnum);
    System.out.println(localPartyIdentifierDto);
    return localPartyIdentifierDto.get(0).localPartyIdentifier();
  }
}
