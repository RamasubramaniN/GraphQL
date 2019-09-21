package com.psg.ramasubramani.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.model.Player;

/**
 * @author rn5
 *
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {
	@Query(value = "SELECT MAX(id) FROM Player") //Use Entity name, not table name
	public Integer maxId();
}
