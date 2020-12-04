package com.csds341.football.tables;

import com.csds341.football.entities.Runningback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RunningbackRepository extends JpaRepository<Runningback, Integer> {
    @Query(
            "select count(r.rId) " +
                    "from Team t, Runningback r" +
                    " where t.teamName = 'Chargers' and r.teamId = t.teamId"
    )
    Integer getNumRunningbackByTeamContainingChargers();
}
