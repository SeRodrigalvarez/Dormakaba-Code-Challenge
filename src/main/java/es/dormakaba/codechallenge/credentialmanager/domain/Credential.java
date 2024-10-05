package es.dormakaba.codechallenge.credentialmanager.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import es.dormakaba.codechallenge.credentialmanager.domain.exception.ValidationException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Pattern;

public class Credential {

    private static final int SIZE = 8;

    private final static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
    
    private final UUID id;
    @Pattern(regexp="[0-9]{"+SIZE+"}", message="Code must be an 8 digit string")
    private final String code;

    private UUID userId;

    private final List<UUID> doorIds;

    private Credential(String code) {
        this.id=UUID.randomUUID();
        this.code=code;
        this.doorIds=new ArrayList<>();
    }

    private Credential(UUID id, String code) {
        this.id=id;
        this.code=code;
    }

    public static Credential create (String code) throws ValidationException {
        Credential credential = new Credential(code);
        Set<ConstraintViolation<Credential>> violations = validator.validate(credential);
		if (!violations.isEmpty()) {
            for (ConstraintViolation<Credential> violation : violations) {
                throw new ValidationException(violation.getMessage());
            }
        }
        return credential;
    }

    public void setUserId(UUID userId) {
        this.userId=userId;
    }

    public void addDoorId(UUID doorId) {
        if (!this.doorIds.contains(doorId)) {
            this.doorIds.add(doorId);
        }
    }

    public List<UUID> getDoorIds() {
        return List.copyOf(this.doorIds);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Credential credential) {
            return credential.id.equals(this.id);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    public Credential copy() {
        return new Credential(this.id, this.code);
    }

    public UUID getId() {
        return this.id;
    }

    public String getCode() {
        return this.code;
    }

    public UUID getUserId() {
        return this.userId;
    }
}
