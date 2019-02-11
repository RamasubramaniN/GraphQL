package com.psg.ramasubramani.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.model.Actor;

/**
 * @author rn5 Actors DAO Layer.
 */
@Repository
public class ActorRepository {

    // Persisting list between different client calls.
    // In case of DB, this should come from Database
    private List<Actor> actorList;

    private static Long ID = 1L;

    public ActorRepository() {
        actorList = new ArrayList<>();

        actorList.add(new Actor(ID++, "Vijay Sethupathi", 41));
        actorList.add(new Actor(ID++, "Vijay", 45));
        actorList.add(new Actor(ID++, "Dhanush", 40));
        actorList.add(new Actor(ID++, "Harish", 27));
    }

    public List<Actor> getAllActors() {
        return actorList;
    }

    //Database save call.
    public Actor save(String name, Integer age) {
        Actor actor = new Actor(ID++, name, age);
        actorList.add(actor);
        return actor;
    }
}
