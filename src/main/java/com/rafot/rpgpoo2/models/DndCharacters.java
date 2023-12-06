package com.rafot.rpgpoo2.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "dnd_characters", schema = "rpg", catalog = "")
public class DndCharacters {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "race_id")
    private int raceId;
    @Basic
    @Column(name = "character_name")
    private String characterName;
    @Basic
    @Column(name = "title")
    private String title;
    @Basic
    @Column(name = "lvl")
    private int lvl;
    @Basic
    @Column(name = "str")
    private int str;
    @Basic
    @Column(name = "dex")
    private int dex;
    @Basic
    @Column(name = "con")
    private int con;
    @Basic
    @Column(name = "wis")
    private int wis;
    @Basic
    @Column(name = "cha")
    private int cha;
    @Basic
    @Column(name = "smt")
    private int smt;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRaceId() {
        return raceId;
    }

    public void setRaceId(int raceId) {
        this.raceId = raceId;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCon() {
        return con;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public int getWis() {
        return wis;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }

    public int getCha() {
        return cha;
    }

    public void setCha(int cha) {
        this.cha = cha;
    }

    public int getSmt() {
        return smt;
    }

    public void setSmt(int smt) {
        this.smt = smt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DndCharacters)) return false;
        DndCharacters that = (DndCharacters) o;
        return id == that.id && userId == that.userId && raceId == that.raceId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, raceId);
    }
}
