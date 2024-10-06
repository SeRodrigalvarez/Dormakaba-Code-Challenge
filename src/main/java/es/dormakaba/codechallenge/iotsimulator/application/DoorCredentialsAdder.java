package es.dormakaba.codechallenge.iotsimulator.application;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.iotsimulator.domain.Door;
import es.dormakaba.codechallenge.iotsimulator.domain.DoorRepository;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorNotExistException;

@Service
public class DoorCredentialsAdder {

    @Autowired
    private DoorRepository doorRepository;
    
    public void doorCredentialsAdder(UUID doorId, List<UUID> credentialIds) throws DoorNotExistException {
        Door door = this.doorRepository.getById(doorId);
        door.addCredentialIds(credentialIds);
        this.doorRepository.update(door);
    }
}
