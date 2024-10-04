package es.dormakaba.codechallenge.credentialmanager.domain.exception;

public class CredentialAlreadyAddedToUserException extends Exception {
    
    public CredentialAlreadyAddedToUserException(String message) {
        super(message);
    }
}
