package com.belikov.valteris.cycle.user;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping("/signUp")
    public String showSignUpPage() {
        return "signUp";
    }

    @GetMapping("/index")
    public String showHomePage() {
        return "index";
    }

    @GetMapping("/myOrders")
    public String showOrdersPage() {
        return "my-orders";
    }

    @GetMapping("/bicycle")
    public String showBicyclePage() {
        return "bicycle-page";
    }

    @GetMapping("/cart")
    public String showCartPage() {
        return "cart-page";
    }

    @GetMapping("/checkout")
    public String showCheckoutPage() {
        return "checkout-page";
    }
}