package com.consumer.ConsumerQ.entitdades;

import javax.persistence.*;


@Entity
public class Ticket {
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private String name;
    private Double price;
    private int quantity;

    public Ticket(){}

    public Ticket(String name, Double price, int quantity){
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    @Override
    public String toString() {
        return String.format("Compra de ingresso -> " +
                        "Name=%s, Price=%s, Quantity=%s}",
                getName(), getPrice(), getQuantity());
    }

}
