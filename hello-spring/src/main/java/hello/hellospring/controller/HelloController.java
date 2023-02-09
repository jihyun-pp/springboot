package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Hello! World!");
        return "hello";
        // template engine >> viewResolver 역할
        // 스프링 부트 템플릿 엔진이 기본 viewName을 매핑해줌
        // `resources:templates/` + {veiwName} + `.html`
    }

    @GetMapping("hello-mvc")
    public String helloMVC (@RequestParam(value = "name", required = false) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }
    // @RequestParam(required = false) : querystring 값이 넘어오지 않아도 오류 발생 X

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }
    // @ResponseBody
    // view 거치지 않고 바로 데이터를 받음 > viewResolver 호출 X > HttpMessageConverter 호출
    // 페이지 소스 보면 return 값만 있음!!
    // HTTP의 BODY에 문자 내용을 직접 반환 > 문자는 StringHttpMessageConverter 호출
    // byte 처리 등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    // 기본 정책 - 객체가 넘어올 경우 JSON 형식으로 객체 전송
    // 객체는 MappingJackson2HttpMessageConverter 동작

    static class Hello {
        // java bean 규약 (관례) , 프로퍼티 접근 방식
        private String name;

        public String getName() {   // command + N : getter setter
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
