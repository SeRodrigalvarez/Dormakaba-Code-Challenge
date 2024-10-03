package es.dormakaba.codechallenge.credentialmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.dormakaba.codechallenge.credentialmanager.application.CredentialCreator;
import es.dormakaba.codechallenge.credentialmanager.controller.request.CredentialCreatorRequest;
import es.dormakaba.codechallenge.credentialmanager.controller.response.CredentialCreatorResponse;
import es.dormakaba.codechallenge.credentialmanager.domain.Credential;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.ValidationException;

@RestController
public class CredentialCreatorController {
    
    @Autowired
    private CredentialCreator credentialCreator;

    @PostMapping("/credential")
    public @ResponseBody CredentialCreatorResponse create(@RequestBody CredentialCreatorRequest request) throws ValidationException, CredentialAlreadyExistsException {
        Credential credential = this.credentialCreator.create(request.code);
        return new CredentialCreatorResponse(credential.getId(), credential.getCode());
    }
}
