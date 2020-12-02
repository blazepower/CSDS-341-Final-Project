package com.csds341.football.tables;

import com.csds341.football.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query(
            "select t.teamName from Team t where t.division = 'NFC'"
    )
    List<String> getTeamIdOfTeamNFC();

    @Query(
            "select t.teamName from Team t, Kicker k " +
                    " where k.fgMade = " +
                    "(select max(k1.fgMade) from Kicker k1 " +
                    "where k1.teamId = k.teamId)" +
                    "and k.teamId = t.teamId "
    )
    List<String> teamWithKickerWithMostFGMade();

    @Query(
            "select t.teamName from Team t " +
                    "where t.division = 'AFC' " +
                    "and t.record = " +
                    "(select max(t1.record) from Team t1)"
    )
    List<String> teamNameOfAFCWinner();

    @Query(
            "select t.teamName from Team t, DefenseST d " +
                    "where d.interceptions = (select max(d1.interceptions) from DefenseST d1) and d.teamId = t.teamId"
    )
    List<String> teamNameWithMostInterceptions();

}
