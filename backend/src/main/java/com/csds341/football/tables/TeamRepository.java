package com.csds341.football.tables;

import com.csds341.football.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {
//    @Query(
//            "select distinct t.teamId, avg(w.recYds) " +
//                    "from WideReceiver w, Team t " +
//                    "where t.division = 'NFC' and w.team = t " +
//                    "group by w.team.teamId"
//    )
//    Integer getId();

    @Query(
            "select t.teamName from Team t where t.division = 'NFC'"
    )
    List<String> getTeamIdOfTeamNFC();

//    @Query(
//            "select t.teamName from Team t, Kicker k " +
//                    "where k.team = t.teamId " +
//                    "and k.fgMade = " +
//                    "(select max(k1.fgMade) from Kicker k1 " +
//                    "where k1.team.teamId = k.team.teamId)"
//    )
//    String teamWithKickerWithMostFGMade();
//
    @Query(
            "select t.teamName from Team t " +
                    "where t.division = 'AFC' " +
                    "and t.record = " +
                    "(select max(t1.record) from Team t1 " +
                    "where t.teamId = t1.teamId)"
    )
    List<String> teamNameOfAFCWinner();

}
