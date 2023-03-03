package com.springboot.guide.service.impl;

import com.springboot.guide.data.dto.ProductDto;
import com.springboot.guide.data.dto.ProductResponseDto;
import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.repository.ProductRepository;
import com.springboot.guide.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@Import({ProductServiceImpl.class})
class ProductServiceTest2 {

    @MockBean
    ProductRepository productRepository;  // MockBean 어노테이션을 이용해 주입받아서 Mock 객체를 사용

    @Autowired
    ProductService productService;

    @Test
    @DisplayName("Product 호출 테스트")
    void getProductTest(){
        // given
        Product givenProduct = new Product();
        givenProduct.setNumber(123L);
        givenProduct.setName("pen");
        givenProduct.setPrice(3000);
        givenProduct.setStock(200);
        Mockito.when(productRepository.findById(123L)).thenReturn(Optional.of(givenProduct));

        // when
        ProductResponseDto productResponseDto = productService.getProduct(123L);

        // then
        Assertions.assertEquals(productResponseDto.getNumber(), givenProduct.getNumber());
        Assertions.assertEquals(productResponseDto.getName(), givenProduct.getName());
        Assertions.assertEquals(productResponseDto.getPrice(), givenProduct.getPrice());
        Assertions.assertEquals(productResponseDto.getStock(), givenProduct.getStock());

        verify(productRepository).findById(123L);
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
    }


}
