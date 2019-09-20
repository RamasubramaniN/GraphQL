package com.psg.ramasubramani.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.psg.ramasubramani.model.Actor;
import com.psg.ramasubramani.model.Movie;
import com.psg.ramasubramani.model.Player;
import com.psg.ramasubramani.model.Team;
import com.psg.ramasubramani.repository.ActorRepository;
import com.psg.ramasubramani.repository.MovieRepository;
import com.psg.ramasubramani.repository.PlayerRepository;
import com.psg.ramasubramani.repository.TeamRepository;

/**
 * @author rn5
 * Use GraphiQL tool to test APIs.
 */
@Component
public class Query implements GraphQLQueryResolver {

    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    private TeamRepository teamRepository;
    private PlayerRepository playerRepository;

    public Query(MovieRepository movieRepository, ActorRepository actorRepository,
    		TeamRepository teamRepository, PlayerRepository playerRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    /**
        Url : http://localhost:8080/graphql
      	Post Request
        Request :
        {
          findAllMovies {
            id
            name
            language
            yearOfRelease
            collection
          }
        }
    */
    public Iterable<Movie> findAllMovies() {
        return movieRepository.getAllMovies();
    }

    /**
        Url : http://localhost:8080/graphql
        Post Request
        Request :
        {
          findAllActors {
            id
            name
            age
          }
        }
    */
    public Iterable<Actor> findAllActors() {
        return actorRepository.getAllActors();
    }
    
    /**
	    Url : http://localhost:8080/graphql
	    Post Request
	    Request :
	    {
	      findAllTeams {
	        id
	        name
	        player {
	        		id
	        		name
	        		age
	        }
	      }
	    }
     */
	public Iterable<Team> findAllTeams() {
	    return teamRepository.findAll();
	}
	
	/**
	    Url : http://localhost:8080/graphql
	  
	    Post Request:
	    {
	      findAllPlayers {
	        id
	        name
	      }
	    }
	 */
	public Iterable<Player> findAllPlayers() {
	    return playerRepository.findAll();
	}
}
