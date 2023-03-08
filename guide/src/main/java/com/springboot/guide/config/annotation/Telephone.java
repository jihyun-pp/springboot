package com.springboot.guide.config.annotation;

import com.springboot.guide.config.TelephoneValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TelephoneValidator.class)
public @interface Telephone {
    String message() default "전화번호 형식이 일치하지 않습니다.";
    Class[] groups() default {};
    Class[] payload() default {};

    /**
     * @Target : 어디서 선언할 수 있는지 정의하는 데에 사용
     * @Retention : 이 어노테이션이 실제로 적용되고 유지되는 범위를 의미 , RetentionPolicy를 통해 적용 범위를 지정
     *              - RUNTIME :컴파일 이후에도 JVM에 의해 계속 참조된다. 리플렉션이나 로깅에 많이 사용된다.
     *              - CLASS : 컴파일러가 클래스를 참조할 때까지 유지한다.
     *              - SOURCE : 컴파일 전까지만 유지된다. 컴파일 이후 사라진다.
     * @Constraint : TelephoneValidator와 매핑하는 작업을 수행
     *              - message() : 유효성 검사가 실패할 경우 반환되는 메시지를 의미한다.
     *              - groups() : 유효성 검사를 사용하는 그룹으로 설정한다.
     *              - payload() : 사용자가 추가 정보를 위해 전달하는 값이다.
     */

}
