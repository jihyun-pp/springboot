package com.springboot.guide.repository.data;

import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ProductRepositoryTest {

    // 테스트 데이터베이스를 마리아디비로 변경하기 위한 테스트

    @Autowired
    private ProductRepository productRepository;

    @Test
    @DisplayName("저장 테스트")
    void saveTest(){
        // given
        Product product = new Product();
        product.setName("pen");
        product.setPrice(3000);
        product.setStock(100);

        // when
        Product saveProduct = productRepository.save(product);

        // then
        Assertions.assertEquals(product.getName(), saveProduct.getName());
        Assertions.assertEquals(product.getPrice(), saveProduct.getPrice());
        Assertions.assertEquals(product.getStock(), saveProduct.getStock());
    }

    @Test
    @DisplayName("셀렉트 테스트")
    void selectTest(){
        // given
        Product product = new Product();
        product.setName("pen");
        product.setPrice(3000);
        product.setStock(100);

        Product saveProduct = productRepository.saveAndFlush(product);

        // when
        Product foundProduct = productRepository.findById(saveProduct.getNumber()).get();

        // then
        Assertions.assertEquals(foundProduct.getName(), saveProduct.getName());
        Assertions.assertEquals(foundProduct.getPrice(), saveProduct.getPrice());
        Assertions.assertEquals(foundProduct.getStock(), saveProduct.getStock());
    }
}
