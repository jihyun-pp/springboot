package com.springboot.guide.controller;

import com.springboot.guide.dto.MemberDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {
    // POST : DB 등 저장소에 리소스를 저장할 때 사용, 데이터를 body에 담아 URI가 GET API에 비해 간단함

    // Logback
    private final Logger logger = LoggerFactory.getLogger(PostController.class);

    // @RequestMapping(value = "domain", method = RequestMethod.POST)
    @PostMapping("/domain")
    public String postExample(){
        logger.info("postExample() 메소드 호출");
        return "API : Application Programming Interface";
    }

    /**
     * @RequestBody : HTTP의 Body 내용을 해당 어노테이션이 지정된 객체에 매핑하는 역할
     */
    @PostMapping("/member")
    public String postMember(@RequestBody Map<String, String> postData){
        logger.info("postMember() 메소드 호출");
        StringBuilder sb = new StringBuilder();
        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });

        return sb.toString();
    }

    @PostMapping("/member2")
    public String postMemberDto(@RequestBody MemberDto dto){
        logger.info("postMemberDto() 메소드 호출");
        return dto.toString();
    }

}
