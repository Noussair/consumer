package fr.bpifrance.litigationconsumer.infrastructure.client.interceptor;

import feign.RequestTemplate;
import fr.bpifrance.litigationconsumer.infrastructure.client.common.CommonClientJWTInterceptor;
import fr.bpifrance.litigationconsumer.infrastructure.client.config.RestClientProperties.RestClientConfig;
import fr.bpifrance.litigationconsumer.infrastructure.client.exception.IsamCallException;
import fr.bpifrance.litigationconsumer.infrastructure.client.model.IsamAccessTokenModelResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;

public class JwtInterceptor extends CommonClientJWTInterceptor {

  @Autowired private RestClientConfig restClientConfig;

  private static final String TOKEN_TYPE = "Bearer";
  private static final String X_API_KEY = "x-api-key";

  @Override
  public void addTokenToHeader(
      RequestTemplate requestTemplate, IsamAccessTokenModelResponse isamAccessToken) {
    if (isamAccessToken != null) {
      requestTemplate.header(
          HttpHeaders.AUTHORIZATION, TOKEN_TYPE + " " + isamAccessToken.getAccessToken());
      requestTemplate.header(X_API_KEY, restClientConfig.getXApiKey());

    } else {
      new IsamCallException("Error while extracting ISAM Access Token: No token provided");
    }
  }
}
