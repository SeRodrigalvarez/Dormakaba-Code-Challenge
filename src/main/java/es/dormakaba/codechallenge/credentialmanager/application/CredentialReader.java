package es.dormakaba.codechallenge.credentialmanager.application;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.credentialmanager.domain.CredentialRepository;

@Service
public class CredentialReader {

    @Autowired
    private CredentialRepository credentialRespository;
    
    public List<UUID> getCredentialIdsByCodeAndDoorId(String code, UUID doorId) {
        return this.credentialRespository.getCredentialIdsByCodeAndDoorId(code, doorId);
    }
}
