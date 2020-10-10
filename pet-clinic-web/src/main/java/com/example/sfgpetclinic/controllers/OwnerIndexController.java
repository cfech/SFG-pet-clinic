package com.example.sfgpetclinic.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerIndexController {

    @RequestMapping("/owner")
    public String ownerIndex(){

        return "OwnerIndex";
    }

}
