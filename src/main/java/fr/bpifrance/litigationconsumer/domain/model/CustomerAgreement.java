package fr.bpifrance.litigationconsumer.domain.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.List;

@Value
public class CustomerAgreement {

  EventEntity entity;

  @JsonCreator
  public CustomerAgreement(@JsonProperty("entity") EventEntity entity) {
    this.entity = entity;
  }

  @Value
  public static class EventEntity {
    EventCode eventCode;
    CustomerAgreementData data;
    String domain;
    String type;
    String idRef;

    @JsonCreator
    public EventEntity(
        @JsonProperty("eventCode") EventCode eventCode,
        @JsonProperty("data") CustomerAgreementData data,
        @JsonProperty("domain") String domain,
        @JsonProperty("type") String type,
        @JsonProperty("idRef") String idRef) {
      this.eventCode = eventCode;
      this.data = data;
      this.domain = domain;
      this.type = type;
      this.idRef = idRef;
    }
  }

  @Value
  public static class EventCode {
    String reasonCode;
    String operationCode;

    @JsonCreator
    public EventCode(
        @JsonProperty("reasonCode") String reasonCode,
        @JsonProperty("operationCode") String operationCode) {
      this.reasonCode = reasonCode;
      this.operationCode = operationCode;
    }
  }

  @Value
  public static class CustomerAgreementData {
    String customerAgreementManagementEntity;
    String financialProductCode;
    String businessTypeCode;
    String applicationIdentifier;
    String eventIdentifier;
    Descriptions descriptions;
    String customerAgreementCode;
    TermsAndConditions termsAndConditions;
    String managingEntity;
    List<OperationalOrganisation> operationalOrganisation;
    String customerAgreementAmendment;
    String customerAgreementReferenceRisk;
    long customerAgreementLocIdentifier;
    String customerAgreementReference;

    String innovationProgramEndDate;
    String legacyProductCode;
    String innovationExternalReference;
    String innovationFranchisePeriodEndDate;
    String innovativeProjectObjective;
    Double basisAidInnovationProject;
    String subBusinessCase;
    String parentCustomerAgreementReference;
    String ICS;
    String expenseRecognitionDate;
    String mandateSEPA;

    @JsonCreator
    public CustomerAgreementData(
        @JsonProperty("customerAgreementManagementEntity") String customerAgreementManagementEntity,
        @JsonProperty("financialProductCode") String financialProductCode,
        @JsonProperty("businessTypeCode") String businessTypeCode,
        @JsonProperty("applicationIdentifier") String applicationIdentifier,
        @JsonProperty("eventIdentifier") String eventIdentifier,
        @JsonProperty("descriptions") Descriptions descriptions,
        @JsonProperty("customerAgreementCode") String customerAgreementCode,
        @JsonProperty("termsAndConditions") TermsAndConditions termsAndConditions,
        @JsonProperty("managingEntity") String managingEntity,
        @JsonProperty("operationalOrganisation")
            List<OperationalOrganisation> operationalOrganisation,
        @JsonProperty("customerAgreementAmendment") String customerAgreementAmendment,
        @JsonProperty("customerAgreementReferenceRisk") String customerAgreementReferenceRisk,
        @JsonProperty("customerAgreementLocIdentifier") Long customerAgreementLocIdentifier,
        @JsonProperty("customerAgreementReference") String customerAgreementReference,
        @JsonProperty("innovationProgramEndDate") String innovationProgramEndDate,
        @JsonProperty("legacyProductCode") String legacyProductCode,
        @JsonProperty("innovationExternalReference") String innovationExternalReference,
        @JsonProperty("innovationFranchisePeriodEndDate") String innovationFranchisePeriodEndDate,
        @JsonProperty("innovativeProjectObjective") String innovativeProjectObjective,
        @JsonProperty("basisAidInnovationProject") Double basisAidInnovationProject,
        @JsonProperty("subBusinessCase") String subBusinessCase,
        @JsonProperty("parentCustomerAgreementReference") String parentCustomerAgreementReference,
        @JsonProperty("ICS") String ICS,
        @JsonProperty("expenseRecognitionDate") String expenseRecognitionDate,
        @JsonProperty("mandateSEPA") String mandateSEPA) {
      this.customerAgreementManagementEntity = customerAgreementManagementEntity;
      this.financialProductCode = financialProductCode;
      this.businessTypeCode = businessTypeCode;
      this.applicationIdentifier = applicationIdentifier;
      this.eventIdentifier = eventIdentifier;
      this.descriptions = descriptions;
      this.customerAgreementCode = customerAgreementCode;
      this.termsAndConditions = termsAndConditions;
      this.managingEntity = managingEntity;
      this.operationalOrganisation = operationalOrganisation;
      this.customerAgreementAmendment = customerAgreementAmendment;
      this.customerAgreementReferenceRisk = customerAgreementReferenceRisk;
      this.customerAgreementLocIdentifier =
          (customerAgreementLocIdentifier != null) ? customerAgreementLocIdentifier : 0L;
      this.customerAgreementReference = customerAgreementReference;
      this.innovationProgramEndDate = innovationProgramEndDate;
      this.legacyProductCode = legacyProductCode;
      this.innovationExternalReference = innovationExternalReference;
      this.innovationFranchisePeriodEndDate = innovationFranchisePeriodEndDate;
      this.innovativeProjectObjective = innovativeProjectObjective;
      this.basisAidInnovationProject = basisAidInnovationProject;
      this.subBusinessCase = subBusinessCase;
      this.parentCustomerAgreementReference = parentCustomerAgreementReference;
      this.ICS = ICS;
      this.expenseRecognitionDate = expenseRecognitionDate;
      this.mandateSEPA = mandateSEPA;
    }

    @Value
    public static class Descriptions {
      String customerAgreementName;
      String fundingPurpose;
      String debtOwnerPartyIdentifier;

      @JsonCreator
      public Descriptions(
          @JsonProperty("customerAgreementName") String customerAgreementName,
          @JsonProperty("fundingPurpose") String fundingPurpose,
          @JsonProperty("debtOwnerPartyIdentifier") String debtOwnerPartyIdentifier) {
        this.customerAgreementName = customerAgreementName;
        this.fundingPurpose = fundingPurpose;
        this.debtOwnerPartyIdentifier = debtOwnerPartyIdentifier;
      }
    }

    @Value
    public static class TermsAndConditions {
      String terminationDate;
      String financingPoolType;
      double commitedAmount;
      double totalAllocatedAgreementAmount;
      double totalAgreementAmount;
      String commitmentDate;
      String estimatedStartDate;
      String offerIssueDate;
      String signatureLimitDate;
      String startDate;
      String signatureDate;
      String withdrawalExpiryDate;

      @JsonCreator
      public TermsAndConditions(
          @JsonProperty("terminationDate") String terminationDate,
          @JsonProperty("financingPoolType") String financingPoolType,
          @JsonProperty("commitedAmount")
              Double commitedAmount, // Changed to Double for null safety
          @JsonProperty("totalAllocatedAgreementAmount")
              Double totalAllocatedAgreementAmount, // Changed to Double for null safety
          @JsonProperty("totalAgreementAmount")
              Double totalAgreementAmount, // Changed to Double for null safety
          @JsonProperty("commitmentDate") String commitmentDate,
          @JsonProperty("estimatedStartDate") String estimatedStartDate,
          @JsonProperty("offerIssueDate") String offerIssueDate,
          @JsonProperty("signatureLimitDate") String signatureLimitDate,
          @JsonProperty("startDate") String startDate,
          @JsonProperty("signatureDate") String signatureDate,
          @JsonProperty("withdrawalExpiryDate") String withdrawalExpiryDate) {
        this.terminationDate = terminationDate;
        this.financingPoolType = financingPoolType;
        this.commitedAmount = (commitedAmount != null) ? commitedAmount : 0.0;
        this.totalAllocatedAgreementAmount =
            (totalAllocatedAgreementAmount != null) ? totalAllocatedAgreementAmount : 0.0;
        this.totalAgreementAmount = (totalAgreementAmount != null) ? totalAgreementAmount : 0.0;
        this.commitmentDate = commitmentDate;
        this.estimatedStartDate = estimatedStartDate;
        this.offerIssueDate = offerIssueDate;
        this.signatureLimitDate = signatureLimitDate;
        this.startDate = startDate;
        this.signatureDate = signatureDate;
        this.withdrawalExpiryDate = withdrawalExpiryDate;
      }
    }

    @Value
    public static class OperationalOrganisation {
      String cusAgrManagementDepartment;
      String cusAgrManagerEmployeeIdentif;
      Integer principalManagerInCharge;

      @JsonCreator
      public OperationalOrganisation(
          @JsonProperty("cusAgrManagementDepartment") String cusAgrManagementDepartment,
          @JsonProperty("cusAgrManagerEmployeeIdentif") String cusAgrManagerEmployeeIdentif,
          @JsonProperty("principalManagerInCharge") Integer principalManagerInCharge) {
        this.cusAgrManagementDepartment = cusAgrManagementDepartment;
        this.cusAgrManagerEmployeeIdentif = cusAgrManagerEmployeeIdentif;
        this.principalManagerInCharge = principalManagerInCharge;
      }
    }
  }
}
