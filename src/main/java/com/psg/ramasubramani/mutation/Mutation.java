package com.psg.ramasubramani.mutation;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
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
 * Database update operations. Use GraphiQL tool to test APIs.
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    
    private MovieRepository movieRepository;
    private ActorRepository actorRepository;
    private PlayerRepository playerRepository;
    private TeamRepository teamRepository;

    public Mutation(MovieRepository movieRepository, ActorRepository actorRepository,
    					PlayerRepository playerRepository, TeamRepository teamRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
        this.playerRepository = playerRepository;
        this.teamRepository = teamRepository;
    }

    /**
        Url : http://localhost:8080/graphql
      
        Request :
        mutation {
          newActor (
            name: "Yash",
            age: 34) {
              id name
          }
        }
     */
    public Actor newActor(String name, Integer age) {
        return actorRepository.save(name, age);
    }

    /**
      Url : http://localhost:8080/graphql 
      Request : 
      mutation {
          newMovie(name: "KGF", collection: 250.0, yearOfRelease: 2018, language: "Kannada") {
            id
            name
            language
            collection
            yearOfRelease
          }
        }
     */
    public Movie newMovie(Long yearOfRelease, Float collection, String language, String name) {
        return movieRepository.save(yearOfRelease, collection, language, name);
    }
    
    /**
        Url : http://localhost:8080/graphql 
        Request : 
        mutation {
          deleteActor(name: "Yash")
        }
   */
    public Boolean deleteActor(String name) {
        return actorRepository.deleteActor(name);
    }
    
    /**
    Url : http://localhost:8080/graphql 
    Request : 
    mutation {
      updateMovieCollection(name: "KGF", language: "Kannada", collection: 275.0)
    }
    */
    public Boolean updateMovieCollection(String name, String language, Float collection) {
        return movieRepository.updateMovieCollection(name, language, collection);
    }
    
    /**
     * Url : http://localhost:8080/graphql 
     * POST Request
     	mutation {
		  newPlayer(teamName: "India", playerName: "Rahul Dravid", playerAge: 40) {
		    id
		    name
		    age
		  }
		}
     */
	public Player newPlayer(String teamName, String playerName, Integer playerAge) {
		Integer nextPlayerId = this.playerRepository.maxId() + 1;
		Team team = this.teamRepository.getTeamByTeamName(teamName);
		if (team == null)
			throw new RuntimeException("Invalid Team Name");
		Player player = new Player(team, nextPlayerId.toString(), playerName, playerAge);
		return playerRepository.save(player);
	}
}
