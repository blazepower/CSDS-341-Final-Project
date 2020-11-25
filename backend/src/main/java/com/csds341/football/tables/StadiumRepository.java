package com.csds341.football.tables;

import com.csds341.football.entities.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadiumRepository extends JpaRepository<Stadium, Integer> {
}
