package org.ieselcaminas.jpa.entity;

import jakarta.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_customer")
    private Customer customer;

    protected Note() {}
    
    public Note(String text, Customer customer) {
        this.text = text;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return text;
    }

}
