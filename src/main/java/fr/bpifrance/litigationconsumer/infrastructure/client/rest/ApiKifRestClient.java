package fr.bpifrance.litigationconsumer.infrastructure.client.rest;

import com.fasterxml.jackson.databind.JsonNode;
import fr.bpifrance.litigationconsumer.infrastructure.client.config.FeignDebugConfig;
import fr.bpifrance.litigationconsumer.infrastructure.client.interceptor.IsamInterceptor;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.PartyRoleResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
    name = "api-kif",
    url = "${ws.rest.api-kif.url}",
    configuration = {IsamInterceptor.class, FeignDebugConfig.class})
public interface ApiKifRestClient {

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  JsonNode getPartyRole(@RequestParam("idRef") String idRef);
}
