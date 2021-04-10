package it.akademy.barbecue.controllers;


import it.akademy.barbecue.dao.FoodDao;
import it.akademy.barbecue.models.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/foods")

public class FoodController {

    private final FoodDao foodDao;

    @Autowired
    public FoodController(FoodDao foodDao){
        this.foodDao = foodDao;
    }

    @GetMapping
    public ResponseEntity<List<Food>> getAllFoods(){
        List<Food> foods = foodDao.findAll();
        return new ResponseEntity<>(foods, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Food> getById(@PathVariable int id){
        Food food = foodDao.findById(id);
        if(food == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(food, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Food> addFood(@RequestBody Food food) {
        Food addedFood = foodDao.save(food);
        return new ResponseEntity<>(addedFood, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteFood(@PathVariable int id){
        Food food = foodDao.findById(id);
        if(food == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        foodDao.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> putFood(@PathVariable int id, @RequestBody Food food){
        Food modifiedFood = foodDao.findById(id);

        if(modifiedFood == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        food.setId(id);
        modifiedFood = foodDao.save(food);
        return new ResponseEntity<>(modifiedFood, HttpStatus.OK);
    }

}
