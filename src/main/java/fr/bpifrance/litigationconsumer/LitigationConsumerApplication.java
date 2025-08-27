package fr.bpifrance.litigationconsumer;

import fr.bpifrance.oso.framework.oggy.consumer.EventConsumer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@SpringBootApplication
@EnableFeignClients
@Slf4j
public class LitigationConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(LitigationConsumerApplication.class, args);
  }

  @Bean
  @Order(2)
  protected CommandLineRunner runConsumer(final EventConsumer consumer) {
    return args -> consumer.run();
  }
}
