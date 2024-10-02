package es.dormakaba.codechallenge.credentialmanager.domain;

public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
