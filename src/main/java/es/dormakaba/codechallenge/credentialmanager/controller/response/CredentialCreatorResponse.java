package es.dormakaba.codechallenge.credentialmanager.controller.response;

import java.util.UUID;

public class CredentialCreatorResponse {
    public UUID id;

    public CredentialCreatorResponse(){}

    public CredentialCreatorResponse(UUID id) {
        this.id=id;
    }
}
