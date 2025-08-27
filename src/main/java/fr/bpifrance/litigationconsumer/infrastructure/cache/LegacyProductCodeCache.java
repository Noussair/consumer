package fr.bpifrance.litigationconsumer.infrastructure.cache;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.springframework.stereotype.Component;

@Component
public class LegacyProductCodeCache {
  private final List<String> legacyProductCodes = new CopyOnWriteArrayList<>();

  public void setLegacyProductCodes(List<String> newLegacyProductCodes) {
    legacyProductCodes.clear();
    legacyProductCodes.addAll(newLegacyProductCodes);
  }

  public List<String> getLegacyProductCodes() {
    return Collections.unmodifiableList(this.legacyProductCodes);
  }
}
