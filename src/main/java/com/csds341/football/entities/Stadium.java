package com.csds341.football.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Stadium {
    private @Id @GeneratedValue Integer stadiumId;
    private String stadiumName;
    private String city;
    private String state;
    private Integer capacity;
    private String homeTeam;
    @OneToOne
    private Team team;

    public Stadium() {
    }

    public Stadium(Integer stadiumId, String stadiumName, String city,
                   String state, Integer capacity, String homeTeam, Team team) {
        this.stadiumId = stadiumId;
        this.stadiumName = stadiumName;
        this.city = city;
        this.state = state;
        this.capacity = capacity;
        this.homeTeam = homeTeam;
        this.team = team;
    }

    public Integer getStadiumId() {
        return stadiumId;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
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
}
