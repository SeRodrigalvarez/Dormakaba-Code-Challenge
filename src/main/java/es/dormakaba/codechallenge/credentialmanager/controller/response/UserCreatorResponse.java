package es.dormakaba.codechallenge.credentialmanager.controller.response;

import java.util.UUID;

public class UserCreatorResponse {
    public final UUID id;
    public final String name;

    public UserCreatorResponse(UUID id, String name) {
        this.id=id;
        this.name=name;
    }
}
