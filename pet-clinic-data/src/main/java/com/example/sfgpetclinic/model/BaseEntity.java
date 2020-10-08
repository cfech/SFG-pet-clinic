package com.example.sfgpetclinic.model;

import java.io.Serializable;

public class BaseEntity implements Serializable {
    //use box type over primitive , recomendation of hibernate
    private Long id;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
