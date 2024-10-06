package es.dormakaba.codechallenge.credentialmanager.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import es.dormakaba.codechallenge.credentialmanager.application.UserRevoker;
import es.dormakaba.codechallenge.credentialmanager.controller.request.UserRevokerRequest;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserNotExistException;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorNotExistException;

@RestController
public class UserRevokerController {

    @Autowired
    private UserRevoker userRevoker;

    @PostMapping("/user/{userId}/revoke")
    public String revoke(@PathVariable UUID userId, @RequestBody UserRevokerRequest request) throws UserNotExistException, DoorNotExistException {
        this.userRevoker.revoke(userId, request.doorId);
        return "OK";
    }
}
