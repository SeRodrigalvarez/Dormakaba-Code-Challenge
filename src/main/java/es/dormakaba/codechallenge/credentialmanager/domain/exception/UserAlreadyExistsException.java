package es.dormakaba.codechallenge.credentialmanager.domain.exception;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
