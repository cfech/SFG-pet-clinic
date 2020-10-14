package com.example.sfgpetclinic.bootstrap;

import com.example.sfgpetclinic.model.Owner;
import com.example.sfgpetclinic.model.PetType;
import com.example.sfgpetclinic.model.Vet;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.PetTypeService;
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
    private final PetTypeService petTypeService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Pet types loaded ...");

        Owner tim = new Owner();
        tim.setFirstName("Tim");
        tim.setLastName("Higgins");

        ownerService.save(tim);

        Owner tom = new Owner();
        tom.setFirstName("Tom");
        tom.setLastName("Jeffries");

        ownerService.save(tom);

        System.out.println("Loaded owners ...");

        Vet v1 = new Vet();
        v1.setFirstName("Jim");
        v1.setLastName("Johnson");

        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Jane");
        v2.setLastName("Doe");

        vetService.save(v2);

        System.out.println("Vets loaded ... ");
    }
}
