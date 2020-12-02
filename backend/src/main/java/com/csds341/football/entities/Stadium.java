package com.csds341.football.entities;

import javax.persistence.*;

@Entity
public class Stadium {
    private @Id @GeneratedValue Integer stadiumId;
    private String stadiumName;
    private String location;
    private Integer capacity;
    private String homeTeam;
    @OneToOne(cascade = CascadeType.ALL)
    private Team team;

    public Stadium() {
    }

    public Stadium(String stadiumName, String location,
                   Integer capacity, String homeTeam) {
        this.stadiumName = stadiumName;
        this.location = location;
        this.capacity = capacity;
        this.homeTeam = homeTeam;
    }

    public Integer getStadiumId() {
        return stadiumId;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public String getLocation() {
        return location;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
