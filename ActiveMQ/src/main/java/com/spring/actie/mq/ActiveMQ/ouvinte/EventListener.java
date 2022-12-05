package com.spring.actie.mq.ActiveMQ.ouvinte;

import com.spring.actie.mq.ActiveMQ.entitdades.Ticket;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class EventListener {
    @JmsListener(destination = "compra_queue",
            containerFactory = "defaultFactory")
    public void receiveMessage(Ticket ticket) {

        System.out.println("Mensagem da fila:" + ticket);
    }
}
