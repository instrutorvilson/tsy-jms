package com.spring.actie.mq.ActiveMQ.Controller;

import com.spring.actie.mq.ActiveMQ.entitdades.Ticket;
import com.spring.actie.mq.ActiveMQ.ouvinte.EventListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {
    @Autowired
    private JmsTemplate jmsTemplate;


    @PostMapping(value = "/buy",
            consumes =  MediaType.APPLICATION_JSON_VALUE)
    public void buyTicket(@RequestBody Ticket ticket){
        jmsTemplate.convertAndSend("compra_queue",
                new Ticket(ticket.getName(),
                        ticket.getPrice(),
                        ticket.getQuantity()));
    }


}
