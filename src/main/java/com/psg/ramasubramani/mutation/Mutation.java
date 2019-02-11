package com.psg.ramasubramani.mutation;

import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.psg.ramasubramani.model.Actor;
import com.psg.ramasubramani.model.Movie;
import com.psg.ramasubramani.repository.ActorRepository;
import com.psg.ramasubramani.repository.MovieRepository;

/**
 * @author rn5
 * Database update operations.
 */
@Component
public class Mutation implements GraphQLMutationResolver {
    
    private MovieRepository movieRepository;
    private ActorRepository actorRepository;

    public Mutation(MovieRepository movieRepository, ActorRepository actorRepository) {
        this.movieRepository = movieRepository;
        this.actorRepository = actorRepository;
    }

    public Actor newActor(String name, Integer age) {
        return actorRepository.save(name, age);
    }

    public Movie newMovie(Long yearOfRelease, Float collection, String language, String name) {
        return movieRepository.save(yearOfRelease, collection, language, name);
    }
}
