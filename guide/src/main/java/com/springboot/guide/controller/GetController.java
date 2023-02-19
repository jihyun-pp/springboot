package com.springboot.guide.controller;

import com.springboot.guide.dto.MemberDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {
    // 클래스 수준에 @RequestMapping을 설정하면 내부 메서드의 URL 리소스 앞에 공통 값이 추가 됨.

//    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    /**
     * @GetMapping + @PathVariable
     */
    // http://localhost:8080/api/vi/get-api/variable/{string 값}
    @GetMapping("/variable/{variable}")
    public String getVariable(@PathVariable String variable){
        // @PathVariable : 매개변수 연결
        // @GetMapping <-> @PathVariable 변수 이름 같아야 함
        return variable;
    }

    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        // @GetMapping <-> @PathVariable 변수 이름이 다를 경우
        return var;
    }

    /**
     * @RequestParam : query string 사용
     */
    @ApiOperation(value = "GET 메소드 예제", notes = "@RequestParam 활용한 GET Method")
    @GetMapping("/request1")
    public String getRequestParam(
            @ApiParam(value = "이름", required = true) @RequestParam String name,
            @ApiParam(value = "이메일", required = true) @RequestParam String email){
        // @ApiOperation : 대상 API의 설명을 작성하기 위한 어노테이션
        // @ApiParam : 매개변수에 대한 설명 및 설정을 위한 어노테이션 > 매개변수 + DTO 클래스 내의 매개변수까지 정의 가능

        return name + ", " + email;
    }

    @GetMapping("/request2")
    public String getRequestParamMap(@RequestParam Map<String, String> param){
        // 쿼리스트링에 어떤 값이 들어올 지 모를 때 Map 객체 이용
        // 매개변수의 항목이 일정하지 않을 수 있을 땐 Map 객체로 받는 것이 효율적임
        StringBuilder sb = new StringBuilder();
        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    /**
     * DTO 객체 활용
     * DTO(Data Transfer Object) : 다른 레이어 간의 데이터 교환에 활용, 각 클래스 및 인터페이스를 호출하면서 전달하는 매개변수로 사용되는 데이터 객체
     */
    @GetMapping("/request3")
    public String getRequestParamDTO(MemberDto dto){
//        return dto.getName() + ", " + dto.getEmail();
        return dto.toString();
    }

}
