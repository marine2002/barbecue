package it.akademy.barbecue.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.*;

@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private int age;

    private String role;


    @JsonBackReference(value = "barbecue-persons")
    @ManyToOne
    private Barbecue barbecue;

    public Person(){}

    public Person(int id, String firstName, String lastName, int age, Barbecue barbecue, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.barbecue = barbecue;
        this.role = role;
    }
}
