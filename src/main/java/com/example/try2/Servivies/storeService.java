package com.example.try2.Servivies;

import com.example.try2.Entities.store;
import com.example.try2.Exceptions.NotFoundException;
import com.example.try2.Repositories.storeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class storeService{

    @Autowired
    private storeRepository storeRepository;

    storeService(storeRepository storeRepository){
        this.storeRepository = storeRepository;

    }
        public Iterable<store> getAll(){

            return storeRepository.findAll(); // JSON format
        }

    public store getByModel(String model) throws NotFoundException {

        store car = storeRepository.findByModel(model);

        if(car == null) {
            throw new NotFoundException();
        }

        return car;
    }

    public store findById(int id){
        return storeRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public void addCar(store car){

        storeRepository.save(car);

    }

    public ResponseEntity updateCar(store car){
        try {
            storeRepository.save(car);
            return ResponseEntity.ok(car.toString() + " Successfully updated");
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Can't execute methode Update!");
        }
    }

    public void update(store car){
        storeRepository.save(car);
    }

    public ResponseEntity deleteById(int id){
        try {
            if(storeRepository.existsById(id))
            storeRepository.deleteById(id);

            return ResponseEntity.ok("Successfully delete car!");
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Can't execute erasing by Id from Database!");
        }
    }

    @DeleteMapping("/{model}")
    public ResponseEntity deleteByModel(String model){
        try {
            storeRepository.deleteByModel(model);
            return ResponseEntity.ok("Successfully delete car!");
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Can't execute erasing by Id from Database!");
        }
    }


    public boolean existById(int id){
        try {
            storeRepository.existsById(id);
            return true;
        }catch (Exception ex){
            return false;
        }
    }
}
