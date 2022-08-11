package com.example.try2.Repositories;

import com.example.try2.Entities.store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;

public interface storeRepository extends CrudRepository<store, Integer> {

    store findByModel(String model);

    ResponseEntity deleteByModel(String model);


}
