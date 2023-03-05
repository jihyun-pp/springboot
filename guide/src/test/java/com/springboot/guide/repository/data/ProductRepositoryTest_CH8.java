package com.springboot.guide.repository.data;

import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDateTime;

@SpringBootTest
public class ProductRepositoryTest_CH8 {
    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("정렬 및 페이징 테스트")
    void sortingAndPagingTest(){
        Product product1 = new Product();
        product1.setName("펜");
        product1.setPrice(1000);
        product1.setStock(300);
        product1.setCreatedAt(LocalDateTime.now());
        product1.setUpdatedAt(LocalDateTime.now());

        Product product2 = new Product();
        product2.setName("펜");
        product2.setPrice(5000);
        product2.setStock(200);
        product2.setCreatedAt(LocalDateTime.now());
        product2.setUpdatedAt(LocalDateTime.now());

        Product product3 = new Product();
        product3.setName("펜");
        product3.setPrice(3000);
        product3.setStock(150);
        product3.setCreatedAt(LocalDateTime.now());
        product3.setUpdatedAt(LocalDateTime.now());

        Product savedProduct1 = productRepository.save(product1);
        Product savedProduct2 = productRepository.save(product2);
        Product savedProduct3 = productRepository.save(product3);

        /* 결괏값 확인 */
        System.out.println(productRepository.findByNameOrderByNumberAsc("펜"));
        System.out.println(productRepository.findByNameOrderByNumberDesc("펜"));
        System.out.println(productRepository.findByNameOrderByPriceAscStockDesc("펜"));

        System.out.println("예제 8.16) " + productRepository.findByName("펜", Sort.by(Sort.Order.asc("price"))));
        System.out.println("예제 8.16) " + productRepository.findByName("펜", Sort.by(Sort.Order.asc("price"), Sort.Order.desc("stock"))));

        System.out.println("예제 8.17) " + productRepository.findByName("펜", getSort()));

        System.out.println("예제 8.18) " + productRepository.findByName("펜", PageRequest.of(0, 2)));

        Page<Product> productPage = productRepository.findByName("펜", PageRequest.of(0, 2));
        System.out.println("예제 8.20) " + productPage.getContent());

        System.out.println(productRepository.findByName("펜", PageRequest.of(0, 2, Sort.by(Sort.Order.asc("price")))));
        System.out.println(produ트ctRepository.findByName("펜", PageRequest.of(0, 2, Sort.by(Sort.Order.asc("price")))).getContent());

    }

    private Sort getSort() {
        // 예제 8.17
        return Sort.by(Sort.Order.asc("price"), Sort.Order.desc("stock"));
    }
}
