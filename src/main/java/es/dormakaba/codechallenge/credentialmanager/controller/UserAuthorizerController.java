package es.dormakaba.codechallenge.credentialmanager.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.dormakaba.codechallenge.credentialmanager.application.UserAuthorizer;
import es.dormakaba.codechallenge.credentialmanager.controller.request.UserAuthorizerRequest;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserNotExistException;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorNotExistException;

@RestController
public class UserAuthorizerController {
    
    @Autowired
    private UserAuthorizer userAuthorizer;

    @PostMapping("/user/{userId}/authorize")
    public String authorize(@PathVariable UUID userId, @RequestBody UserAuthorizerRequest request) throws UserNotExistException, DoorNotExistException {
        this.userAuthorizer.authorize(userId, request.doorId);
        return "OK";
    }
}