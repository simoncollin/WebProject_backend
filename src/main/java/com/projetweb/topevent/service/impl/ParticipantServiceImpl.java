package com.projetweb.topevent.service.impl;

import com.projetweb.topevent.model.Participant;
import com.projetweb.topevent.service.ParticipantService;
import com.projetweb.topevent.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantServiceImpl implements ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    @Override
    public List<Participant> findAll(){
        return participantRepository.findAll();
    }

    @Override
    public Optional<Participant> findById(String id){
        return participantRepository.findById(id);
    }

    @Override
    public void saveOrUpdateParticipant(Participant participant){
        participantRepository.save(participant);
    }

    @Override
    public void deleteParticipant(String id){
        participantRepository.deleteById(id);
    }

}
