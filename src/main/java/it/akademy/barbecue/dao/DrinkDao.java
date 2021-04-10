package it.akademy.barbecue.dao;

import it.akademy.barbecue.models.Drink;
import it.akademy.barbecue.models.Barbecue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrinkDao extends JpaRepository<Drink, Integer> {

    @Override
    List<Drink> findAll();

    Drink findById(int id);

    Drink save(Drink drink);

    void deleteById(int id);
}
