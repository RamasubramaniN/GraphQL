package com.psg.ramasubramani.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.model.Movie;

/**
 * @author rn5 This class should be actually a DAO class.
 */
@Repository
public class MovieRepository {

    // Persisting list between different client calls.
    // In case of DB, this should come from Database
    private List<Movie> movieList;

    // This is the primary key of the table
    private static Long ID = 1L;

    public MovieRepository() {

        this.movieList = new ArrayList<>();

        movieList.add(new Movie(ID++, 2010L, 100f, "Tamil", "Thuppakki"));
        movieList.add(new Movie(ID++, 2011L, 75.5f, "Tamil", "Kathi"));
        movieList.add(new Movie(ID++, 2018L, 125.3f, "Tamil", "Sarkar"));
        movieList.add(new Movie(ID++, 2010L, 53.1f, "Tamil", "Soodhu Kavvum"));
        movieList.add(new Movie(ID++, 2018L, 85.1f, "Tamil", "Vikram Vedha"));
        movieList.add(new Movie(ID++, 2018L, 101f, "Tamil", "Vada Chennai"));
        movieList.add(new Movie(ID++, 2018L, 60f, "Tamil", "Pyar Prema Kadhal"));
    }

    public List<Movie> getAllMovies() {
        return movieList;
    }

    //Database save call.
    public Movie save(Long yearOfRelease, Float collection, String language, String name) {
        Movie movie = new Movie(ID++, yearOfRelease, collection, language, name);
        movieList.add(movie);
        return movie;
    }
}
