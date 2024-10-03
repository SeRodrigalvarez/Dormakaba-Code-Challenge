package es.dormakaba.codechallenge.credentialmanager.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.credentialmanager.domain.User;
import es.dormakaba.codechallenge.credentialmanager.domain.UserRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.ValidationException;

@Service
public class UserCreator {

    @Autowired
    private UserRepository userRepository;
    
    public User create(String name) throws ValidationException, UserAlreadyExistsException {
        User user = User.create(name);
        this.userRepository.save(user);
        return user;
    }
}
