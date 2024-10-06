package es.dormakaba.codechallenge.credentialmanager.controller.response;

import java.util.UUID;

public class UserCreatorResponse {
    public UUID id;
    public String name;

    public UserCreatorResponse() {}

    public UserCreatorResponse(UUID id, String name) {
        this.id=id;
        this.name=name;
    }
}
