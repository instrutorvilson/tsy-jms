package com.consumer.ConsumerQ.ouvinte;

import com.consumer.ConsumerQ.entitdades.Ticket;
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
