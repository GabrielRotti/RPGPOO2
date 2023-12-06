package com.rafot.rpgpoo2.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "races", schema = "rpg", catalog = "")
public class Race {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Race)) return false;
        Race race = (Race) o;
        return id == race.id && Objects.equals(name, race.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}