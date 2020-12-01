package com.csds341.football.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class DefenseST {
    private @Id
    @GeneratedValue
    Integer defenseId;
    @OneToOne
    private Team team;
    private Integer interceptions;
    private Integer sacks;
    private Integer rshYdsAllowed;
    private Integer passYdsAllowed;

    public DefenseST() {
    }

    public DefenseST(Integer interceptions, Integer sacks,
                     Integer rshYdsAllowed, Integer passYdsAllowed) {
        this.interceptions = interceptions;
        this.sacks = sacks;
        this.rshYdsAllowed = rshYdsAllowed;
        this.passYdsAllowed = passYdsAllowed;
    }

    public Integer getDefenseId() {
        return defenseId;
    }

    public Integer getInterceptions() {
        return interceptions;
    }

    public Integer getSacks() {
        return sacks;
    }

    public Integer getRshYdsAllowed() {
        return rshYdsAllowed;
    }

    public Integer getPassYdsAllowed() {
        return passYdsAllowed;
    }

    public Team getTeam() { return team; }

    public void setTeam(Team team) {
        this.team = team;
    }
}
