package com.projetweb.topevent.controller;

import javax.mail.MessagingException;

import com.projetweb.topevent.model.Event;
import com.projetweb.topevent.model.Participant;
import com.projetweb.topevent.service.EventService;
import com.projetweb.topevent.service.MailService;
import com.projetweb.topevent.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * This class contains a Mail API developed using Spring Boot
 *
 * @author MukulJaiswal
 *
 */
@RestController
public class MailController {

    @Autowired
    private MailService notificationService;

    @Autowired
    private EventService eventService;
    @Autowired
    private ParticipantService participantService;

    public String send(String userId, String message) {

        Optional<Participant> user = participantService.findById(userId);

        try {
            notificationService.sendEmail(user.get(), message);
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }

    public String sendWithAttachment(@PathVariable("id") String userId) throws MessagingException {

        Optional<Participant> user = participantService.findById(userId);

        try {
            notificationService.sendEmailWithAttachment(user.get());
        } catch (MailException mailException) {
            System.out.println(mailException);
        }
        return "Congratulations! Your mail has been send to the user.";
    }
}