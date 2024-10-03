package es.dormakaba.codechallenge.credentialmanager.application;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.credentialmanager.domain.User;
import es.dormakaba.codechallenge.credentialmanager.domain.UserRepository;

@Service
public class UserReader {
    
    @Autowired
    private UserRepository userRepository;

    public User getById(UUID id) {
        return this.userRepository.getById(id);
    }
}
