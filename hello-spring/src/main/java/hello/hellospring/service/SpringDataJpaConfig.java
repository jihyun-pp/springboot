package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDataJpaConfig {
    // Spring Data JPA 인터페이스 가져다가 구현 ??

    private final MemberRepository memberRepository;

    public SpringDataJpaConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository);
    }

}
