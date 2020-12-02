package com.csds341.football.entities;

import javax.persistence.*;

@Entity
public class Kicker {
    private @Id @GeneratedValue
    Integer kId;
//    @ManyToOne(cascade = CascadeType.ALL)
//    private Team team;
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

    public Integer getTeam() {
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

    public void setTeam(Integer team) {
        this.teamId = team;
    }
}
