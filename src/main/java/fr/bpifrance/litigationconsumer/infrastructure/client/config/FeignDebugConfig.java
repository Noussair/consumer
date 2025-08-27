package fr.bpifrance.litigationconsumer.infrastructure.client.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignDebugConfig {

  @Bean
  Logger.Level FeignLoggerLevel() {
    return Logger.Level.FULL;
  }
}
