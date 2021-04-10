package it.akademy.barbecue.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Barbecue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;

    @JsonBackReference(value = "barbecue-address")
    @ManyToOne
    private Address address;

    @JsonManagedReference(value = "barbecue-persons")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Person> persons;

    @JsonManagedReference(value = "barbecue-foods")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Food> foods;

    @JsonManagedReference(value = "barbecue-drinks")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Drink> drinks;

    public Barbecue() {}

    public Barbecue(LocalDate date) {
        this.date = date;
        this.address = new Address();
        this.persons = new ArrayList<>();
        this.foods = new ArrayList<>();
        this.drinks = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public List<Food> getFoods() {
        return foods;
    }

    public void setFoods(List<Food> foods) {
        this.foods = foods;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Drink> drinks) {
        this.drinks = drinks;
    }
}
