package com.bnta.chocolate.components;

import com.bnta.chocolate.models.Chocolate;
import com.bnta.chocolate.models.Estate;
import com.bnta.chocolate.repositories.ChocolateRepository;
import com.bnta.chocolate.repositories.EstateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.persistence.CascadeType;
import java.util.Arrays;
import java.util.List;

@Component
public class Dataloader implements ApplicationRunner {

    @Autowired
    EstateRepository estateRepository;

    @Autowired
    ChocolateRepository chocolateRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception{

//        List<String> knownEstates = Arrays.asList(
//                "house of dorchester",
//                "montezuma’s",
//                "aphrodite chocolates",
//                "charbonnel & walker",
//                "duffy’s",
//                "whitakers"
//        );
//
//        for (String estates : knownEstates){
//            Estate estate = new Estate(estates, "england");
//            estateRepository.save(estate);
//        }

        Estate houseOfDorchester = new Estate("house of dorchester","england");
        Estate montezumas = new Estate("montezuma's","england");
        Estate aphroditeChocolates = new Estate("aphrodite chocolates","england");
        Estate charbonnelAndWalker = new Estate("charbonnel & walker","england");
        Estate duffys = new Estate("duffy's","england");
        Estate whitakers = new Estate("whitakers","england");

        chocolateRepository.save(new Chocolate("bounty",0,duffys));
        chocolateRepository.save(new Chocolate("mars",0,whitakers));
        chocolateRepository.save(new Chocolate("caramel lux",10,charbonnelAndWalker));
        chocolateRepository.save(new Chocolate("rum turtle",40,montezumas));
        chocolateRepository.save(new Chocolate("nut bar",2,houseOfDorchester));
        chocolateRepository.save(new Chocolate("cocoa haven",80,aphroditeChocolates));

//        chocolateRepository.save(new Chocolate("coconutto",0,duffys));
//        chocolateRepository.save(new Chocolate("twix",0,whitakers));
//        chocolateRepository.save(new Chocolate("caramel classic",20,charbonnelAndWalker));
//        chocolateRepository.save(new Chocolate("rum bear",50,montezumas));
//        chocolateRepository.save(new Chocolate("almond bar",1,houseOfDorchester));
//        chocolateRepository.save(new Chocolate("cocoa haven plus",95,aphroditeChocolates));


    }
}
