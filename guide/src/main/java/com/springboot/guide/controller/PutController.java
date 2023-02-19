package com.springboot.guide.controller;

import com.springboot.guide.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    // PUT : 서버를 통해 데이터베이스 같은 저장소에 존재하는 리소스 값을 업데이트 하는 데에 사용, 리소스를 서버에 전달하기 위해 body 활용

    /**
     * RequestBody
     */
    @PutMapping("/member")
    public String putMember(@RequestBody Map<String, String> putData){
        StringBuilder sb = new StringBuilder();
        putData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PutMapping("/member2")
    public String putMemberDto(@RequestBody MemberDto dto){
        return dto.toString();
    }

    /**
     * ResponseEntity
     */
    @PutMapping("/member3")
    public ResponseEntity<MemberDto> pubMemberResEntity(@RequestBody MemberDto dto){
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(dto);  // 응답코드 202
    }

}
