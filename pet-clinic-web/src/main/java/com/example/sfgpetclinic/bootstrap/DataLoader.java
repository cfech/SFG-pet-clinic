package com.example.sfgpetclinic.bootstrap;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//this class starts the app up with some data, commandlinerunner is a spring boot
// specific way of intialiaing an app with data

//since this is a component when spring gets up and running it will call the run method
// and everything inside of it
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner tim = new Owner();
        tim.setId(1L);
        tim.setFirstName("Tim");
        tim.setLastName("Higgins");

        ownerService.save(tim);

        Owner tom = new Owner();
        tom.setId(2L);
        tom.setFirstName("Tom");
        tom.setLastName("Jeffries");

        ownerService.save(tom);

        System.out.println("Loaded owners ...");

        Vet v1 = new Vet();

        v1.setId(3L);
        v1.setFirstName("Jim");
        v1.setLastName("Johnson");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setId(4L);
        v2.setFirstName("Jane");
        v2.setLastName("Doe");

        vetService.save(v2);

        System.out.println("Vets loaded ... ");
    }
}
