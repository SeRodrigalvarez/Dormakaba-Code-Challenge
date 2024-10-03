package es.dormakaba.codechallenge.credentialmanager.application;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.credentialmanager.domain.Credential;
import es.dormakaba.codechallenge.credentialmanager.domain.CredentialRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.User;
import es.dormakaba.codechallenge.credentialmanager.domain.UserRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyAddedException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialNotExistException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserNotExistException;

@Service
public class CredentialToUserAssigner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialRepository credentialRespository;

    public void assignCredentialToUser (UUID userId, UUID credentialId) 
    throws UserNotExistException, CredentialNotExistException, CredentialAlreadyAddedException 
    {
        User user = userRepository.getById(userId);
        if (user==null) {
            throw new UserNotExistException("User with id " + userId + " does not exist");
        }
        Credential credential = credentialRespository.getById(credentialId);
        if (credential==null) {
            throw new CredentialNotExistException("Credential with id " + credentialId + " does not exist");
        }
        user.addCredential(credential);
    }
    
}
