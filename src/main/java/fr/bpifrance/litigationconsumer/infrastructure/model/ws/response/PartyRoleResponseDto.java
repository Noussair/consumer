package fr.bpifrance.litigationconsumer.infrastructure.model.ws.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class PartyRoleResponseDto {

  @JsonProperty("data")
  private List<DataWrapper> data;

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Getter
  public static class DataWrapper {
    @JsonProperty("node")
    private Node node;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Getter
  public static class Node {
    @JsonProperty("entity")
    private EntityWrapper entity;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Getter
  public static class EntityWrapper {
    @JsonProperty("payload")
    private Payload payload;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Getter
  public static class Payload {
    @JsonProperty("entity")
    private entity entity;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Getter
  public static class entity {
    @JsonProperty("eventCode")
    private eventCode eventCode;

    @JsonProperty("data")
    private data data;

    @JsonProperty("domain")
    private String domain;

    @JsonProperty("links")
    private List<links> links;

    @JsonProperty("type")
    private String type;

    @JsonProperty("idRef")
    private String idRef;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Getter
  public static class eventCode {
    @JsonProperty("operationCode")
    private String operationCode;

    @JsonProperty("reasonCode")
    private String reasonCode;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Getter
  public static class data {
    @JsonProperty("partyRoleCode")
    private String partyRoleCode;

    @JsonProperty("partyRoleReference")
    private String partyRoleReference;

    @JsonProperty("partyReference")
    private String partyReference;

    @JsonProperty("eventIdentifier")
    private String eventIdentifier;

    @JsonProperty("terminationDate")
    private String terminationDate;

    @JsonProperty("parRolesAdresses")
    private List<parRolesAdresses> parRolesAdresses;

    @JsonProperty("localPartyIdentifier")
    private String localPartyIdentifier;

    @JsonProperty("parRolesPaymentsModes")
    private List<parRolesPaymentsModes> parRolesPaymentsModes;

    @JsonProperty("customerAgreementLocIdentifier")
    private Long customerAgreementLocIdentifier;

    @JsonProperty("activationDate")
    private String activationDate;

    @JsonProperty("customerAgreementReference")
    private String customerAgreementReference;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Getter
  public static class parRolesAdresses {
    @JsonProperty("activationdate")
    private String activationdate;

    @JsonProperty("address3")
    private String address3;

    @JsonProperty("address1")
    private String address1;

    @JsonProperty("countrycode")
    private String countrycode;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Getter
  public static class parRolesPaymentsModes {
    @JsonProperty("paymentModeCode")
    private String paymentModeCode;

    @JsonProperty("partyIBAN")
    private String partyIBAN;

    @JsonProperty("activationDate")
    private String activationDate;

    @JsonProperty("paymentModeType")
    private String paymentModeType;
  }

  @JsonIgnoreProperties(ignoreUnknown = true)
  @Getter
  public static class links {
    @JsonProperty("idRef")
    private String idRef;

    @JsonProperty("type")
    private String type;
  }
}
