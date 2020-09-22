package com.belikov.valteris.cycle.user;

import com.belikov.valteris.cycle.bicycle.BicycleService;
import com.belikov.valteris.cycle.bicycle.model.Bicycle;
import lombok.AllArgsConstructor;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;
    private final BicycleService bicycleService;

    @GetMapping("/index")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/bicycleList")
    public String showMenuPage() {
        return "bicycle_list";
    }

    @GetMapping("/bicycleList/all")
    @ResponseBody
    public String getBicycles() {
        final List<Bicycle> bicycleList = bicycleService.getAll();
        JSONObject json = new JSONObject();

        json.put("totalPages", 2);
        json.put("currentPage", 1);
        json.put("bicycles", bicycleList);

        return json.toString();
    }

    @GetMapping("/myOrders")
    public String showOrdersPage() {
        return "my-orders";
    }

    @GetMapping("/bicycle")
    public String showBicyclePage() {
        return "bicycle";
    }

    @GetMapping("/cart")
    public String showCartPage() {
        return "cart";
    }

    @GetMapping("/checkout")
    public String showCheckoutPage() {
        return "checkout";
    }
}