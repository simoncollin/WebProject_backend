package com.projetweb.topevent.controller;

import com.projetweb.topevent.model.Event;
import com.projetweb.topevent.model.Participant;
import com.projetweb.topevent.service.EventService;
import com.projetweb.topevent.service.MailService;
import com.projetweb.topevent.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private MailService mailService;

    @Autowired
    private ParticipantService participantService;

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

    @PostMapping(value = "/ajoutParticipant/{eventId}")
    public ResponseEntity<?> addEventParticipant(@PathVariable String eventId, @RequestBody Participant participant) {
        Optional<Event> event = eventService.findById(eventId);
        if (event.isPresent()){
            event.get().pushToParticipant(participant.getId());
            eventService.saveOrUpdateEvent(event.get());
            Optional<Participant> participant1 = participantService.findById(participant.getId());

            String message = "Votre participation à l'évènement : " + event.get().getName() + " a bien été enregistré !";
            if (participant1.isPresent()){
                mailService.sendEmail(participant1.get(), message);
            }
            return new ResponseEntity("Participant " + participant1.get().getId() + " added successfully to the event", HttpStatus.OK);
        }
        return new ResponseEntity("Bad request", HttpStatus.BAD_REQUEST);
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
