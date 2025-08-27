package fr.bpifrance.litigationconsumer.infrastructure.client.rest;

import feign.FeignException;
import fr.bpifrance.litigationconsumer.infrastructure.client.interceptor.IsamInterceptor;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.request.AddActRoleRequestDto;
import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.ApiUpdateResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@FeignClient(
    name = "api-update-prt",
    url = "${ws.rest.api-update-prt.url}",
    configuration = IsamInterceptor.class)
public interface ApiUpdateRestClient {

  @RequestMapping(
      value = "/apiupdate/api/v1/update",
      method = RequestMethod.POST,
      consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
      produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  @ResponseBody
  ResponseEntity<ApiUpdateResponseDto> addActRole(
      @RequestBody AddActRoleRequestDto requestBody, @RequestParam("module") String module)
      throws FeignException.FeignClientException;
}
