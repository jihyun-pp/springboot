package com.springboot.guide;

import org.junit.jupiter.api.*;

public class TestLifeCycle {

    @BeforeAll
    static void beforeAll(){
        System.out.println("@BeforeAll : 테스트를 시작하기 전에 호출되는 메서드를 정의 > 최초 한번");
        System.out.println();
    }

    @AfterAll
    static void afterAll(){
        System.out.println("@AfterAll : 테스트를 종료하면서 호출되는 메서드를 정의 > 마지막 한번");
    }

    @BeforeEach
    void beforeEach(){
        System.out.println("@BeforeEach : 각 테스트 메서드가 실행되기 전에 동작하는 메서드를 정의 > 매번 Test 메서드 실행 전 호출");
    }

    @AfterEach
    void afterEach(){
        System.out.println("@AfterEach : 각 테스트 메서드가 종료되면서 호출되는 메서드를 정의 > 매번 Test 메서드 실행 후 호출");
    }

    @Test
    void test1(){
        System.out.println("@Test : 테스트 코드를 포함한 메서드를 정의");
    }

    @Test
    @DisplayName("Test Case 2")
    void test2(){
        System.out.println("## Test 2 ##");
        System.out.println();
    }

    @Test
    @Disabled
    void test3(){
        System.out.println("테스트 실행 안됨");
        System.out.println("BeforeEach, AfterEach 호출 X > 비활성화되었다는 로그만 출력됨");
    }

}
