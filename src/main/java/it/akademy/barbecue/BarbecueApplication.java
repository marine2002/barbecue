package it.akademy.barbecue;

import ch.qos.logback.core.net.SyslogOutputStream;
import it.akademy.barbecue.models.DrinkType;
import it.akademy.barbecue.models.FoodType;
import it.akademy.barbecue.models.Person;
import it.akademy.barbecue.models.Role;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SpringBootApplication
public class BarbecueApplication {

    public static void main(String[] args) {
        //SpringApplication.run(BarbecueApplication.class, args);

        Person person = new Person("Pika", "Chu", 30, Role.GUEST);
        Person person1 = new Person("Sala", "Meche", 25, Role.HOST);
        Person person2 = new Person("Bulbi", "Zarre", 20, Role.GUEST);
        Person person3 = new Person("Cara", "Puce", 15, Role.HOST);

        List<Person> persons = new ArrayList<>();
        persons.add(person);
        persons.add(person1);
        persons.add(person2);
        persons.add(person3);

        List<Person> teamMeat = new ArrayList<>();
        List<Person> teamSoft = new ArrayList<>();

        System.out.println(person.getFoodTypes());
        System.out.println(person.getDrinkTypes());
        person.eat(FoodType.MEAT);
        person.drink(DrinkType.SOFT);
        person1.eat(FoodType.MEAT);
        person1.drink(DrinkType.SOFT);
        person2.eat(FoodType.MEAT);
        person2.drink(DrinkType.ALCOHOL);
        person3.eat(FoodType.VEGETARIAN);
        person3.drink(DrinkType.ALCOHOL);
        System.out.println(person.getFoodTypes());
        System.out.println(person.getDrinkTypes());
//        person.dontEat(FoodType.MEAT);
//        person1.dontDrink(DrinkType.SOFT);
        System.out.println(person.getFoodTypes());
        System.out.println(person.getDrinkTypes());

        for(Person p: persons){
            if (p.getFoodTypes().contains(FoodType.MEAT) && p.getDrinkTypes().contains(DrinkType.SOFT)){
                teamMeat.add(p);
                teamSoft.add(p);
            }
        }

//        for(Person p: persons){
//            if (p.getFoodTypes().contains(FoodType.MEAT)){
//                teamMeat.add(p);
//            }
//        }

//        for(Person p: persons){
//            if (p.getDrinkTypes().contains(DrinkType.SOFT)){
//                teamSoft.add(p);
//            }
//        }

        System.out.println(teamMeat);
        System.out.println(teamSoft);
    }

}
