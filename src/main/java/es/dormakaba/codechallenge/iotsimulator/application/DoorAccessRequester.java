package es.dormakaba.codechallenge.iotsimulator.application;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.credentialmanager.application.CredentialReader;
import es.dormakaba.codechallenge.iotsimulator.domain.DoorRespository;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorNotExistException;

@Service
public class DoorAccessRequester {

    @Autowired
    private CredentialReader credentialReader;

    @Autowired
    private DoorRespository doorRespository;
    
    public boolean requestAccess(UUID doorId, String code) throws DoorNotExistException {

        this.doorRespository.getById(doorId);
        
        List<UUID> matchingCredentialIds = credentialReader.getCredentialIdsByCodeAndDoorId(code, doorId);

        return !matchingCredentialIds.isEmpty();
    } 
}
