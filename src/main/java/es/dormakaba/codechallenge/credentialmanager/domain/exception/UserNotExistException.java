package es.dormakaba.codechallenge.credentialmanager.domain.exception;

public class UserNotExistException extends Exception {
    
    public UserNotExistException(String message) {
        super(message);
    }
}
