package it.akademy.barbecue.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Guest {

    @Id
    private int id;

    private String firstName;

    private String lastName;

    private int age;

    private String role;


    @JsonBackReference(value = "guest-barbecue")
    @ManyToOne
    private Barbecue barbecue;

    public Guest(){}

    public Guest(int id, String firstName, String lastName, int age, Barbecue barbecue, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.barbecue = barbecue;
        this.role = role;
    }
}
