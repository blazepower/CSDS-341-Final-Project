package com.csds341.football.entities;

import javax.persistence.*;

@Entity
public class Runningback {
    private @Id
    @GeneratedValue
    Integer rId;
    @ManyToOne //(cascade = CascadeType.MERGE)
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

    public Runningback(String name, Integer recYds, Integer rshYds, Integer catches, Integer tds, Integer fumbles, Integer drops) {
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

    public void setTeam(Team team) {
        this.team = team;
    }
}
