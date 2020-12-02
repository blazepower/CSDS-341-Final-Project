package com.csds341.football.entities;

import javax.persistence.*;

@Entity
public class Quarterback {
    private @Id
    @GeneratedValue
    Integer quId;
    @ManyToOne(cascade = CascadeType.ALL)
    private Team team;
    private String name;
    private Integer passYds;
    private Integer rushYds;
    private Integer completions;
    private Integer tds;

    public Quarterback(String name, Integer passYds, Integer rushYds, Integer completions, Integer tds) {
        this.name = name;
        this.passYds = passYds;
        this.rushYds = rushYds;
        this.completions = completions;
        this.tds = tds;
    }

    public Quarterback() {
    }

    public Integer getQuid() {
        return quId;
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public Integer getPassYds() {
        return passYds;
    }

    public Integer getRushYds() {
        return rushYds;
    }

    public Integer getCompletions() {
        return completions;
    }

    public Integer getTds() {
        return tds;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
