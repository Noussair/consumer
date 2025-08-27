package fr.bpifrance.litigationconsumer.infrastructure.client.interceptor;

import org.springframework.context.annotation.Bean;

public class IsamInterceptor {

  @Bean
  public JwtInterceptor objectInterceptor() {
    return new JwtInterceptor();
  }
}
