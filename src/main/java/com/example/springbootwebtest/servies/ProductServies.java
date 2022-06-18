package com.example.springbootwebtest.servies;

import com.example.springbootwebtest.entities.Product;
import com.example.springbootwebtest.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component // анотация говорит что по этому классу Spring должен создать объект
public class ProductServies {
    private ProductRepository productRepository;
        @Autowired
        public void setProductRepository(ProductRepository productRepository){
            this.productRepository = productRepository;
        }


            public List <Product> getAllProducts(){
            return productRepository.getProducts();
            }

        public Product getProductById(Long id){
           return productRepository.getProducts().get(id.intValue()-1);


        }
    public void deleteProductById(Long id){
            productRepository.deleteBiId(id);


    }

    }
//@Component - Аннотация для любого компонента фреймворка. @Service - (Сервис-слой приложения)
// Аннотация, объявляющая, что этот класс представляет собой сервис – компонент сервис-слоя.
// Сервис является подтипом класса @Component. Использование данной аннотации позволит искать бины-сервисы автоматически.


//@Component – это аннотация, которая позволяет Spring автоматически определять ваши пользовательские компоненты.
// Другими словами, без необходимости писать какой-либо явный код, Spring будет: Сканируйте
// наше приложение на наличие классов
// с аннотациями



