package com.example.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FindOwnerController {

    @RequestMapping("/owners/find")
    private String findOwner(){
        return "notyetimplimented";
    }

    @RequestMapping("/oups")
    private String oups(){
        return "notyetimplimented";
    }

}
