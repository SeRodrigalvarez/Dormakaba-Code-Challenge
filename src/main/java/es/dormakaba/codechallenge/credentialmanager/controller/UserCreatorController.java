package es.dormakaba.codechallenge.credentialmanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.dormakaba.codechallenge.credentialmanager.application.UserCreator;
import es.dormakaba.codechallenge.credentialmanager.controller.request.UserCreatorRequest;
import es.dormakaba.codechallenge.credentialmanager.controller.response.UserCreatorResponse;
import es.dormakaba.codechallenge.credentialmanager.domain.User;
import es.dormakaba.codechallenge.credentialmanager.domain.UserAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.ValidationException;

@RestController
public class UserCreatorController {

    @Autowired
    private UserCreator userCreator;
    
    @PostMapping("/user")
    public @ResponseBody UserCreatorResponse create(@RequestBody UserCreatorRequest request) throws ValidationException, UserAlreadyExistsException {
        User user = userCreator.create(request.name);
        return new UserCreatorResponse(user.getId(), user.getName());
    }
}
