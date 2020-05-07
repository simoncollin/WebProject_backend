package com.projetweb.topevent.repository;

import com.projetweb.topevent.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EventRepository extends MongoRepository<Event, String> {

    Event findByIdOrganisateur(String idOrganisateur);
    Event findByName(String name);

    List<Event> findAllByOrderByDate();
}
