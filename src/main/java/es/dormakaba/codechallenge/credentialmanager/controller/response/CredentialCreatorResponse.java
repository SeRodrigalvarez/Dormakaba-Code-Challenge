package es.dormakaba.codechallenge.credentialmanager.controller.response;

import java.util.UUID;

public class CredentialCreatorResponse {
    public final UUID id;
    public final String code;

    public CredentialCreatorResponse(UUID id, String code) {
        this.id=id;
        this.code=code;
    }
}
