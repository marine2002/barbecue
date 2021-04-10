package it.akademy.barbecue.dao;

import it.akademy.barbecue.models.Barbecue;
import it.akademy.barbecue.models.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BarbecueDao extends JpaRepository<Barbecue, Integer> {

    Barbecue findById(int id);

    List<Barbecue> findAll();

    Barbecue save(Barbecue barbecue);

    void deleteById(int id);
}
