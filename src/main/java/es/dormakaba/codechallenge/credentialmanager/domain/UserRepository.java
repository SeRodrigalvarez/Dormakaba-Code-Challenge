package es.dormakaba.codechallenge.credentialmanager.domain;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.UserNotExistException;

@Repository
public interface UserRepository {

    public void create(User user) throws UserAlreadyExistsException;

    public void update(User user) throws UserNotExistException;

    public User getById(UUID id);
}
