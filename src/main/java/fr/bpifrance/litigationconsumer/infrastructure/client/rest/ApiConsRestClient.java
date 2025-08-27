package fr.bpifrance.litigationconsumer.infrastructure.client.rest;

import fr.bpifrance.litigationconsumer.infrastructure.client.config.FeignDebugConfig;
import fr.bpifrance.litigationconsumer.infrastructure.client.interceptor.IsamInterceptor;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.TupcodeDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
    name = "api-cons-prt",
    url = "${ws.rest.api-cons-prt.url}",
    configuration = {IsamInterceptor.class, FeignDebugConfig.class})
public interface ApiConsRestClient {

  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<TupcodeDto> getLegacyProductCodes(
      @RequestParam String objectcode, @RequestParam String objectreference);
}
