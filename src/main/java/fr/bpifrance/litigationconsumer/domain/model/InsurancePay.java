package fr.bpifrance.litigationconsumer.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public record InsurancePay(
    @JsonProperty("actcode") String actCode,
    @JsonProperty("rolcode") String roleCode,
    @JsonProperty("actcodegest") String actCodeGest) {}
