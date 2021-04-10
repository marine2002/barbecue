package it.akademy.barbecue.dao;

import it.akademy.barbecue.models.Barbecue;
import it.akademy.barbecue.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonDao extends JpaRepository<Person, Integer> {

    List<Person> findAll();

    List<Person> findAllByBarbecue(Barbecue barbecue);

    Person findById(int id);

    Person save(Person person);

    void deleteById(int id);


}