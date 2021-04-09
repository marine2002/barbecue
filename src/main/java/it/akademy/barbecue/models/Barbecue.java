package it.akademy.barbecue.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.apache.tomcat.jni.Address;
import java.time.LocalDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Barbecue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate date;

//    private Address address;

    private String city;

    private String country;

    @JsonManagedReference(value = "barbecue-guests")
    @OneToMany
    private List<Guest> guests;

    @JsonManagedReference(value = "barbecue-foods")
    @OneToMany
    private List<Food> foods;

    @JsonManagedReference(value = "barbecue-drinks")
    @OneToMany
    private List<Drink> drinks;

    public Barbecue(){}

    public Barbecue(LocalDate date, String city, String country){
        this.date = date;
        this.city = city;
        this.country = country;
        this.guests = new ArrayList<>();
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
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
