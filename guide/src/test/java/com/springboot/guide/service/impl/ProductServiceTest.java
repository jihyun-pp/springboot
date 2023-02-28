package com.springboot.guide.service.impl;

import com.springboot.guide.data.dto.ProductResponseDto;
import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.verify;

import java.util.Optional;

public class ProductServiceTest {
    // 서비스 객체 테스트

    private ProductRepository productRepository;
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUpTest(){
        productService = new ProductServiceImpl(productRepository);
        // 모든 테스트 메서드 실행 전에 호출되어 서비스 객체를 생성한 후 테스트가 진행됨
    }

    @Test
    void getProductTest(){
        Product givenProduct = new Product();
        givenProduct.setNumber(123L);
        givenProduct.setName("pen");
        givenProduct.setPrice(3000);
        givenProduct.setStock(200);

        Mockito.when(productRepository.findById(123L)).thenReturn(Optional.of(givenProduct));

        ProductResponseDto productResponseDto = productService.getProduct(123L);

        Assertions.assertEquals(productResponseDto.getNumber(), givenProduct.getNumber());
        Assertions.assertEquals(productResponseDto.getName(), givenProduct.getName());
        Assertions.assertEquals(productResponseDto.getPrice(), givenProduct.getPrice());
        Assertions.assertEquals(productResponseDto.getStock(), givenProduct.getStock());

        verify(productRepository).findById(123L);  // Assertions 검증 이후 마지막 검증 보완을 위해 verify 사용
    }



}
