package com.example.WebSocket.dao;

import com.example.WebSocket.model.Robot;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RobotDao {

    int insertPerson(UUID id, Robot robot);

    default int insertPerson(Robot robot) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, robot);
    }

    List<Robot> selectAllRobot();

    Optional<Robot> selectPersonById(UUID id);

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Robot robot);
}
