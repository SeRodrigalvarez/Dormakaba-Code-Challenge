package es.dormakaba.codechallenge.credentialmanager.infraestructure;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import es.dormakaba.codechallenge.credentialmanager.domain.User;
import es.dormakaba.codechallenge.credentialmanager.domain.UserRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserNotExistException;

@Component
public class InMemoryUserRepository implements UserRepository{

    private final List<User> userList = new ArrayList<>();

    @Override
    public void create(User user) throws UserAlreadyExistsException {
        if (userList.contains(user)) {
            throw new UserAlreadyExistsException("User with id " + user.getId() + " already exists");
        }
        userList.add(user);
    }

    @Override
    public void update(User user) throws UserNotExistException {
        for (int i=0; i<userList.size(); i++) {
            if (userList.get(i).equals(user)) {
                userList.add(i, user);
                return;
            }
        }
        throw new UserNotExistException("User with id " + user.getId() + " does not exist");
    }

    @Override
    public User getById(UUID id) throws UserNotExistException {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user.copy();
            }
        }
        throw new UserNotExistException("User with id " + id + " does not exist");
    }
}