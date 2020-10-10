package com.example.sfgpetclinic.services;

import java.util.Set;

//td and id are generics
public interface CrudService<T, ID>{
    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);


}
