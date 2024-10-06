package es.dormakaba.codechallenge.iotsimulator.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Door {
    
    private final UUID id;

    // NOTE: Out of the scope of this challenge, but it should have, at least, an address property
    //private final String address;

    private final List<UUID> credentialIds;

    private Door() {
        this.id=UUID.randomUUID();
        this.credentialIds=new ArrayList<>();
    }

    private Door(UUID id, List<UUID> credentialIds) {
        this.id=id;
        this.credentialIds=credentialIds;
    }

    public static Door create() {
        return new Door();
    }

    public void addCredentialIds(List<UUID> credentialIdsToAdd) {
        for (UUID idToAdd : credentialIdsToAdd) {
            if (!this.credentialIds.contains(idToAdd)) {
                this.credentialIds.add(idToAdd);
            }
        }
    }

    public void removeCredentialIds(List<UUID> crendentialIdsToRemove) {
        for (UUID idToRemove : crendentialIdsToRemove) {
            this.credentialIds.remove(idToRemove);
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
        return new Door(this.id, new ArrayList<>(this.credentialIds));
    }

    public UUID getId() {
        return this.id;
    }
}
