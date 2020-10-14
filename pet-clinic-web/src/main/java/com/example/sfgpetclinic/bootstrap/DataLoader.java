package com.example.sfgpetclinic.bootstrap;

import com.example.sfgpetclinic.model.*;
import com.example.sfgpetclinic.services.OwnerService;
import com.example.sfgpetclinic.services.PetTypeService;
import com.example.sfgpetclinic.services.SpecialtyService;
import com.example.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

//this class starts the app up with some data, commandlinerunner is a spring boot
// specific way of intialiaing an app with data

//since this is a component when spring gets up and running it will call the run method
// and everything inside of it
@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;


    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        //if there is no pet types then load data, ie: first run or if we do use a
        // persistent database
        int count = petTypeService.findAll().size();
        if(count ==0){
            loadData();
        }

    }

    private void loadData() {
        //pet types
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("cat");
        PetType savedCatPetType = petTypeService.save(cat);

        System.out.println("Pet types loaded ...");

        //Specialties

        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentist = specialtyService.save(dentistry);

        Specialty surgeon = new Specialty();
        surgeon.setDescription("Surgeon");
        Specialty savedSurgeon = specialtyService.save(surgeon);

        System.out.println("Specialties loaded ...");

        //owners
        Owner tim = new Owner();
        tim.setFirstName("Tim");
        tim.setLastName("Higgins");
        tim.setAddress("123 Random Street");
        tim.setCity("New York");
        tim.setTelephone("9021387465");

        Pet timsPet = new Pet();
        timsPet.setPetType(savedDogPetType);
        timsPet.setOwner(tim);
        timsPet.setBirthDate(LocalDate.now());
        timsPet.setName("Rosco");
        tim.getPets().add(timsPet);

        ownerService.save(tim);

        Owner tom = new Owner();
        tom.setFirstName("Tom");
        tom.setLastName("Jeffries");
        tom.setAddress("125 Random Street");
        tom.setCity("New York");
        tom.setTelephone("385629473");

        Pet tomsPet = new Pet();
        tomsPet.setPetType(savedCatPetType);
        tomsPet.setOwner(tom);
        tomsPet.setBirthDate(LocalDate.now());
        tomsPet.setName("Mittins");
        tom.getPets().add(tomsPet);


        ownerService.save(tom);

        System.out.println("Loaded owners ...");


        //Vets
        Vet v1 = new Vet();
        v1.setFirstName("Jim");
        v1.setLastName("Johnson");
        v1.getSpecialties().add(savedRadiology);
        vetService.save(v1);

        Vet v2 = new Vet();
        v2.setFirstName("Jane");
        v2.setLastName("Doe");
        v2.getSpecialties().add(savedSurgeon);
        vetService.save(v2);

        System.out.println("Vets loaded ... ");
    }
}
