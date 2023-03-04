package com.springboot.guide.repository.data;

import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class ProductRepositoryTestByH2 {

    /**
     * @DataJpaTest
     * JPA와 관련된 설정만 로드해서 테스트를 진행한다.
     * 기본적으로 @Transactional 어노테이션을 포함하고 있어 테스트 코드가 종료되면 자동으로 DB 롤백을 진행한다.
     * 기본값으로 임베디드 DB를 사용한다. 다른 DB를 사용하려면 별도 설정이 필요하다.
     */

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
