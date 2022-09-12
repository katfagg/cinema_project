package com.example.cinema_project.models;


import javax.persistence.*;

@Entity(name = "booking")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long screening_id;

    @Column
    private long customer_id;

    // private int seat_number;


    public Bookings() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getScreening_id() {
        return screening_id;
    }

    public void setScreening_id(long screening_id) {
        this.screening_id = screening_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }
}
