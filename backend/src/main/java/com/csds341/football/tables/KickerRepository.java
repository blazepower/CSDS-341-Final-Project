package com.csds341.football.tables;

import com.csds341.football.entities.Kicker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KickerRepository extends JpaRepository<Kicker, Integer> {
}
