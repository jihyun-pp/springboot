package com.springboot.guide.controller;

import com.springboot.guide.data.dto.ProductDto;
import com.springboot.guide.data.dto.ProductResponseDto;
import com.springboot.guide.service.impl.ProductServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;
    // 컨트롤러의 API 테스트를 하기 위한 객체 , 정확히는 서블릿 컨테이너의 구동 없이 가상의 MVC 환경에서 모의 HTTP 서블릿을 요청하는 유틸리티 클래스

    @MockBean
    ProductServiceImpl productService;
    // 컨트롤러가 의존성을 갖고 있던 서비스 객체에 Mock 객체를 주입

    @Test
    @DisplayName("MockMvc를 통한 Product 데이터 가져오기 테스트")
    void getProductTest() throws Exception {

        // 해당 객체에서 어떤 메서드가 호출되고 어떤 파라미터를 주입받는지 가정한 후 willReturn() 메서드를 통해 어떤 결과를 리턴할 것인지 정의하는 구조
        given(productService.getProduct(123L)).willReturn(new ProductResponseDto(123L, "pen", 5000, 2000));

        String productId = "123";

        // perform : HTTP 메서드로 URL을 정의해서 사용(get, post, put, delete 메서드 제공), MockHttpServletRequestBuilder 객체를 리턴 받음
        // andExpect : ResultMatcher를 활용해 결괏값 검증 수행
        // andDo : 요청과 응답의 전체 내용을 확인하기 위함
        mockMvc.perform(MockMvcRequestBuilders.get("/product?number=" + productId))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.number").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.price").exists())
                .andExpect(MockMvcResultMatchers.jsonPath("$.stock").exists())
                .andDo(MockMvcResultHandlers.print());

        verify(productService).getProduct(123L);
        // 지정한 메서드가 실행됐는지 검증하는 역할
        // 일반적으로 given()에 정의된 동작과 대응
    }

}
