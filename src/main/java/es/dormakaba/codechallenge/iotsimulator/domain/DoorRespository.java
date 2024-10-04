package es.dormakaba.codechallenge.iotsimulator.domain;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorAlreadyExistsException;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorNotExistException;

@Repository
public interface DoorRespository {
    
    public void create(Door door) throws DoorAlreadyExistsException;

    public void update(Door door) throws DoorNotExistException;

    public Door getById(UUID id) throws DoorNotExistException;
}
