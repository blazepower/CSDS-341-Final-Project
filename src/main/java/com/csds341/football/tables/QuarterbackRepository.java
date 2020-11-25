package com.csds341.football.tables;

import com.csds341.football.entities.Quarterback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuarterbackRepository extends JpaRepository<Quarterback, Integer> {
}
