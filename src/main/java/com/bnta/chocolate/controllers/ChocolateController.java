package com.bnta.chocolate.controllers;

import com.bnta.chocolate.dtos.ChocolateDTO;
import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.services.ChocolateService;
import com.bnta.chocolate.services.EstateService;
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

    @Autowired
    EstateService estateService;

    @GetMapping
    public ResponseEntity<List<Chocolate>> getAllChocolates(@RequestParam Optional<Integer> cocoaPercentage){
        List<Chocolate> chocolates;
        if(cocoaPercentage.isPresent()){
            chocolates = chocolateService.getChocolatesGreaterThanCocoa(cocoaPercentage.get());
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
    public ResponseEntity<Chocolate> addNewPlayer(@RequestBody ChocolateDTO chocolateDTO){
        String name = chocolateDTO.getName();
        int cocoaPercentage = chocolateDTO.getCocoaPercentage();
        Estate estate = estateService.findById(chocolateDTO.getEstateId()).get();
        Chocolate savedChocolate = chocolateService.addChocolate(new Chocolate(name, cocoaPercentage, estate));
        return new ResponseEntity<>(savedChocolate, HttpStatus.CREATED);
    }

}
