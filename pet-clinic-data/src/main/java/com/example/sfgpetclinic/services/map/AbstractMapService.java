package com.example.sfgpetclinic.services.map;

import com.example.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id){
       return map.get(id);
    }

    T save(T object){

        if(object != null){
            if(object.getId() == null){
                object.setId(getNextId());
            }

            map.put(object.getId(), object);
        }else{
            //will not work if we try to pass a null object in here
            throw new RuntimeException("Object cannot be null");
        }
        return object;
    }

    void deleteById(ID id){
        map.remove(id);
    }

    void delete(T object){
        //remove the object if the object equals an entry in the map
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    //returns the max id in our array(list) + adds one
    private Long getNextId(){

        //His Solution
//        Long nextId = null;
//
//        //if there is nothing in the list yet retrun 1
//        try{
//            nextId = Collections.max(map.keySet()) +1;
//        }catch (NoSuchElementException e){
//            nextId = 1L;
//        }


        //random Id solution

        long newId = 10000 + (long)  (Math.random() * 89999);
        return newId;
    }

}

