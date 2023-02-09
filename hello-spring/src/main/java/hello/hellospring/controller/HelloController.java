package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

}
