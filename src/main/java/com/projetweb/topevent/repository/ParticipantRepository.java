package com.projetweb.topevent.repository;

import com.projetweb.topevent.model.Event;
import com.projetweb.topevent.model.Participant;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ParticipantRepository extends MongoRepository<Participant, String> {

}
