package it.akademy.barbecue.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    int number;
    String streetName;
    String city;
    String country;

    @JsonManagedReference(value = "barbecue-address")
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Barbecue> barbecues;

    public Address(int number, String streetName, String city, String country) {
        this.number = number;
        this.streetName = streetName;
        this.city = city;
        this.country = country;
        this.barbecues = new ArrayList<>();
    }

    public Address() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
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

    public List<Barbecue> getBarbecues() {
        return barbecues;
    }

    public void setBarbecues(List<Barbecue> barbecues) {
        this.barbecues = barbecues;
    }

}