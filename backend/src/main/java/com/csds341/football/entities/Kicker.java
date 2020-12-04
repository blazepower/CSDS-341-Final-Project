package com.csds341.football.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Kicker {
    private @Id @GeneratedValue
    Integer kId;
    private Integer teamId;
    private String name;
    private Integer fgMade;
    private Integer fgMissed;

    public Kicker() {
    }

    public Kicker(String name, Integer fgMade, Integer fgMissed) {
        this.name = name;
        this.fgMade = fgMade;
        this.fgMissed = fgMissed;
    }

    public Integer getwKId() {
        return kId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public Integer getFgMade() {
        return fgMade;
    }

    public Integer getFgMissed() {
        return fgMissed;
    }

    public void setTeam(Integer teamId) {
        this.teamId = teamId;
    }
}
