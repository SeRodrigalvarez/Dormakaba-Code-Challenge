package es.dormakaba.codechallenge.credentialmanager.domain;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialNotExistException;

@Repository
public interface CredentialRepository {

    public void create(Credential credential) throws CredentialAlreadyExistsException;

    public Credential getById(UUID id) throws CredentialNotExistException;
}
