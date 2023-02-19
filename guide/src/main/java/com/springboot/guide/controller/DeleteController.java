package com.springboot.guide.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/delete-api")
public class DeleteController {
    /**
     * DELETE : 서버를 거쳐 DB 등 저장소에 있는 리소스 삭제할 때 사용
     *        : 서버에서는 클라이언트로부터 리소스를 식별할 수 있는 값을 받아 DB나 캐시에 있는 리소스를 조회 및 삭제 역할 수행
     */

    @DeleteMapping(value = "/{variable}")
    public String DeleteVariable(@PathVariable String variable){
        return variable;
    }

    @DeleteMapping(value = "/request1")
    public String getRequestParam(@RequestParam String email){
        return email;
    }
}
