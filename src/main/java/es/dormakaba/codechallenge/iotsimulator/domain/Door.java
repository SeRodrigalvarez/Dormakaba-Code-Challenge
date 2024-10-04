package es.dormakaba.codechallenge.iotsimulator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Door {
    
    private final UUID id;

    // Out of the scope of this challenge, but it should have, at least, an address property
    //private final String address;

    private final List<UUID> credentialIds = new ArrayList<>();

    private Door() {
        this.id=UUID.randomUUID();
    }

    private Door(UUID id) {
        this.id=id;
    }

    public static Door create() {
        return new Door();
    }

    public void addCredentialIds(List<UUID> credentialIds) {
        for (UUID idToAdd : credentialIds) {
            if (!this.credentialIds.contains(idToAdd)) {
                this.credentialIds.add(idToAdd);
            }
        }
    }

    public List<UUID> getCredentialIds() {
        return List.copyOf(this.credentialIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Door door) {
            return door.id.equals(this.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    public Door copy() {
        return new Door(this.id);
    }

    public UUID getId() {
        return this.id;
    }
}
