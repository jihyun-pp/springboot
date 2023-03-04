package com.springboot.guide.repository.data;

import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.assertj.core.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


@SpringBootTest
public class ProductRepositoryTest2 {

    // 테스트 데이터베이스를 마리아디비로 변경하기 위한 테스트

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("CRUD 테스트")
    public void basicCRUDTest(){
        /** CREATE */
        // given
        Product givenProduct = Product.builder().name("note").price(1500).stock(400).build();

        // when
        Product savedProduct = productRepository.save(givenProduct);

        // then
        Assertions.assertThat(savedProduct.getNumber()).isEqualTo(givenProduct.getNumber());
        Assertions.assertThat(savedProduct.getName()).isEqualTo(givenProduct.getName());
//        Assertions.assertEquals(givenProduct.getName(), savedProduct.getName());
        Assertions.assertThat(savedProduct.getPrice()).isEqualTo(givenProduct.getPrice());
        Assertions.assertThat(savedProduct.getStock()).isEqualTo(givenProduct.getStock());

        /** READ */
        // when
        Product selectedProduct = productRepository.findById(savedProduct.getNumber()).orElseThrow(RuntimeException::new);

        // then
        Assertions.assertThat(selectedProduct.getNumber()).isEqualTo(givenProduct.getNumber());
        Assertions.assertThat(selectedProduct.getName()).isEqualTo(givenProduct.getName());
        Assertions.assertThat(selectedProduct.getPrice()).isEqualTo(givenProduct.getPrice());
        Assertions.assertThat(selectedProduct.getStock()).isEqualTo(givenProduct.getStock());

        /** UPDATE */
        // when
        Product foundProduct = productRepository.findById(givenProduct.getNumber()).orElseThrow(RuntimeException::new);
        foundProduct.setName("노트");
        Product updatedProduct = productRepository.save(foundProduct);

        // then
        assertEquals(updatedProduct.getName(), "노트");

        /** DELETE */
        // when
        productRepository.delete(updatedProduct);

        // then
        assertFalse(productRepository.findById(selectedProduct.getNumber()).isPresent());

    }


}
