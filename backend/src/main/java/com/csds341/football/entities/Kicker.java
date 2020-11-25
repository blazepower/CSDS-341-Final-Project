package com.csds341.football.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Kicker {
    private @Id @GeneratedValue
    Integer wId;
    @ManyToOne
    private Team team;
    private String name;
    private Integer fgMade;
    private Integer fgMissed;

    public Kicker() {
    }

    public Kicker(Integer wId, Team team, String name, Integer fgMade, Integer fgMissed) {
        this.wId = wId;
        this.team = team;
        this.name = name;
        this.fgMade = fgMade;
        this.fgMissed = fgMissed;
    }

    public Integer getwId() {
        return wId;
    }

    public Team getTeam() {
        return team;
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
}
