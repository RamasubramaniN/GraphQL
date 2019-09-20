package com.psg.ramasubramani.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.model.Player;

/**
 * @author rn5
 *
 */
@Repository
public interface PlayerRepository extends JpaRepository<Player, String> {

}
