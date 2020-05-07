package com.projetweb.topevent.service;

import com.projetweb.topevent.model.Participant;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface ParticipantService {

    List<Participant> findAll();

    Optional<Participant> findById(String id);

    void saveOrUpdateParticipant(Participant participant);

    void deleteParticipant(String id);
}
