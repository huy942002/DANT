package com.model.controller;

import com.model.entities.Product;
import com.model.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;

    @RequestMapping({"/", "/home", "/home/index"})
    public String index() {
    return "redirect:/product/list";
}

    @RequestMapping("admin/home")
    public String admin(){return "redirect:/assets/admin/index.html";}

    @RequestMapping("/product/list")
    public String list(Model model) {
        List<Product> list = productService.findAll();
        model.addAttribute("items", list);
        return "product/list";
    }
}
