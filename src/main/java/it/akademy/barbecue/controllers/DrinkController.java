package it.akademy.barbecue.controllers;

import it.akademy.barbecue.dao.DrinkDao;
import it.akademy.barbecue.models.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drinks")
public class DrinkController {

    private final DrinkDao drinkDao;

    @Autowired
    public DrinkController(DrinkDao drinkDao) {
        this.drinkDao = drinkDao;
    }

    @GetMapping
    public ResponseEntity<List<Drink>> getAllDrinks() {
        List<Drink> drinks = drinkDao.findAll();
        return new ResponseEntity<>(drinks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drink> getById(@PathVariable int id) {
        Drink drink = drinkDao.findById(id);
        if (drink == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(drink, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Drink> addDrink(@RequestBody Drink drink) {
        Drink addedDrink = drinkDao.save(drink);
        return new ResponseEntity<>(addedDrink, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDrink(@PathVariable int id) {
        Drink drink = drinkDao.findById(id);
        if (drink == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        drinkDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drink> putDrink(@PathVariable int id, @RequestBody Drink drink) {
        Drink modifiedDrink = drinkDao.findById(id);

        if (modifiedDrink == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        drink.setId(id);
        modifiedDrink = drinkDao.save(drink);
        return new ResponseEntity<>(modifiedDrink, HttpStatus.OK);
    }

}
