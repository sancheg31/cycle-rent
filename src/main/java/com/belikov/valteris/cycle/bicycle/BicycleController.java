package com.belikov.valteris.cycle.bicycle;

import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("/bicycles")
public class BicycleController {
    
    @Autowired
    private BicycleService bicycleService;
    @GetMapping("/allPage")
    public String bicyclePage() {
        return "bicyclesList"; //could be changed to any appropriate string;
    }

    @GetMapping("/all")
    public List<Bicycle> getBicycles() {
        return bicycleService.getAll();
    }

    @GetMapping("/{id}")
    public Bicycle getBicycle(@PathVariable Long id) {
        return bicycleService.getById(id).get();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody Bicycle newBicycle) {
        bicycleService.add(newBicycle);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bicycleService.delete(id);
    }
}
