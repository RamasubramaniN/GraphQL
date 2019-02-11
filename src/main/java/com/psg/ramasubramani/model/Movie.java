package com.psg.ramasubramani.model;

/**
 * @author rn5 Movie model.
 */
public class Movie {
    private Long id;
    private Long yearOfRelease;
    private Float collection;
    private String language;
    private String name;

    public Movie(Long id, Long yearOfRelease, Float collection, String language, String name) {
        this.id = id;
        this.yearOfRelease = yearOfRelease;
        this.collection = collection;
        this.language = language;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public Long getYearOfRelease() {
        return yearOfRelease;
    }

    public Float getCollection() {
        return collection;
    }

    public String getLanguage() {
        return language;
    }

    public String getName() {
        return name;
    }

}
