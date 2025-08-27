package fr.bpifrance.litigationconsumer.infrastructure.model.ws.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TupcodeDto(@JsonProperty("TUPCODE") String value) {}
