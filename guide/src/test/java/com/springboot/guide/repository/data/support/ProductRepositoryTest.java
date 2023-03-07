package com.springboot.guide.repository.data.support;

import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.repository.support.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("QuerydslRepositorySupport 테스트")
    void findByNameTest(){
        List<Product> productList = productRepository.findByName("펜");

        for(Product product : productList){
            System.out.println(product.getName());
            System.out.println(product.getNumber());
        }
    }

}
