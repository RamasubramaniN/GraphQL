package com.psg.ramasubramani.mutation;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.psg.ramasubramani.model.Actor;
import com.psg.ramasubramani.model.Movie;
import com.psg.ramasubramani.repository.ActorRepository;
import com.psg.ramasubramani.repository.MovieRepository;

/**
 * @author rn5
 * Database update operations. Use GraphiQL tool to test APIs.
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    
    private MovieRepository movieRepository;
    private ActorRepository actorRepository;

    public Mutation(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
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
}
