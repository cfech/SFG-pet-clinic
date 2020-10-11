package com.example.sfgpetclinic.controllers;


import com.example.sfgpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//root path
@RequestMapping("/owners")

@Controller
public class OwnerController {
    private final OwnerService ownerService;


    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    //these paths extend the base path, ie /owners/index will also return the
    // ownersList html file
    @RequestMapping({"","/", "/index", "/index.html"})

    //spring mvc will automatically add a model when run
    public String ownerIndex(Model model){

        model.addAttribute("owners", ownerService.findAll());

        return "owners/ownersList";
    }

}
