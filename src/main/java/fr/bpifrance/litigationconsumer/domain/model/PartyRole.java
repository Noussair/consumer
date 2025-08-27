package fr.bpifrance.litigationconsumer.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PartyRole {

  private payload payload;

  @Data
  @Builder
  public static class payload {
    private entity entity;
  }

  @Data
  @Builder
  public static class entity {
    private eventCode eventCode;
    private data data;
    private String domain;
    private List<links> links;
    private String type;
    private String idRef;
  }

  @Data
  @Builder
  public static class eventCode {
    private String operationCode;
    private String reasonCode;
  }

  @Data
  @Builder
  public static class data {
    private String partyRoleCode;
    private String partyRoleReference;
    private String partyReference;
    private String eventIdentifier;
    private String terminationDate;
    private List<parRolesAdresses> parRolesAdresses;
    private String localPartyIdentifier;
    private List<parRolesPaymentsModes> parRolesPaymentsModes;
    private Long customerAgreementLocIdentifier;
    private String activationDate;
    private String customerAgreementReference;
  }

  @Data
  @Builder
  public static class parRolesAdresses {
    private String activationdate;
    private String address3;
    private String address1;
    private String countrycode;
  }

  @Data
  @Builder
  public static class parRolesPaymentsModes {
    private String paymentModeCode;
    private String partyIBAN;
    private String activationDate;
    private String paymentModeType;
  }

  @Data
  @Builder
  public static class links {
    private String idRef;
    private String type;
  }
}
