package fr.bpifrance.litigationconsumer.infrastructure.client.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClientProperties {

  @Bean
  @ConfigurationProperties(prefix = "ws.rest")
  public RestClientConfig restClientConfig() {
    return new RestClientConfig();
  }

  @Getter
  @Setter
  public static class RestClientConfig {
    private String clientId;
    private String clientSecret;
    private String grantType;
    private String xApiKey;
    private Isam isam;
    private ApiConsPrt apiConsPrt;
    private String legacyProductCodeObjectCode;
    private String legacyProductCodeObjectReference;
    private String localIdentifierObjectCode;

    @Getter
    @Setter
    public static class Isam {
      private String url;
    }

    @Getter
    @Setter
    public static class ApiConsPrt {
      private String url;
    }
  }
}
