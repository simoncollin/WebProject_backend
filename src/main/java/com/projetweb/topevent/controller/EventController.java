package com.projetweb.topevent.controller;

import com.projetweb.topevent.model.Event;
import com.projetweb.topevent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping(value = "/")
    public List<Event> getAllEvents() {
        return eventService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Event getEventById(@PathVariable("id") String id){
        for (Event event : eventService.findAll()){
            if (event.getId().equals(id)){
                return event;
            }
        }
        return null;
    }

    @GetMapping(value = "/idOrganisateur/{id}")
    public Event getEventByIdOrganisateur(@PathVariable("id") String id) {
        return eventService.findByIdOrganisateur(id);
    }

    @GetMapping(value = "/name/{name}")
    public Event getEventByName(@PathVariable("name") String name) {
        return eventService.findByName(name);
    }

    @GetMapping(value = "/orderByDate")
    public List<Event> findAllByOrderByDate() {
        return eventService.findAllByOrderByDate();
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateEvent(@RequestBody Event event) {
        eventService.saveOrUpdateEvent(event);
        return new ResponseEntity("Event added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/byIdOrganisateur/{idOrganisateur}")
    public void deleteEventByIdOrganisateur(@PathVariable String idOrganisateur) {
        eventService.deleteEvent(eventService.findByIdOrganisateur(idOrganisateur).getId());
    }

    @DeleteMapping(value = "/{id}")
    public void deleteEvent(@PathVariable String id) {
        eventService.deleteEvent(id);
    }
}
