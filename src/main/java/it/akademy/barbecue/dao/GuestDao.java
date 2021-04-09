package it.akademy.barbecue.dao;

import it.akademy.barbecue.models.Guest;
import it.akademy.barbecue.models.Barbecue;
import it.akademy.barbecue.models.Food;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestDao extends JpaRepository<Guest, Integer> {

    @Override
    List<Guest> findAll();

    List<Guest> findAllByBarbecue(Barbecue barbecue);

    Guest findById(int id);

    Guest save(Guest guest);

    void deleteById(int id);


}
