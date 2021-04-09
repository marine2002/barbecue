package it.akademy.barbecue.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Food {

    @Id
    private int id;

    private String name;



    @JsonBackReference(value = "barbecue-foods")
    @ManyToOne
    private Barbecue barbecue;

}
