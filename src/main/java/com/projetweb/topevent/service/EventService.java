package com.projetweb.topevent.service;

import com.projetweb.topevent.model.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {

    List<Event> findAll();

    Optional<Event> findById(String id);

    Event findByIdOrganisateur(String idOrganisateur);

    Event findByName(String name);

    List<Event> findAllByOrderByDate();

    void saveOrUpdateEvent(Event event);

    void deleteEvent(String id);
}
