package com.example.WebSocket.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "person")
public class Robot {
    @Id
    private final int id;
    @Column(name = "name")

    private final String name;
    private final int hp;
    private final int attack;

    public Robot(@JsonProperty("id") int id,
                 @JsonProperty("name") String name,
                 @JsonProperty("hp") int hp,
                 @JsonProperty("attack") int attack) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getAttck() {
        return attack;
    }
}
