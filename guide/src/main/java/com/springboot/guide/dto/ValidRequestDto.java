package com.springboot.guide.dto;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidRequestDto {

    @NotBlank
    String name;

    @Email
    String email;

    @Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}||\\d{4})[.-]?(\\d{4})$")
    String phone;

    @Min(value = 20) @Max(value = 40)
    int age;

    @Size(min = 0, max = 40)
    String description;  // 문자열 길이 제한

    @Positive
    int count;  // 값의 범위를 검증하는 어노테이션으로 양수를 허용한다는 의미

    @AssertTrue
    boolean booleanCheck;  // true 인지 체크. null 값은 체크 X

}
