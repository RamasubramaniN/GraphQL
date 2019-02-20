package com.psg.ramasubramani.repository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.psg.ramasubramani.model.Actor;

/**
 * @author rn5 Actors DAO Layer.
 */
@Repository
public class ActorRepository {

    // Persisting list between different client calls.
    // In case of DB, this should come from Database
    private Set<Actor> actorSet;

    private static Long ID = 1L;

    public ActorRepository() {
        actorSet = new HashSet<>();

        actorSet.add(new Actor(ID++, "Vijay Sethupathi", 41));
        actorSet.add(new Actor(ID++, "Vijay", 45));
        actorSet.add(new Actor(ID++, "Dhanush", 40));
        actorSet.add(new Actor(ID++, "Harish", 27));
    }

    public Set<Actor> getAllActors() {
        return actorSet;
    }

    //Database save call.
    public Actor save(String name, Integer age) {
        Actor actor = new Actor(ID++, name, age);
        actorSet.add(actor);
        return actor;
    }

    public boolean deleteActor(String name) {
        Predicate<Actor> actorPredicate = actor -> actor.getName().equalsIgnoreCase(name);
        Set<Actor> deleteActorSet = actorSet.stream().filter(actorPredicate).collect(Collectors.toSet());
        actorSet.removeAll(deleteActorSet);
        
        boolean response = deleteActorSet.size() > 0 ? true : false;
        return response;
    }
    
}
