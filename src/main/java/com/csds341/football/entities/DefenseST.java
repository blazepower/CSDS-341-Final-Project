package com.csds341.football.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DefenseST {
    private @Id
    @GeneratedValue
    Integer defenseId;
    // TODO: Add team as one to one
    private Integer interceptions;
    private Integer sacks;
    private Integer rshYdsAllowed;
    private Integer passYdsAllowed;

    public DefenseST() {
    }

    public DefenseST(Integer defenseId, Integer interceptions, Integer sacks,
                     Integer rshYdsAllowed, Integer passYdsAllowed) {
        this.defenseId = defenseId;
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
}
