package es.dormakaba.codechallenge.iotsimulator.infraestructure;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

import es.dormakaba.codechallenge.iotsimulator.domain.Door;
import es.dormakaba.codechallenge.iotsimulator.domain.DoorRespository;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorAlreadyExistsException;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorNotExistException;

@Component
public class InMemoryDoorRepository implements DoorRespository {

    private final List<Door> doorList = new ArrayList<>();

    @Override
    public void create(Door door) throws DoorAlreadyExistsException {
        if (doorList.contains(door)) {
            throw new DoorAlreadyExistsException("Door with id " + door.getId() + " already exists");
        }
        doorList.add(door);
    }

    @Override
    public void update(Door door) throws DoorNotExistException {
        for (int i=0; i<doorList.size(); i++) {
            if (doorList.get(i).equals(door)) {
                doorList.add(i, door);
                return;
            }
        }
        throw new DoorNotExistException("Door with id " + door.getId() + " does not exist");
    }

    @Override
    public Door getById(UUID id) throws DoorNotExistException {
        for (Door door : doorList) {
            if (door.getId().equals(id)) {
                return door.copy();
            }
        }
        throw new DoorNotExistException("Door with id " + id + " does not exist");
    }
    
}
