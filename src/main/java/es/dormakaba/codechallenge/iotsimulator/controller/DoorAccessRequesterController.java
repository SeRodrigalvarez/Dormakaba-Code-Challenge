package es.dormakaba.codechallenge.iotsimulator.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import es.dormakaba.codechallenge.iotsimulator.application.DoorAccessRequester;
import es.dormakaba.codechallenge.iotsimulator.domain.exception.DoorNotExistException;

@RestController
public class DoorAccessRequesterController {
    
    @Autowired
    private DoorAccessRequester doorAccessRequester;
    
    @GetMapping("/door/{doorId}/requestAccess/{code}")
    public boolean requestAccess(@PathVariable UUID doorId, @PathVariable String code) throws DoorNotExistException {
        return this.doorAccessRequester.requestAccess(doorId, code);
    }
}
