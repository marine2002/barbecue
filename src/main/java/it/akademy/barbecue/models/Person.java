package it.akademy.barbecue.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person implements FoodChoices, DrinkChoices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;
    private String lastName;
    private int age;
    private Role role;

    @ElementCollection
    List<FoodType> foodTypes;

    @ElementCollection
    List<DrinkType> drinkTypes;

    @JsonBackReference(value = "barbecue-persons")
    @ManyToOne
    private Barbecue barbecue;

    public Person(){}

    public Person(String firstName, String lastName, int age, Role role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.barbecue = new Barbecue();
        this.role = role;
        this.foodTypes = new ArrayList<>();
        this.drinkTypes = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<FoodType> getFoodTypes() {
        return foodTypes;
    }

    public void setFoodTypes(List<FoodType> foodTypes) {
        this.foodTypes = foodTypes;
    }

    public List<DrinkType> getDrinkTypes() {
        return drinkTypes;
    }

    public void setDrinkTypes(List<DrinkType> drinkTypes) {
        this.drinkTypes = drinkTypes;
    }

    public Barbecue getBarbecue() {
        return barbecue;
    }

    public void setBarbecue(Barbecue barbecue) {
        this.barbecue = barbecue;
    }

    @Override
    public void drink(DrinkType drinkType) {
        if(!this.drinkTypes.contains(drinkType)){
            this.drinkTypes.add(drinkType);
        }
    }

    @Override
    public void dontDrink(DrinkType drinkType) {
        this.drinkTypes.remove(drinkType);
    }

    @Override
    public void eat(FoodType foodType) {
        if(!this.foodTypes.contains(foodType)){
            this.foodTypes.add(foodType);
        }
    }

    @Override
    public void dontEat(FoodType foodType) {
        this.foodTypes.remove(foodType);
    }

    @Override
    public String toString() {
        return "Person{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", role=" + role +
                ", foodTypes=" + foodTypes +
                ", drinkTypes=" + drinkTypes +
                '}';
    }
}
