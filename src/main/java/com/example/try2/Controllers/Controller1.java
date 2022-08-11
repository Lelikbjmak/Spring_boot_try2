package com.example.try2.Controllers;


import com.example.try2.Entities.store;
import com.example.try2.Entities.types;
import com.example.try2.Exceptions.NotFoundException;
import com.example.try2.Repositories.typesRepository;
import com.example.try2.Servivies.storeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController  // =Controller + ResponseBody -> Контроллер слушает, получает, отвечает на запросы
                    // Респонс боди говорит спрингу что объект надо прогнать через HTTPMessageConverter чтобы получить готовое к отправление клиенту
@RequestMapping("/Home")
public class Controller1 {

    @Autowired
    private storeService storeService;

    @Autowired
    private typesRepository typesRepository;

    @CrossOrigin(origins = "http://localhost:63342")
    @PostMapping("/addtype")
    public ResponseEntity addtype(@RequestBody types types){
        try {
            typesRepository.save(types);
            return ResponseEntity.ok("Added!");
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Error!");
        }

    }


    @GetMapping()
    public String hello(){
        return "Hello user!";
    }

    @GetMapping("/cars/findByID/{id}")
    public store carID(@PathVariable("id") int id){
        return storeService.findById(id);
    }

    @CrossOrigin(origins = "http://localhost:63342")
    @GetMapping("/cars/all")
    public Iterable allcars(){
        return storeService.getAll();
    }

    @GetMapping("/cars/findByModel/{model}")
    public store carModel(@PathVariable("model") String model){
        return storeService.getByModel(model);
    }

    @PostMapping("/cars/add")
    public void addcar(@RequestBody store store){
        storeService.addCar(store);
    }

    @GetMapping("cars/deleteById/{id}")   // cause we get message ResponseEntity -> GETMapping
    public ResponseEntity deleteById(@PathVariable("id") int id){
        try {
            if(storeService.existById(id)) {
                storeService.deleteById(id);
            }else throw new NotFoundException();

            return ResponseEntity.ok("Car has been deleted!");
        } catch (NotFoundException ex){
            return ResponseEntity.badRequest().body("Can't delete car!");
        }

    }


    @GetMapping("/cars/deleteByModel/{model}")
    public ResponseEntity deleteByModel(@PathVariable("model") String model){
        try {
            storeService.deleteByModel(model);
            return ResponseEntity.ok("Deleting by model successful!");
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Can't execute deleting by model!");
        }
    }


    @GetMapping("/cars/updateById/{id}")
    public ResponseEntity<String> updateById(@PathVariable("id") int id){
        try {
            store store = carID(id);
            store.setPrice(10.99);
            storeService.updateCar(store);
            return ResponseEntity.ok("Updated:" + store.toString());
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Can't accomplish operation!");
        }
    }



    @GetMapping("/cars/updateByModel/{model}")
    public ResponseEntity updateByModel(@PathVariable("model") String model){
        try {
            store carModel = carModel(model);  // find an object we wanna change
            System.out.println(carModel.toString());
            carModel.setPrice(65999.99);    // update some fields

            return storeService.updateCar(carModel);
        }catch (Exception ex){
            return ResponseEntity.badRequest().body("Can't update car!");
        }

    }


}
