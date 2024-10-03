package es.dormakaba.codechallenge.credentialmanager.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.credentialmanager.domain.Credential;
import es.dormakaba.codechallenge.credentialmanager.domain.CredentialRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.ValidationException;

@Service
public class CredentialCreator {

    @Autowired
    private CredentialRepository credentialRepository;

    public Credential create(String code) throws ValidationException, CredentialAlreadyExistsException {
        Credential credential = Credential.create(code);
        this.credentialRepository.save(credential);
        return credential;
    }
    
}
