package fr.bpifrance.litigationconsumer.infrastructure.client.rest;

import fr.bpifrance.litigationconsumer.infrastructure.client.config.IsamRestClientConfig;
import fr.bpifrance.litigationconsumer.infrastructure.client.model.IsamAccessTokenModelResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient(
    name = "isam-client",
    url = "${ws.rest.isam.url}",
    configuration = IsamRestClientConfig.class)
public interface IsamRestClient {

  @PostMapping(
      produces = MediaType.APPLICATION_JSON_VALUE,
      consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
  ResponseEntity<IsamAccessTokenModelResponse> retrieveAccessToken(
      @RequestBody Map<String, ?> form);
}
