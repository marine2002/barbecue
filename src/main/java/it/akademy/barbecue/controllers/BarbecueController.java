package it.akademy.barbecue.controllers;

import it.akademy.barbecue.dao.BarbecueDao;
import it.akademy.barbecue.dao.DrinkDao;
import it.akademy.barbecue.dao.FoodDao;
import it.akademy.barbecue.dao.PersonDao;
import it.akademy.barbecue.models.Barbecue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barbecues")
public class BarbecueController {

    private final BarbecueDao barbecueDao;
    private final PersonDao personDao;
    private final DrinkDao drinkDao;
    private final FoodDao foodDao;

    @Autowired
    public BarbecueController(BarbecueDao barbecueDao, PersonDao personDao, DrinkDao drinkDao, FoodDao foodDao) {
        this.barbecueDao = barbecueDao;
        this.personDao = personDao;
        this.drinkDao = drinkDao;
        this.foodDao = foodDao;
    }

    @GetMapping
    public ResponseEntity<List<Barbecue>> getAllBarbecues() {
        List<Barbecue> barbecues = barbecueDao.findAll();
        return new ResponseEntity<>(barbecues, HttpStatus.OK);
    }
//
//    @GetMapping("/?city={city}")
//    public ResponseEntity<List<Barbecue>> getAllBarbecuesByCity(@PathVariable String city) {
//        List<Barbecue> barbecues = barbecueDao.findAllByCity(city);
//        return new ResponseEntity<>(barbecues, HttpStatus.OK);
//    }

//    @GetMapping("/?id={id}")
//    public ResponseEntity<Barbecue> getBarbecueById(@PathVariable int id) {
//        Barbecue barbecue = barbecueDao.findById(id);
//        if (barbecue == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>(barbecue, HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<Barbecue> addBarbecue(@RequestBody Barbecue barbecue) {
        Barbecue addedBarbecue = barbecueDao.save(barbecue);
        return new ResponseEntity<>(addedBarbecue, HttpStatus.CREATED);
    }
}
