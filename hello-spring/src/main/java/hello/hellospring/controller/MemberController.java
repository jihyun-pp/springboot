package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller  // component-scan
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        // DI, 생성자 주입
        this.memberService = memberService;
    }

//    @GetMapping("join")
//    public String join(Member member){
//        memberService.join(member);
//        return "join";
//    }
}
