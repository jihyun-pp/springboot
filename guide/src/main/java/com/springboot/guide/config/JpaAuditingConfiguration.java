package com.springboot.guide.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
public class JpaAuditingConfiguration {
    // main() 클래스에 @EnableJpaAuditing를 추가했을 때 @WebMvcTest 같은 어노테이션에서 오류가 발상할 수 있다.
    // 해당 문제를 해결하기 위해 별도의 Configuration 클래스를 생성해서 애플리케이션 클래스의 기능과 분리해서 활성화할 수 있다.

}
