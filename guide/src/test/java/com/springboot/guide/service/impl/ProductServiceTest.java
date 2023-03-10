package com.springboot.guide.service.impl;

import com.springboot.guide.data.dto.ProductDto;
import com.springboot.guide.data.dto.ProductResponseDto;
import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

import java.util.Optional;

public class ProductServiceTest {
    // 서비스 객체 테스트

    private ProductRepository productRepository = Mockito.mock(ProductRepository.class);  // 주입X , 직접 Mock 객체를 생성
    private ProductServiceImpl productService;

    @BeforeEach
    public void setUpTest(){
        productService = new ProductServiceImpl(productRepository);
        // 모든 테스트 메서드 실행 전에 호출되어 서비스 객체를 생성한 후 테스트가 진행됨
    }

    @Test
    @DisplayName("Product 호출 테스트")
    void getProductTest(){
        // given : 객체 생성 및 Repository 동작에 대한 리턴 설정
        Product givenProduct = new Product();
        givenProduct.setNumber(123L);
        givenProduct.setName("pen");
        givenProduct.setPrice(3000);
        givenProduct.setStock(200);
        Mockito.when(productRepository.findById(123L)).thenReturn(Optional.of(givenProduct));

        // when : 동작 테스트
        ProductResponseDto productResponseDto = productService.getProduct(123L);

        // then : Assertion으로 값 검증
        Assertions.assertEquals(productResponseDto.getNumber(), givenProduct.getNumber());
        Assertions.assertEquals(productResponseDto.getName(), givenProduct.getName());
        Assertions.assertEquals(productResponseDto.getPrice(), givenProduct.getPrice());
        Assertions.assertEquals(productResponseDto.getStock(), givenProduct.getStock());

        verify(productRepository).findById(123L);  // Assertions 검증 이후 마지막 검증 보완을 위해 verify 사용
    }

    @Test
    @DisplayName("Product 저장 테스트")
    void saveProductTest(){
        // given
        Mockito.when(productRepository.save(any(Product.class))).then(returnsFirstArg());

        // when
        ProductResponseDto productResponseDto = productService.saveProduct(new ProductDto("pen", 5000, 200));

        // then
        Assertions.assertEquals(productResponseDto.getName(), "pen");
        Assertions.assertEquals(productResponseDto.getPrice(), 5000);
        Assertions.assertEquals(productResponseDto.getStock(), 200);

        verify(productRepository).save(any());

        /**
         * any() : Mockito의 ArgumentMatchers에서 제공하는 메서드로 Mock 객체의 동작을 정의하거나 검증하는 단계에서 조건으로
         *         특정 매개변수의 전달을 설정하지 않고 메서드의 실행만을 확인하거나 좀 더 큰 범위의 클래스 객체를 매개변수로 전달받는
         *         등의 상황에서 사용한다. 일반적으로 given()으로 정의된 Mock 객체의 메서드 동작 감지는 매개변수의 비교를 통해
         *         이뤄지나 레퍼런스 변수의 비교는 주솟값으로 이뤄지기 때문에 any()를 사용해 정의하는 경우도 있다.
         */

    }


}
