package es.dormakaba.codechallenge.iotsimulator.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.iotsimulator.domain.Door;
import es.dormakaba.codechallenge.iotsimulator.domain.DoorRespository;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorAlreadyExistsException;

@Service
public class DoorCreator {

    @Autowired
    DoorRespository doorRespository;

    public Door create() throws DoorAlreadyExistsException {
        Door door = Door.create();
        this.doorRespository.create(door);
        return door;
    }
    
}
