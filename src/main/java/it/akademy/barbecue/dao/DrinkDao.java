package it.akademy.barbecue.dao;

import it.akademy.barbecue.models.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkDao extends JpaRepository<Drink, Integer> {

    List<Drink> findAll();

    Drink findById(int id);

    Drink save(Drink drink);

    void deleteById(int id);
}
