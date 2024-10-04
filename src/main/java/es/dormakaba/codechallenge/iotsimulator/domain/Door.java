package es.dormakaba.codechallenge.iotsimulator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import es.dormakaba.codechallenge.iotsimulator.domain.exception.CredentialAlreadyAddedToDoorException;

public class Door {
    
    private final UUID id;

    // Out of the scope of this challenge, but it should have, at least, an address property
    //private final String address;

    private List<UUID> credentialIds = new ArrayList<>();

    private Door() {
        this.id=UUID.randomUUID();
    }

    private Door(UUID id) {
        this.id=id;
    }

    public static Door create() {
        return new Door();
    }

    public void addCredentialId(UUID credentialId) throws CredentialAlreadyAddedToDoorException {
        if (this.credentialIds.contains(credentialId)) {
            throw new CredentialAlreadyAddedToDoorException("Door with id " + this.id + " already has the credential with id " + credentialId);
        }
        this.credentialIds.add(credentialId);
    }

    public Door copy() {
        return new Door(this.id);
    }

    public UUID getId() {
        return this.id;
    }
}
