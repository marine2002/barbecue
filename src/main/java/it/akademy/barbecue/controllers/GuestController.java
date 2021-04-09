package it.akademy.barbecue.controllers;


import it.akademy.barbecue.dao.GuestDao;
import it.akademy.barbecue.models.Guest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/guests")

public class GuestController {

    private final GuestDao guestDao;

    @Autowired
    public GuestController(GuestDao guestDao){
        this.guestDao = guestDao;
    }

    @GetMapping
    public ResponseEntity<List<Guest>> getAllGuests(){
        List<Guest> guests = guestDao.findAll();
        return new ResponseEntity<>(guests, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Guest> getById(@PathVariable int id){
        Guest guest = guestDao.findById(id);
        if(guest == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(guest, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Guest> createGuest(@RequestBody Guest guest){
        guestDao.save(guest);
        return new ResponseEntity<>(guest, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGuest(@PathVariable int id){
        Guest guest = guestDao.findById(id);
        if(guest == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        guestDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Guest> putGuest(@PathVariable int id, @RequestBody Guest guest){
//        Guest modifiedGuest = guestDao.findById(id);
//
//        if(modifiedGuest == null){
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        guest.setId(id);
//        modifiedGuest = guestDao.save(guest);
//        return new ResponseEntity<>(modifiedGuest, HttpStatus.OK);
//    }
}
