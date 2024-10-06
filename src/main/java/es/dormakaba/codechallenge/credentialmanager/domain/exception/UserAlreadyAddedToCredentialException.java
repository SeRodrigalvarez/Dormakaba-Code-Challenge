package es.dormakaba.codechallenge.credentialmanager.domain.exception;

public class UserAlreadyAddedToCredentialException extends Exception {
    
    public UserAlreadyAddedToCredentialException(String message) {
        super(message);
    }
}
