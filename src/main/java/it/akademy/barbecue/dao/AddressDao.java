package it.akademy.barbecue.dao;

import it.akademy.barbecue.models.Address;
import it.akademy.barbecue.models.Barbecue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao extends JpaRepository<Address, Integer> {

    @Override
    List<Address> findAll();

    Address findById(int id);

    Address save(Address address);

    void deleteById(int id);
}
