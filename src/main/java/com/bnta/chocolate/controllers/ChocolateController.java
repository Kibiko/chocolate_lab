package com.bnta.chocolate.controllers;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.services.ChocolateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/chocolates")
public class ChocolateController {

    @Autowired
    ChocolateService chocolateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(@RequestParam Optional<Integer> cocoa){
        List<Chocolate> chocolates;
        if(cocoa.isPresent()){
            chocolates = chocolateService.getChocolatesGreaterThanCocoa(cocoa.get());
        } else {
            chocolates = chocolateService.getAllChocolates();
        }
        return new ResponseEntity<>(chocolates, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Chocolate> findChocolateById(@PathVariable Long id){
        Optional<Chocolate> chocolate = chocolateService.findById(id);
        if(chocolate.isPresent()){
            return new ResponseEntity<>(chocolate.get(), HttpStatus.FOUND);
        } else{
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Chocolate> addNewPlayer(@RequestBody Chocolate chocolate){
        Chocolate savedChocolate = chocolateService.addChocolate(chocolate);
        return new ResponseEntity<>(savedChocolate, HttpStatus.CREATED);
    }

}
