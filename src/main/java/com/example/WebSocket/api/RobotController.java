package com.example.WebSocket.api;

import com.example.WebSocket.model.Robot;
import com.example.WebSocket.service.RobotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class RobotController {

    private final RobotService robotService;

    @Autowired
    public RobotController(RobotService robotService) {
        this.robotService = robotService;
    }

    @PostMapping
    public void addPerson(@Validated @NonNull @RequestBody Robot robot) {
        robotService.addPerson(robot);
    }

    @GetMapping
    public List<Robot> getAllPeople() {
        return robotService.getAllPeople();
    }

    @GetMapping(path = "{id}")
    public Robot getPersonById(@PathVariable("id") int id) {
        return robotService.getPersonById(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") int id){
        robotService.deletePerson(id);
    }

    @PutMapping(path = "{id}")
    public void updatePerson(@PathVariable("id") int id, @Validated @NonNull @RequestBody Robot robotToUpdate) {
        robotService.updatePerson(id, robotToUpdate);
    }
}
