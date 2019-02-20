package com.psg.ramasubramani.resolver;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.psg.ramasubramani.model.Actor;
import com.psg.ramasubramani.model.Movie;
import com.psg.ramasubramani.repository.ActorRepository;
import com.psg.ramasubramani.repository.MovieRepository;

/**
 * @author rn5
 * Use GraphiQL tool to test APIs.
 */
@Component
public class Query implements GraphQLQueryResolver {

    private MovieRepository movieRepository;
    private ActorRepository actorRepository;

    public Query(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    /**
        Url : http://localhost:8080/graphql
      
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
}
