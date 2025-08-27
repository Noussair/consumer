package fr.bpifrance.litigationconsumer.domain.port.out;

import java.util.List;

/** An outbound port for fetching business rules from an external source. */
public interface LegacyProductCodePort {
  List<String> getListLegacyProductCode();
}
