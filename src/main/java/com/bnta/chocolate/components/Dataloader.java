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

        estateRepository.saveAll(Arrays.asList(
                houseOfDorchester,
                montezumas,
                aphroditeChocolates,
                charbonnelAndWalker,
                duffys,
                whitakers
        ));

        Chocolate chocolate1 = new Chocolate("bounty",0,duffys);
        Chocolate chocolate2 = new Chocolate("mars",0,whitakers);
        Chocolate chocolate3 = new Chocolate("caramel lux",10,charbonnelAndWalker);
        Chocolate chocolate4 = new Chocolate("rum turtle",40,montezumas);
        Chocolate chocolate5 = new Chocolate("nut bar",2,houseOfDorchester);
        Chocolate chocolate6 = new Chocolate("cocoa haven",80,aphroditeChocolates);

        Chocolate chocolate7 = new Chocolate("coconutto",0,duffys);
        Chocolate chocolate8 = new Chocolate("twix",0,whitakers);
        Chocolate chocolate9 = new Chocolate("caramel classic",20,charbonnelAndWalker);
        Chocolate chocolate10 = new Chocolate("rum bear",50,montezumas);
        Chocolate chocolate11 = new Chocolate("almond bar",1,houseOfDorchester);
        Chocolate chocolate12 = new Chocolate("cocoa haven plus",95,aphroditeChocolates);

        chocolateRepository.saveAll(Arrays.asList(
                chocolate1,
                chocolate2,
                chocolate3,
                chocolate4,
                chocolate5,
                chocolate6,
                chocolate7,
                chocolate8,
                chocolate9,
                chocolate10,
                chocolate11,
                chocolate12
        ));

    }
}
