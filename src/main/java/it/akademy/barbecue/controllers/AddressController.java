package it.akademy.barbecue.controllers;

import it.akademy.barbecue.dao.AddressDao;
import it.akademy.barbecue.dao.BarbecueDao;
import it.akademy.barbecue.models.Address;
import it.akademy.barbecue.models.Barbecue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressDao addressDao;
    private final BarbecueDao barbecueDao;

    @Autowired
    public AddressController(AddressDao addressDao, BarbecueDao barbecueDao){
        this.addressDao = addressDao;
        this.barbecueDao = barbecueDao;
    }

    @GetMapping
    public ResponseEntity<List<Address>> getAllAddress(){
        List<Address> address = addressDao.findAll();
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Address> getById(@PathVariable int id){
        Address address = addressDao.findById(id);
        if(address == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> createAddress(@RequestBody Address address){
        addressDao.save(address);
        return new ResponseEntity<>(address, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable int id){
        Address address = addressDao.findById(id);
        if(address == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        addressDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Address> putAddress(@PathVariable int id, @RequestBody Address address){
        Address modifiedAddress = addressDao.findById(id);

        if(modifiedAddress == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        address.setId(id);
        modifiedAddress = addressDao.save(address);
        return new ResponseEntity<>(modifiedAddress, HttpStatus.OK);
    }

    @PutMapping("/{addressId}/barbecues/{barbecueId}")
    public ResponseEntity<Address> addBarbecueInAddress(@PathVariable int addressId, @PathVariable int barbecueId){
        Address address = addressDao.findById(addressId);

        if(address == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Barbecue barbecue = barbecueDao.findById(barbecueId);

        if(barbecue == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        address.getBarbecues().add(barbecue);
        barbecue.setAddress(address);
        address.setId(addressId);
        addressDao.save(address);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
