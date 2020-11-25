package com.csds341.football.tables;

import com.csds341.football.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Integer> {
}
