package com.csds341.football.controllers;

import com.csds341.football.entities.DefenseST;
import com.csds341.football.entities.Kicker;
import com.csds341.football.entities.Stadium;
import com.csds341.football.entities.Team;
import com.csds341.football.tables.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")

@RestController
public class TestController {
    @Autowired
    DefenseSTRepository defenseSTRepository;

    @Autowired
    KickerRepository kickerRepository;

    @Autowired
    QuarterbackRepository quarterbackRepository;

    @Autowired
    RunningbackRepository runningbackRepository;

    @Autowired
    StadiumRepository stadiumRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    WideReceiverRepository wideReceiverRepository;
    EntityManager em;

    @GetMapping("/api/getAll/def")
    public List<DefenseST> getAll() {
        return defenseSTRepository.findAll();
    }

    @GetMapping("/api/getAll/kicker")
    public List<Kicker> getAllK() {
        return kickerRepository.findAll();
    }

    @GetMapping("/api/getAll/team")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/api/getNFC")
    public List<String> getAllNFC() {
        return teamRepository.getTeamIdOfTeamNFC();
    }

    @GetMapping("/api/getAFCWinner")
    public List<String> getAFCWinner() {
        List<String> res = new ArrayList<>();
        res.add(teamRepository.teamNameOfAFCWinner().get(0).trim());
        return res;
    }
}
