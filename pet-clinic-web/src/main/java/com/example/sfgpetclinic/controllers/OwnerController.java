package com.example.sfgpetclinic.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//root path
@RequestMapping("/owners")

@Controller
public class OwnerController {

    //these paths extend the base path, ie /owners/index will also return the
    // ownersList html file
    @RequestMapping({"","/", "/index", "/index.html"})
    public String ownerIndex(){

        return "owners/ownersList";
    }

}
