package com.example.WebSocket;

public class SelectEnemy {

    private int enemy;
    private int selectRobot;

    public SelectEnemy() {
    }

    public SelectEnemy(int enemy, int selectRobot) {
        this.enemy = enemy;
        this.selectRobot = selectRobot;
    }

    public int getEnemy() {
        return enemy;
    }

    public void setEnemy(int enemy) {
        this.enemy = enemy;
    }

    public int getSelectRobot() {
        return selectRobot;
    }

    public void setSelectRobot(int selectRobot) {
        this.selectRobot = selectRobot;
    }

}
