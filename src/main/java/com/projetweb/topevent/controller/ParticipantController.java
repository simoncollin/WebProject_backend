package com.projetweb.topevent.controller;

import com.projetweb.topevent.model.Participant;
import com.projetweb.topevent.service.EventService;
import com.projetweb.topevent.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;
    @Autowired
    private EventService eventService;

    @GetMapping(value = "/")
    public List<Participant> getAllParticipants() {
        return participantService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Participant getParticpantById(@PathVariable("id") String id){
        for (Participant participant : participantService.findAll()){
            if (participant.getId().equals(id)){
                return participant;
            }
        }
        return null;
    }

    @PostMapping(value = "/")
    public ResponseEntity<?> saveOrUpdateParticipant(@RequestBody Participant participant) {
        participantService.saveOrUpdateParticipant(participant);
        return new ResponseEntity("Participant added successfully", HttpStatus.OK);
    }

    @DeleteMapping(value = "/{idOrganisateur}")
    public void deleteParticipant(@PathVariable String id) {
        Optional<Participant> participantList = participantService.findById(id);
        for (Participant participant : participantService.findAll()){
            if (participant.getId().equals(id)){
                participantService.deleteParticipant(participant.getId());
            }
        }
    }
}
