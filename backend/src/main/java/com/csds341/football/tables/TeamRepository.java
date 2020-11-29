package com.csds341.football.tables;

import com.csds341.football.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    @Query(
            "select distinct t.teamId, avg(w.recYds) " +
                    "from WideReceiver w, Team t " +
                    "where t.division = 'NFC' and w.team = t " +
                    "group by w.team.teamId"
    )
    Integer getId();
}
