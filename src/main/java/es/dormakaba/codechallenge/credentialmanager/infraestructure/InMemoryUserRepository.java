package es.dormakaba.codechallenge.credentialmanager.infraestructure;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import es.dormakaba.codechallenge.credentialmanager.domain.User;
import es.dormakaba.codechallenge.credentialmanager.domain.UserRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserAlreadyExistsException;

@Component
public class InMemoryUserRepository implements UserRepository{

    private final List<User> userList = new ArrayList<>();

    @Override
    public void save(User user) throws UserAlreadyExistsException {
        if (userList.contains(user)) {
            throw new UserAlreadyExistsException("User with id " + user.getId().toString() + " already exists");
        }
        userList.add(user);
    }

    @Override
    public User getById(UUID id) {
        for (User user : userList) {
            if (user.getId().equals(id)) {
                return user.copy();
            }
        }
        return null;
    }
}
