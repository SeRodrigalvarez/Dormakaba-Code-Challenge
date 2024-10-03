package es.dormakaba.codechallenge.credentialmanager.infraestructure;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import es.dormakaba.codechallenge.credentialmanager.domain.Credential;
import es.dormakaba.codechallenge.credentialmanager.domain.CredentialRepository;
import es.dormakaba.codechallenge.credentialmanager.domain.exception.CredentialAlreadyExistsException;

@Component
public class InMemoryCredentialRepository implements CredentialRepository {

    private final List<Credential> credentialList = new ArrayList<>();

    @Override
    public void save(Credential credential) throws CredentialAlreadyExistsException {
        if (credentialList.contains(credential)) {
            throw new CredentialAlreadyExistsException("Credential with id " + credential.getId().toString() + " already exists");
        }
        credentialList.add(credential);
    }
    
}
