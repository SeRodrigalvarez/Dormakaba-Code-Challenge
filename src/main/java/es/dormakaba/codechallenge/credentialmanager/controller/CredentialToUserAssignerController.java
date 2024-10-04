package es.dormakaba.codechallenge.credentialmanager.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.dormakaba.codechallenge.credentialmanager.application.CredentialToUserAssigner;
import es.dormakaba.codechallenge.credentialmanager.controller.request.CredentialToUserAssginerRequest;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyAddedToUserException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialNotExistException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserNotExistException;

@RestController
public class CredentialToUserAssignerController {

    @Autowired
    private CredentialToUserAssigner credentialToUserAssigner;

    @PostMapping("/user/{userId}/assign")
    public String assignCredentialToUser
    (
        @PathVariable UUID userId,
        @RequestBody CredentialToUserAssginerRequest request
    ) 
    throws UserNotExistException, CredentialNotExistException, CredentialAlreadyAddedToUserException 
    {
        this.credentialToUserAssigner.assignCredentialToUser(userId, request.credentialId);
        return "OK";
    }
    
}
