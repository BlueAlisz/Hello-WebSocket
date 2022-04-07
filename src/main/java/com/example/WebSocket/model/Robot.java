package com.example.WebSocket.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.UUID;


@Entity
@Table(name = "person")
public class Robot {
    @Id
    private final UUID id;
    @Column(name = "name")

    private final String name;

    public Robot(@JsonProperty("id") UUID id,
                 @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
