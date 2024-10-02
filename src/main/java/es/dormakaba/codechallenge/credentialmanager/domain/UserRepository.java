package es.dormakaba.codechallenge.credentialmanager.domain;

import java.util.UUID;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    public void save(User user) throws UserAlreadyExistsException;

    public User getById(UUID id);
}
