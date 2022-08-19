package ru.zholud.spring1mvchomewerk.controlers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import ru.zholud.spring1mvchomewerk.data.Product;
import ru.zholud.spring1mvchomewerk.repositories.ProductsRepository;


@Controller
public class MainController {

    private ProductsRepository productsRepository;


    public MainController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }



    @GetMapping("/products")
    public String showProductsPage(Model model) {
        model.addAttribute("products", productsRepository.getAllProducts());
        return "products_page";
    }



    @GetMapping("/products/{id}")
    public String showProductsPage(Model model, @PathVariable Long id) {
        Product product = productsRepository.findById(id);
        model.addAttribute("product", product);
        return "product_info_page";
    }

    @GetMapping("/products/del/all")
    public String deleteAll(){
        productsRepository.deleteAllproducts();

        return "redirect:/products";
    }

    @GetMapping("/products/del/{id}")
    public String delById(@PathVariable Long id) {
        productsRepository.deleteById(id);

        return "redirect:/products";
    }

    @GetMapping("/products/add")
    public String addProduct(@RequestParam Long id, @RequestParam String title, @RequestParam Long price){

        Product product = new Product(id, title, price);
        productsRepository.add(product);

        return "redirect:/products";

    }


    @GetMapping("/products_show")
    public String showPage() {

        return "simple_form";
    }



}




