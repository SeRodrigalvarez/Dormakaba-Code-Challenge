package es.dormakaba.codechallenge.iotsimulator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import es.dormakaba.codechallenge.iotsimulator.application.DoorCreator;
import es.dormakaba.codechallenge.iotsimulator.controller.response.DoorCreatorResponse;
import es.dormakaba.codechallenge.iotsimulator.domain.Door;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorAlreadyExistsException;

@RestController
public class DoorCreatorController {

    @Autowired
    private DoorCreator doorCreator;
    
    @PostMapping("/door")
    public @ResponseBody DoorCreatorResponse create() throws DoorAlreadyExistsException {
        Door door = this.doorCreator.create();
        return new DoorCreatorResponse(door.getId());
    }
}
