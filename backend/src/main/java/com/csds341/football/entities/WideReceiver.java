package com.csds341.football.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WideReceiver {
    private @Id
    @GeneratedValue
    Integer wId;
    private Integer teamId;
    private String name;
    private Integer recYds;
    private Integer catches;
    private Integer tds;
    private Integer fumbles;
    private Integer drops;

    public WideReceiver() {
    }

    public WideReceiver(String name, Integer recYds, Integer catches,
                        Integer tds, Integer fumbles, Integer drops) {
        this.name = name;
        this.recYds = recYds;
        this.catches = catches;
        this.tds = tds;
        this.fumbles = fumbles;
        this.drops = drops;
    }

    public Integer getwId() {
        return wId;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public String getName() {
        return name;
    }

    public Integer getRecYds() {
        return recYds;
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

    public void setTeam(Integer teamId) {
        this.teamId = teamId;
    }
}
