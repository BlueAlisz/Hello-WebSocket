package com.example.WebSocket.dao;

import com.example.WebSocket.model.Robot;

import java.util.List;
import java.util.Optional;

public interface RobotDao {

    int insertRobot(int id, Robot robot);

    default int insertRobot(Robot robot) {
        int id = 0;
        return insertRobot(id, robot);
    }

    List<Robot> selectAllRobot();

    Optional<Robot> selectRobotById(int id);

    int deleteRobotById(int id);

    int updateRobotById(int id, Robot robot);
}

