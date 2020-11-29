package com.csds341.football.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Kicker {
    private @Id @GeneratedValue
    Integer kId;
    @ManyToOne
    private Team team;
    private String name;
    private Integer fgMade;
    private Integer fgMissed;

    public Kicker() {
    }

    public Kicker(Integer kId, Team team, String name, Integer fgMade, Integer fgMissed) {
        this.kId = kId;
        this.team = team;
        this.name = name;
        this.fgMade = fgMade;
        this.fgMissed = fgMissed;
    }

    public Integer getwKId() {
        return kId;
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
