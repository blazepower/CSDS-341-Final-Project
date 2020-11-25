package com.csds341.football.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Runningback {
    private @Id
    @GeneratedValue
    Integer rId;
    @ManyToOne
    private Team team;
    private String name;
    private Integer recYds;
    private Integer rshYds;
    private Integer catches;
    private Integer tds;
    private Integer fumbles;
    private Integer drops;

    public Runningback() {
    }

    public Runningback(Integer rId, Team team, String name, Integer recYds, Integer rshYds, Integer catches, Integer tds, Integer fumbles, Integer drops) {
        this.rId = rId;
        this.team = team;
        this.name = name;
        this.recYds = recYds;
        this.rshYds = rshYds;
        this.catches = catches;
        this.tds = tds;
        this.fumbles = fumbles;
        this.drops = drops;
    }

    public Integer getrId() {
        return rId;
    }

    public Team getTeam() {
        return team;
    }

    public String getName() {
        return name;
    }

    public Integer getRecYds() {
        return recYds;
    }

    public Integer getRshYds() {
        return rshYds;
    }

    public Integer getCatches() {
        return catches;
    }

    public Integer getTds() {
        return tds;
    }

    public Integer getFumbles() {
        return fumbles;
    }

    public Integer getDrops() {
        return drops;
    }
}
