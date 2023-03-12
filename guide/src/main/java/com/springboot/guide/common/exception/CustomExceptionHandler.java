package com.springboot.guide.common.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

//@RestControllerAdvice(basePackages = "com.springboot.guide")  // 예외를 관리하는 범위를 설정할 수 있음
@RestControllerAdvice
public class CustomExceptionHandler {

    /**
     * @RestControllerAdvice + @ControllerAdvice
     * Controller, RestController 어노테이션에서 발생하는 예외를 한곳에서 관리하고 처리할 수 있게 하는 기능을 수행한다.
     * AOP를 적용한 것이다.
     * 해당 어노테이션 클래스 내의 @ExceptionHandler는 모든 컨트롤러에서 발생하는 예외상황을 잡을 수 있다.
     */

    private final Logger logger = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(value = RuntimeException.class)  // 컨트롤러에서 해당 오류가 발생하면 실행되는 메서드
    public ResponseEntity<Map<String, String>> handleException(RuntimeException e, HttpServletRequest request){
        HttpHeaders responseHeaders = new HttpHeaders();
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;

        logger.error("Advice 내 handleException 호출, {}, {}", request.getRequestURI(), e.getMessage());

        Map<String, String> map = new HashMap<>();
        map.put("error type", httpStatus.getReasonPhrase());
        map.put("code", "400");
        map.put("message", e.getMessage());

        return new ResponseEntity<>(map, responseHeaders, httpStatus);
    }




}
