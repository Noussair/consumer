package fr.bpifrance.litigationconsumer.infrastructure.client.config;

import feign.codec.Encoder;
import feign.form.FormEncoder;

import org.springframework.context.annotation.Bean;

public class IsamRestClientConfig {

  @Bean
  public Encoder encoder() {
    return new FormEncoder();
  }
}
