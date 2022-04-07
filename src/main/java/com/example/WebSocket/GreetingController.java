package com.example.WebSocket;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import java.util.Random;

@Log4j2
@Controller
public class GreetingController {

    public class Robot {
        int hp = 100;
        int attack = 10;


    }

    Robot robot1 = new Robot();
    Robot robot2 = new Robot();
    Robot robot3 = new Robot();

    int myHp = 100;
    int myAttack = 10;

    Robot myRobot1 = new Robot();
    Robot myRobot2 = new Robot();
    Robot myRobot3 = new Robot();

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        log.info("ok");
        String bot = bot(message.getName());
        return new Greeting(bot + " " + botRandomAttack());
    }


    //@SendTo("/topic/greetings")
    public String bot(String message) {


        String result = "";

        switch (message) {
            case "1":
                robot1.hp -= myAttack;
                result = "robot1 hp: " + robot1.hp;
                break;
            case "2":
                robot2.hp -= myAttack;
                result = "robot2 hp: " +robot2.hp;
                break;
            case "3":
                robot3.hp -= myAttack;
                result = "robot3 hp: " + robot3.hp;
                break;
        }


        return "System: " + result;
    }

    public String botRandomAttack() {
        Random rand = new Random();
        int random = rand.nextInt(3)+1;
        String result = "";

        switch (random) {
            case 1:
                myRobot1.hp -= myAttack;
                result = "myRobot1 hp: " + myRobot1.hp;
                break;
            case 2:
                myRobot2.hp -= myAttack;
                result = "myRobot2 hp: " +myRobot2.hp;
                break;
            case 3:
                myRobot3.hp -= myAttack;
                result = "myRobot3 hp: " + myRobot3.hp;
                break;
        }

        return result;
    }
}
