package com.springboot.guide.repository.data;

import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.entity.QProduct;
import com.springboot.guide.data.repository.QProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.querydsl.core.types.Predicate;

import java.util.Optional;

@SpringBootTest
public class QProductRepositoryTest {

    @Autowired
    QProductRepository qProductRepository;

    @Test
    @DisplayName("Predicate를 활용한 fineOne() 메서드 호출")
    public void queryDSLTest1(){
        // Predicate : 표현식으로 정의하는 쿼리
        Predicate predicate = (Predicate) QProduct.product.name.containsIgnoreCase("펜")
                .and(QProduct.product.price.between(100, 2500));

        Optional<Product> foundProduct = qProductRepository.findOne(predicate);

        if(foundProduct.isPresent()){
            Product product = foundProduct.get();
            System.out.println(product.getName());
        }
    }


    @Test
    @DisplayName("findAll() 메서드 호출")
    public void queryDSLTest2(){
        // Predicate 명시적 X , 서술부만 사용
        QProduct qProduct = QProduct.product;

        Iterable<Product> products = qProductRepository.findAll(
                qProduct.name.contains("펜").and(qProduct.price.between(500, 1500))
        );

        for (Product product : products){
            System.out.println(product.getName());
            System.out.println(product.getPrice());
        }
    }
}
