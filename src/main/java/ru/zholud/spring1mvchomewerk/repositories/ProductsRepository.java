package ru.zholud.spring1mvchomewerk.repositories;

import org.springframework.stereotype.Component;
import ru.zholud.spring1mvchomewerk.data.Product;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class ProductsRepository {

    private List<Product> products;

    @PostConstruct
    public void  init() {
        products = new ArrayList<>(List.of(
                new Product(1L, "Milch", 32L),
                new Product(2L, "Brot", 25L),
                new Product(3L, "Buter", 120L),
                new Product(4L, "Fleich", 420L),
                new Product(5L, "Wein", 1250L),
                new Product(6L, "Case", 330L),
                new Product(7L, "Wasser", 150L)
        ));

    }

    public List<Product> getAllProducts() {

        return Collections.unmodifiableList(products);
    }

    public Product findById(Long id) {
        return products.stream()
                .filter(s -> s.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Product hat man nischt gesucht!"));
    }

    public void add(Product p) {

        products.add(p);

    }

    public void deleteAllproducts() {

        products.clear();
    }

    public void deleteById(Long id) {

        products.removeIf(p -> p.getId().equals(id));
    }


}
