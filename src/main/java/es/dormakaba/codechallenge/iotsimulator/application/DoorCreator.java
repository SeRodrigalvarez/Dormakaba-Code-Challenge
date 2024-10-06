package es.dormakaba.codechallenge.iotsimulator.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.dormakaba.codechallenge.iotsimulator.domain.Door;
import es.dormakaba.codechallenge.iotsimulator.domain.DoorRepository;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorAlreadyExistsException;

@Service
public class DoorCreator {

    @Autowired
    private DoorRepository doorRepository;

    public Door create() throws DoorAlreadyExistsException {
        Door door = Door.create();
        this.doorRepository.create(door);
        return door;
    }
    
}
