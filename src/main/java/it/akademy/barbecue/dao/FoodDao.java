package it.akademy.barbecue.dao;

import it.akademy.barbecue.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodDao extends JpaRepository<Food, Integer> {

    List<Food> findAll();

    Food findById(int id);

    Food save(Food food);

    void deleteById(int id);
}
