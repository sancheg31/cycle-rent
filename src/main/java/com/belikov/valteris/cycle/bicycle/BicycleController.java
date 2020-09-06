package com.belikov.valteris.cycle.bicycle;

import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/bicycles")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BicycleController {

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
        bicycleService.save(newBicycle);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        bicycleService.delete(id);
    }
}
