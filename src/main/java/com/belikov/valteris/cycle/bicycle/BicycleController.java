package com.belikov.valteris.cycle.bicycle;

import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/bicycles")
public class Controller {
    @Autowired
    private BicycleService bicycleService;
    @GetMapping("/allPage")
    public string bicyclePage() {
        return "bicyclesList"; //could be changed to any appropriate string;
    }

    @GetMapping("/all")
    public List<Bicycle> getBicycles() {
        return bicycleService.getAll();
    }
}
