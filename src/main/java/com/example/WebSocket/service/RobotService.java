package com.example.WebSocket.service;

import com.example.WebSocket.dao.RobotDao;
import com.example.WebSocket.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RobotService {

    private final RobotDao robotDao;

    @Autowired
    public RobotService(@Qualifier("fakeDao") RobotDao robotDao) {
        this.robotDao = robotDao;
    }

    public int addPerson(Robot robot) {
        return robotDao.insertPerson(robot);
    }

    public List<Robot> getAllPeople() {
        return robotDao.selectAllRobot();
    }

    public Optional<Robot> getPersonById(UUID id) {
        return robotDao.selectPersonById(id);
    }

    public int deletePerson(UUID id) {
        return robotDao.deletePersonById(id);
    }

    public int updatePerson(UUID id, Robot newRobot) {
        return robotDao.updatePersonById(id, newRobot);
    }
}
