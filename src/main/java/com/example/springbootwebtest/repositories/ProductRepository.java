package com.example.springbootwebtest.repositories;


import com.example.springbootwebtest.entities.Product;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductRepository {
    private List<Product> products;



    public  List<Product> getProducts(){
        return products;
    }

    @PostConstruct // когда бин подготовит выполниться это действие
    public void init(){
        products = new ArrayList<>();
        products.add(new Product(1L, "MILK", 80));
        products.add(new Product(2L, "MILK", 80));
        products.add(new Product(3L, "MILK", 80));
        products.add(new Product(4L, "MILK", 80));
        products.add(new Product(5L, "MILK", 80));


    }
    public void deleteBiId(Long id)
    {
        for (int i = 0; i <products.size() ; i++) {
            if(products.get(i).getId().equals(id)){
                products.remove(i);
                return;
            }
        }
    }
    //Аннотация PostConstruct используется для метода, который необходимо выполнить после внедрения зависимости для выполнения
    // любой инициализации. Этот метод ДОЛЖЕН быть вызван до того, как класс введен в эксплуатацию. Эта аннотация ДОЛЖНА
    // поддерживаться всеми классами, которые поддерживают внедрение зависимостей
}
