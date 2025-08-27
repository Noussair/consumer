package fr.bpifrance.litigationconsumer.infrastructure.client.common;

import feign.RequestInterceptor;
import feign.RequestTemplate;

import fr.bpifrance.litigationconsumer.infrastructure.client.config.RestClientProperties.RestClientConfig;
import fr.bpifrance.litigationconsumer.infrastructure.client.exception.IsamCallException;
import fr.bpifrance.litigationconsumer.infrastructure.client.rest.IsamRestClient;
import fr.bpifrance.litigationconsumer.infrastructure.client.model.IsamAccessTokenModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public abstract class CommonClientJWTInterceptor implements RequestInterceptor {
  @Autowired private RestClientConfig restClientConfig;
  @Autowired private IsamRestClient isamRestClient;

  @Override
  public void apply(RequestTemplate template) {
    // Add ISAM Credentials in the header
    final Map<String, String> form = new HashMap<>();
    form.put("grant_type", restClientConfig.getGrantType());
    form.put("client_id", restClientConfig.getClientId());
    form.put("client_secret", restClientConfig.getClientSecret());
    form.put("scope", "openid");

    var isamAccessToken = getAccessToken(form);

    addTokenToHeader(template, isamAccessToken);
  }

  private IsamAccessTokenModelResponse getAccessToken(Map<String, String> form) {
    IsamAccessTokenModelResponse isamAccessToken = null;
    try {
      final ResponseEntity<IsamAccessTokenModelResponse> accessTokenResponseEntity =
          isamRestClient.retrieveAccessToken(form);
      isamAccessToken = accessTokenResponseEntity.getBody();
      if (isamAccessToken != null) {
        return isamAccessToken;
      }
    } catch (Exception exception) {
      var isamException = new IsamCallException("Error while calling ISAM apicons", exception);
    }
    return isamAccessToken;
  }

  public abstract void addTokenToHeader(
      RequestTemplate requestTemplate, IsamAccessTokenModelResponse isamAccessToken);
}
