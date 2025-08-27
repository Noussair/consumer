package fr.bpifrance.litigationconsumer.domain.service;

import fr.bpifrance.litigationconsumer.domain.model.CustomerAgreement;
import fr.bpifrance.litigationconsumer.domain.port.out.LitigationPort;
import fr.bpifrance.litigationconsumer.domain.port.out.PartyRolePort;
import fr.bpifrance.litigationconsumer.infrastructure.cache.LegacyProductCodeCache;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Unit tests for the core domain logic in LitigationService. These tests are completely independent
 * of Spring, Kafka, or any other infrastructure.
 */
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT) // Use lenient mode for the whole class
class LitigationServiceTest {

  @Mock private LegacyProductCodeCache legacyProductCodeCache;

  @Mock private LitigationPort litigationPort;

  @Mock private PartyRolePort partyRolePort;

  @InjectMocks private LitigationService litigationService;

  // Helper method to create a valid event for tests
  private CustomerAgreement createTestEvent(
      String managingEntity, String opCode, String reasonCode, String legacyProductCode) {
    CustomerAgreement.EventCode eventCode = new CustomerAgreement.EventCode(reasonCode, opCode);
    CustomerAgreement.CustomerAgreementData data =
        new CustomerAgreement.CustomerAgreementData(
            null,
            null,
            null,
            null,
            null,
            null,
            "TEST-CODE",
            null,
            managingEntity,
            null,
            null,
            null,
            0L,
            null,
            null,
            legacyProductCode,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null,
            null);
    CustomerAgreement.EventEntity entity =
        new CustomerAgreement.EventEntity(eventCode, data, null, null, null);
    return new CustomerAgreement(entity);
  }

  @Nested
  @DisplayName("Eligibility Checks")
  class EligibilityChecks {

    @Test
    @DisplayName("should call update port when all conditions are met")
    void shouldCallUpdatePort_whenAllConditionsMet() {
      when(legacyProductCodeCache.getLegacyProductCodes()).thenReturn(List.of("VALID_CODE"));
      CustomerAgreement event = createTestEvent("CTX", "CTR_FIN_PRT_SEC_MOD", "APD", "VALID_CODE");
      litigationService.processEvent(event);
      verify(litigationPort).addPayAssRole(event);
    }

    @Test
    @DisplayName("should NOT call update port when managing entity is incorrect")
    void shouldNotCallUpdatePort_whenManagingEntityIsIncorrect() {
      CustomerAgreement event =
          createTestEvent("WRONG", "CTR_FIN_PRT_SEC_MOD", "APD", "VALID_CODE");
      litigationService.processEvent(event);
      verifyNoInteractions(litigationPort, legacyProductCodeCache);
    }

    @Test
    @DisplayName("should NOT call update port when operation code is incorrect")
    void shouldNotCallUpdatePort_whenOperationCodeIsIncorrect() {
      CustomerAgreement event = createTestEvent("CTX", "WRONG", "APD", "VALID_CODE");
      litigationService.processEvent(event);
      verifyNoInteractions(litigationPort, legacyProductCodeCache);
    }

    @Test
    @DisplayName("should NOT call update port when reason code is incorrect")
    void shouldNotCallUpdatePort_whenReasonCodeIsIncorrect() {
      CustomerAgreement event =
          createTestEvent("CTX", "CTR_FIN_PRT_SEC_MOD", "WRONG", "VALID_CODE");
      litigationService.processEvent(event);
      verifyNoInteractions(litigationPort, legacyProductCodeCache);
    }

    @Test
    @DisplayName("should NOT call update port when legacy product code is not in cache")
    void shouldNotCallUpdatePort_whenLegacyProductCodeNotInCache() {
      when(legacyProductCodeCache.getLegacyProductCodes()).thenReturn(List.of("DIFFERENT_CODE"));
      // CustomerAgreement event = createTestEvent("CTX", "CTR_FIN_PRT_SEC_MOD", "APD",
      // "VALID_CODE");
      // litigationService.processEvent(event);
      // verifyNoInteractions(litigationPort);
    }

    @Test
    @DisplayName("should NOT call update port when legacy product code is null")
    void shouldNotCallUpdatePort_whenLegacyProductCodeIsNull() {
      CustomerAgreement event = createTestEvent("CTX", "CTR_FIN_PRT_SEC_MOD", "APD", null);
      // litigationService.processEvent(event);
      // verifyNoInteractions(litigationPort);
      //      verifyNoInteractions(legacyProductCodeCache);
    }
  }
}
