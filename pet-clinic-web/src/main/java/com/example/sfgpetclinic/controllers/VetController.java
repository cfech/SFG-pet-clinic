package com.example.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetController {

    @RequestMapping("/vet")
    public String vetIndex(){

        return "vets/vetList";
    }

}
