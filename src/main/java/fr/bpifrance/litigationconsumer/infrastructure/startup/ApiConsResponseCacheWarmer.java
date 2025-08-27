package fr.bpifrance.litigationconsumer.infrastructure.startup;

import fr.bpifrance.litigationconsumer.domain.port.out.LegacyProductCodePort;
import fr.bpifrance.litigationconsumer.infrastructure.cache.LegacyProductCodeCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
@Order(1)
public class ApiConsResponseCacheWarmer implements CommandLineRunner {

  private final LegacyProductCodePort legacyProductCodePort;
  private final LegacyProductCodeCache legacyProductCodeCache;

  @Override
  public void run(String... args) {
    log.info("Starting ApiCons Call to retrieve the list of legacyProductCode...");
    try {
      var listLegacyProductCode = legacyProductCodePort.getListLegacyProductCode();
      legacyProductCodeCache.setLegacyProductCodes(listLegacyProductCode);
      log.info("List of legacyProductCode loaded successfully.");
    } catch (Exception e) {
      log.error("Failed to load the list of legacyProductCode", e);
    }
  }
}
