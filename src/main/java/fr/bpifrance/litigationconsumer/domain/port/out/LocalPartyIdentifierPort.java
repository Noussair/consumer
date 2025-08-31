package fr.bpifrance.litigationconsumer.domain.port.out;

import fr.bpifrance.litigationconsumer.infrastructure.model.ws.response.LocalPartyIdentifierDto;

public interface LocalPartyIdentifierPort {

  String getLocalPartyIdentifier(String dosnum);
}
