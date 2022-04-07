package com.example.WebSocket.service;

import com.example.WebSocket.dao.RobotDao;
import com.example.WebSocket.model.Robot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RobotService {

    private final RobotDao robotDao;

    @Autowired
    public RobotService(@Qualifier("fakeDao") RobotDao robotDao) {
        this.robotDao = robotDao;
    }

    public int addPerson(Robot robot) {
        return robotDao.insertRobot(robot);
    }

    public List<Robot> getAllPeople() {
        return robotDao.selectAllRobot();
    }

    public Optional<Robot> getPersonById(int id) {
        return robotDao.selectRobotById(id);
    }

    public int deletePerson(int id) {
        return robotDao.deleteRobotById(id);
    }

    public int updatePerson(int id, Robot newRobot) {
        return robotDao.updateRobotById(id, newRobot);
    }
}
