package com.projetweb.topevent.service.impl;

import com.projetweb.topevent.model.Event;
import com.projetweb.topevent.repository.EventRepository;
import com.projetweb.topevent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<Event> findById(String id){
        return eventRepository.findById(id);
    }

    @Override
    public Event findByIdOrganisateur(String id) {
        return eventRepository.findByIdOrganisateur(id);
    }

    @Override
    public Event findByName(String name) {
        return eventRepository.findByName(name);
    }

    @Override
    public List<Event> findAllByOrderByDate() {
        return eventRepository.findAllByOrderByDate();
    }

    @Override
    public void saveOrUpdateEvent(Event event) {
        eventRepository.save(event);
    }

    @Override
    public void deleteEvent(String id) {
        eventRepository.deleteById(id);
    }

}
