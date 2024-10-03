package es.dormakaba.codechallenge.credentialmanager.domain.exception;

public class CredentialAlreadyExistsException extends Exception {

    public CredentialAlreadyExistsException(String message) {
        super(message);
    }
}
