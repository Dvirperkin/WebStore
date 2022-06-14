package hac.ex4.controllers;

import hac.ex4.database.Payment;
import hac.ex4.database.PaymentRepository;
import hac.ex4.database.Product;
import hac.ex4.database.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class UserController {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("add" , "");
        model.addAttribute("update" , "");
        model.addAttribute("delete" , "");
        model.addAttribute("product", new Product());
        model.addAttribute("payment", new Payment());
        model.addAttribute("payments", paymentRepository.findAll());
        model.addAttribute("products", productRepository.findAll());
        return "admin";
    }

    @GetMapping("/cart")
    public String cart(){
        return "cart";
    }
}
