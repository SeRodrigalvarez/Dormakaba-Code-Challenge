package es.dormakaba.codechallenge.credentialmanager.domain.exception;

public class CredentialAlreadyAddedException extends Exception {
    
    public CredentialAlreadyAddedException(String message) {
        super(message);
    }
}
