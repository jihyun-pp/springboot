package com.springboot.guide;

import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class JpaAuditingTest {

    @Autowired
    ProductRepository productRepository;

    @Test
    @DisplayName("Auditing Test")
    public void auditingTest(){
        Product product = new Product();
        product.setName("pen");
        product.setPrice(3000);
        product.setStock(1000);

        Product savedProduct = productRepository.save(product);

        System.out.println("Product Name : " + savedProduct.getName());
        System.out.println("Product CreateAt : " + savedProduct.getCreatedAt());
    }

    /**
     * JPA Auditing
     * 엔티티 클래스에 공통적으로 들어가는 필드를 매번 생성하거나 변경할 때 값을 주입해야하는 번거로움을 해소하기 위한 기능
     * 대표적으로 생성 주체, 생성일, 변경 주체, 변경일 필드가 쓰인다.
     */

}
