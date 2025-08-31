package fr.bpifrance.litigationconsumer.infrastructure.model.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LocalPartyIdentifierDto(@JsonProperty("ACTCODE") String localPartyIdentifier) {}
