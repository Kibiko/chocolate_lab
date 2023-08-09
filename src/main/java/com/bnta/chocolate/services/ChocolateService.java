package com.bnta.chocolate.services;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChocolateService {

    @Autowired
    ChocolateRepository chocolateRepository;

    public List<Chocolate> getAllChocolates(){
        return chocolateRepository.findAll();
    }

    public List<Chocolate> getChocolatesGreaterThanCocoa(int cocoaPercentage){
        return chocolateRepository.findByCocoaPercentageGreaterThanEqual(cocoaPercentage);
    }

    public Chocolate addChocolate(Chocolate chocolate){
        chocolateRepository.save(chocolate);
        return chocolate;
    }

    public Optional<Chocolate> findById(Long id){
        return chocolateRepository.findById(id);
    }

}
