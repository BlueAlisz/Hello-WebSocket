package com.example.WebSocket.dao;

import com.example.WebSocket.model.Robot;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeRobotDataAccessService implements RobotDao {

    private static List<Robot> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Robot robot) {
        DB.add(new Robot(id, robot.getName()));
        return 1;
    }

    @Override
    public List<Robot> selectAllRobot() {
        return DB;
    }

    @Override //Optional เอามาใช้ในการจัดการกับ NullPointerExceptions
    public Optional<Robot> selectPersonById(UUID id) {
        return DB.stream()
                .filter(robot -> robot.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonById(UUID id) {
        Optional<Robot> personMaybe = selectPersonById(id);
        if (personMaybe.isEmpty()) {
            return 0;
        }
        DB.remove(personMaybe.get());
        return 1;
    }

    @Override
    public int updatePersonById(UUID id, Robot update) {
        return selectPersonById(id)
                .map(robot -> {
                    int indexOfPersonToUpdate = DB.indexOf(robot);
                    if (indexOfPersonToUpdate >= 0) {
                        DB.set(indexOfPersonToUpdate, new Robot(id, update.getName()));
                        return 1;
                    }
                    return 0;
                })
                .orElse(0);
    }
}
