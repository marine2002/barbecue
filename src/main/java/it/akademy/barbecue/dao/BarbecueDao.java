package it.akademy.barbecue.dao;

import it.akademy.barbecue.models.Barbecue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BarbecueDao extends JpaRepository<Barbecue, Integer> {

    @Override
    List<Barbecue> findAll();

    List<Barbecue> findAllByCity(String city);

    Barbecue findById(int id);

    Barbecue save(Barbecue barbecue);

    void deleteById(int id);
}
