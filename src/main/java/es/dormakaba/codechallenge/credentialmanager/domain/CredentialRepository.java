package es.dormakaba.codechallenge.credentialmanager.domain;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialNotExistException;

@Repository
public interface CredentialRepository {

    public void create(Credential credential) throws CredentialAlreadyExistsException;

    public void update(Credential credential) throws CredentialNotExistException;

    public Credential getById(UUID id) throws CredentialNotExistException;

    // NOTE: We should use Criteria/Specification Pattern
    public List<UUID> getCredentialIdsByCodeAndDoorId(String code, UUID doorId);
}
