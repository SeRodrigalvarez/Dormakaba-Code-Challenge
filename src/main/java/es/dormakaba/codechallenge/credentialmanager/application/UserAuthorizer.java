package es.dormakaba.codechallenge.credentialmanager.application;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.credentialmanager.domain.Credential;
import es.dormakaba.codechallenge.credentialmanager.domain.CredentialRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.User;
import es.dormakaba.codechallenge.credentialmanager.domain.UserRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialNotExistException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserNotExistException;
import es.dormakaba.codechallenge.iotsimulator.application.DoorCredentialsAdder;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorNotExistException;

@Service
public class UserAuthorizer {

    @Autowired
    private DoorCredentialsAdder doorCredentialsAdder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CredentialRepository credentialRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserAuthorizer.class);

    public void authorize (UUID userId, UUID doorId) throws UserNotExistException, DoorNotExistException {
        User user = this.userRepository.getById(userId);
        this.doorCredentialsAdder.doorCredentialsAdder(doorId, user.getCredentialIds());
        Credential credential;
        // NOTE: We could use a repository method to bulk update credentials
        for (UUID credentialId : user.getCredentialIds()) {
            try {
                credential = this.credentialRepository.getById(credentialId);
                credential.addDoorId(doorId);
                this.credentialRepository.update(credential);
            } catch (CredentialNotExistException e) {
                logger.error("Unexpected CredentialNotExistException at UserAuthorizer use case");
            }
        }
    }
}
