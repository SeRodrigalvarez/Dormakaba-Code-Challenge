package es.dormakaba.codechallenge.credentialmanager.domain;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import es.dormakaba.codechallenge.credentialmanager.domain.exception.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Size;

public class User {

    private static final int MIN = 2;
    private static final int MAX = 50;

    private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    private final UUID id;
    @Size(min=User.MIN, max=User.MAX, message="The size of name must be between " + User.MIN + " and " + User.MAX)
    private final String name;
    
    private User(String name) {
        this.id=UUID.randomUUID();
        this.name=name;
    }

    private User(UUID id, String name) {
        this.id=id;
        this.name=name;
    }
    
    public static User create (String name) throws ValidationException {
        User user = new User(name);
        Set<ConstraintViolation<User>> violations = validator.validate(user);
		if (!violations.isEmpty()) {
            for (ConstraintViolation<User> violation : violations) {
                throw new ValidationException(violation.getMessage());
            }
        }
        return user;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User user) {
            return user.id.equals(this.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    public User copy()  {
        return new User(this.id, this.name);
    }

    public UUID getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
