package com.csds341.football.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Team {
    private @Id
    Integer teamId;
    private String teamName;
    private String city;
    private Integer superBowls;
    private String division;
    private String headCoach;
    private String generalManager;
    private String owner;
    private String record;
    @OneToOne(cascade = CascadeType.ALL)
    private Stadium stadium;
    @OneToOne(cascade = CascadeType.ALL)
    private DefenseST defenseST;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Quarterback> quarterbacks;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Runningback> runningbacks;
    @OneToMany(cascade = CascadeType.ALL)
    private List<WideReceiver> wideReceivers;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Kicker> kickers;

    public Team() {
    }

    public Team(
            Integer teamId, String teamName, String city, Integer superBowls,
            String division, String headCoach, String generalManager, String owner, String record) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.city = city;
        this.superBowls = superBowls;
        this.division = division;
        this.headCoach = headCoach;
        this.generalManager = generalManager;
        this.owner = owner;
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

    public void setStadium(Stadium stadium) {
        this.stadium = stadium;
    }

    public void setDefenseST(DefenseST defenseST) {
        this.defenseST = defenseST;

        if (defenseST != null) {
            defenseST.setTeamId(getTeamId());
        }
    }

    public void setQuarterbacks(List<Quarterback> quarterbacks) {
        this.quarterbacks = quarterbacks;
    }

    public void setRunningbacks(List<Runningback> runningbacks) {
        this.runningbacks = runningbacks;
    }

    public void setWideReceivers(List<WideReceiver> wideReceivers) {
        this.wideReceivers = wideReceivers;
    }

    public void setKickers(List<Kicker> kickers) {
        this.kickers = kickers;

        if (kickers != null) {
            for (Kicker kicker : kickers) {
                kicker.setTeam(getTeamId());
            }
        }
    }

}
