package com.psg.ramasubramani.model;

/**
 * @author rn5 
 * Actor Model
 *
 */
public class Actor {
    
    private String name;
    private Long id;
    private Integer age;

    public Actor(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public Integer getAge() {
        return age;
    }
    
}
