package com.psg.ramasubramani.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;

import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.model.Movie;

/**
 * @author rn5 This class should be actually a DAO class.
 */
@Repository
public class MovieRepository {

    // Persisting list between different client calls.
    // In case of DB, this should come from Database
    private Set<Movie> movieSet;

    // This is the primary key of the table
    private static Long ID = 1L;

    public MovieRepository() {

        this.movieSet = new HashSet<>();

        movieSet.add(new Movie(ID++, 2010L, 100f, "Tamil", "Thuppakki"));
        movieSet.add(new Movie(ID++, 2011L, 75.5f, "Tamil", "Kathi"));
        movieSet.add(new Movie(ID++, 2018L, 125.3f, "Tamil", "Sarkar"));
        movieSet.add(new Movie(ID++, 2010L, 53.1f, "Tamil", "Soodhu Kavvum"));
        movieSet.add(new Movie(ID++, 2018L, 85.1f, "Tamil", "Vikram Vedha"));
        movieSet.add(new Movie(ID++, 2018L, 101f, "Tamil", "Vada Chennai"));
        movieSet.add(new Movie(ID++, 2018L, 60f, "Tamil", "Pyar Prema Kadhal"));
    }

    public Set<Movie> getAllMovies() {
        return movieSet;
    }

    //Database save call.
    public Movie save(Long yearOfRelease, Float collection, String language, String name) {
        Movie movie = new Movie(ID++, yearOfRelease, collection, language, name);
        movieSet.add(movie);
        return movie;
    }

    public boolean updateMovieCollection(String name, String language, Float collection) {
        Predicate<Movie> moviePredicate = movie -> movie.getName().equalsIgnoreCase(name)
                && movie.getLanguage().equalsIgnoreCase(language);
        Optional<Movie> optionalMovie = movieSet.stream().filter(moviePredicate).findFirst();
        if(optionalMovie.isPresent()) {
            Movie movie = optionalMovie.get();
            movie.setCollection(collection);
        }
        return optionalMovie.isPresent() ;
    }
}
