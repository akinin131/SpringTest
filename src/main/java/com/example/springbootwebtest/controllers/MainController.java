package com.example.springbootwebtest.controllers;

import com.example.springbootwebtest.entities.Product;
import com.example.springbootwebtest.servies.ProductServies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MainController {

    private  ProductServies productServies;

    // Аннотация @Autowired отмечает конструктор,
    // поле или метод как требующий автозаполнения инъекцией зависимости Spring.
    // Данная аннотация впервые появилась в Spring 2.5

    @Autowired
    public void setProductServies(ProductServies productServies) {
        this.productServies = productServies;
    }

    @GetMapping("/index") //перехватить запрос
    public String homepage() {
        return "index";

    }

    @GetMapping("/shop")
    public String homeshope(Model model) {

        List<Product> allProducts = productServies.getAllProducts();
        model.addAttribute("prod", allProducts);
        return "shop";



    }
    //@PathVariable можно использовать для обработки переменных шаблона в отображении URI запроса
    @GetMapping("/details/{id}")
    public String homeshope(Model model, @PathVariable("id") Long id) {
      Product selectProduct = productServies.getProductById(id);
        model.addAttribute("products", selectProduct);
        return "redirect:/shop";

    }
    @GetMapping("/products/delete/{id}")
    public String deleteProductById(@PathVariable("id") Long id) {
        productServies.deleteProductById(id);
        return "redirect:/shop";
    }
    @GetMapping("/data")
    @ResponseBody
    public String dataExample(@RequestParam(value = "serial") Long serial, @RequestParam("number") Long number) {
        return "S/N: " + serial + " / " + number;
    }


}

