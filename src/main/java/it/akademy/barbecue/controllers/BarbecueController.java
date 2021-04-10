package it.akademy.barbecue.controllers;

import it.akademy.barbecue.dao.BarbecueDao;
import it.akademy.barbecue.dao.DrinkDao;
import it.akademy.barbecue.dao.FoodDao;
import it.akademy.barbecue.dao.PersonDao;
import it.akademy.barbecue.models.Address;
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

    @GetMapping("/{id}")
    public ResponseEntity<Barbecue> getById(@PathVariable int id){
        Barbecue barbecue = barbecueDao.findById(id);
        if(barbecue == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(barbecue, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Barbecue> addBarbecue(@RequestBody Barbecue barbecue) {
        Barbecue addedBarbecue = barbecueDao.save(barbecue);
        return new ResponseEntity<>(addedBarbecue, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBarbecue(@PathVariable int id){
        Barbecue barbecue = barbecueDao.findById(id);
        if(barbecue == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        barbecueDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Barbecue> putBarbecue(@PathVariable int id, @RequestBody Barbecue barbecue){
        Barbecue modifiedBarbecue = barbecueDao.findById(id);

        if(modifiedBarbecue == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        barbecue.setId(id);
        modifiedBarbecue = barbecueDao.save(barbecue);
        return new ResponseEntity<>(modifiedBarbecue, HttpStatus.OK);
    }
}
