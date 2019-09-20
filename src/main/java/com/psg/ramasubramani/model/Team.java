package com.psg.ramasubramani.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

/**
 * @author rn5
 * JPA + In Memory database. Refer data.sql
 */
@Data
@Entity
@Table(name="team")
public class Team {
	@Id
	private String id;
	private String name;
	
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
	private Set<Player> players;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
}
