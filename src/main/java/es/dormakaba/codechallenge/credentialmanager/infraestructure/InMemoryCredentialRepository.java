package es.dormakaba.codechallenge.credentialmanager.infraestructure;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import es.dormakaba.codechallenge.credentialmanager.domain.Credential;
import es.dormakaba.codechallenge.credentialmanager.domain.CredentialRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyExistsException;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialNotExistException;

@Component
public class InMemoryCredentialRepository implements CredentialRepository {

    private final List<Credential> credentialList = new ArrayList<>();

    @Override
    public void create(Credential credential) throws CredentialAlreadyExistsException {
        if (credentialList.contains(credential)) {
            throw new CredentialAlreadyExistsException("Credential with id " + credential.getId() + " already exists");
        }
        credentialList.add(credential);
    }

    @Override
    public void update(Credential credential) throws CredentialNotExistException {
        for (int i=0; i<credentialList.size(); i++) {
            if (credentialList.get(i).equals(credential)) {
                credentialList.add(i, credential);
                return;
            }
        }
        throw new CredentialNotExistException("Credential with id " + credential.getId() + " does not exist");
    }

    @Override
    public Credential getById(UUID id) throws CredentialNotExistException {
        for (Credential credential : credentialList) {
            if (credential.getId().equals(id)) {
                return credential.copy();
            }
        }
        throw new CredentialNotExistException("Credential with id " + id + " does not exist");
    }
}