package it.akademy.barbecue.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Drink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @JsonBackReference(value = "barbecue-drinks")
    @ManyToOne
    private Barbecue barbecue;

    public Drink() {}

    public Drink(String name) {
        this.name = name;
        this.barbecue = new Barbecue();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Barbecue getBarbecue() {
        return barbecue;
    }

    public void setBarbecue(Barbecue barbecue) {
        this.barbecue = barbecue;
    }
}
