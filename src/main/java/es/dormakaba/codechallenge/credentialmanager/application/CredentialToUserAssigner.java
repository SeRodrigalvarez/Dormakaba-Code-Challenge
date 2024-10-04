package es.dormakaba.codechallenge.credentialmanager.application;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.credentialmanager.domain.Credential;
import es.dormakaba.codechallenge.credentialmanager.domain.CredentialRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.User;
import es.dormakaba.codechallenge.credentialmanager.domain.UserRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyAddedToUserException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialNotExistException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserNotExistException;

@Service
public class CredentialToUserAssigner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialRepository credentialRespository;

    public void assignCredentialToUser (UUID userId, UUID credentialId) 
    throws UserNotExistException, CredentialNotExistException, CredentialAlreadyAddedToUserException 
    {
        User user = userRepository.getById(userId);
        Credential credential = credentialRespository.getById(credentialId);
        user.addCredentialId(credential.getId());
        credential.setUserId(user.getId());
    }
    
}
