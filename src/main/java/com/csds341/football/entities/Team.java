package com.csds341.football.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    private @Id
    @GeneratedValue
    Integer teamId;
    private String teamName;
    private String city;
    private Integer superBowls;
    private String division;
    private String headCoach;
    private String generalManager;
    private String owner;
    private String record;
    @OneToOne
    private Stadium stadium;
    @OneToOne
    private DefenseST defenseST;
    @OneToMany
    private List<Quarterback> quarterbacks;
    @OneToMany
    private List<Runningback> runningbacks;
    @OneToMany
    private List<WideReceiver> wideReceivers;
    @OneToMany
    private List<Kicker> kickers;

    public Team() {
    }

    public Team(
            Integer teamId, String teamName, String city, Stadium stadium, Integer superBowls,
            String division, String headCoach, String generalManager, String owner, DefenseST defenseST, String record,
            List<Quarterback> quarterbacks, List<Runningback> runningbacks, List<WideReceiver> wideReceivers, List<Kicker> kickers) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.city = city;
        this.stadium = stadium;
        this.superBowls = superBowls;
        this.division = division;
        this.headCoach = headCoach;
        this.generalManager = generalManager;
        this.owner = owner;
        this.quarterbacks = quarterbacks;
        this.defenseST = defenseST;
        this.runningbacks = runningbacks;
        this.wideReceivers = wideReceivers;
        this.kickers = kickers;
        this.record = record;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getCity() {
        return city;
    }

    public Stadium getStadium() {
        return stadium;
    }

    public Integer getSuperBowls() {
        return superBowls;
    }

    public String getDivision() {
        return division;
    }

    public String getHeadCoach() {
        return headCoach;
    }

    public String getGeneralManager() {
        return generalManager;
    }

    public String getOwner() {
        return owner;
    }

    public String getRecord() {
        return record;
    }

    public DefenseST getDefenseST() {
        return defenseST;
    }

    public List<Quarterback> getQuarterbacks() {
        return quarterbacks;
    }

    public List<Runningback> getRunningbacks() {
        return runningbacks;
    }

    public List<WideReceiver> getWideReceivers() {
        return wideReceivers;
    }

    public List<Kicker> getKickers() {
        return kickers;
    }
}
