package com.example.WebSocket.dao;

import com.example.WebSocket.model.Robot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository("fakeDao")
public class FakeRobotDataAccessService implements RobotDao {

    private static List<Robot> DB = new ArrayList<>();
    int count = 0;

    @Override
    public int insertRobot(int id, Robot robot) {
        count++;
        id = count;
        DB.add(new Robot(id, robot.getName(),robot.getHp(),robot.getAttck()));
        return 1;
    }

    @Override
    public List<Robot> selectAllRobot() {
        return DB;
    }

    @Override //Optional เอามาใช้ในการจัดการกับ NullPointerExceptions
    public Optional<Robot> selectRobotById(int id) {
        return DB.stream()
                .filter(robot -> robot.getId() == id)
                .findFirst();
    }

    @Override
    public int deleteRobotById(int id) {
        Optional<Robot> personMaybe = selectRobotById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updateRobotById(int id, Robot update) {
        return selectRobotById(id)
                .map(robot -> {
                    int indexOfPersonToUpdate = DB.indexOf(robot);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Robot(id, update.getName(),update.getHp(),update.getAttck()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
