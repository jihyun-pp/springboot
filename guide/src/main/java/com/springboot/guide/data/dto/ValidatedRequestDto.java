package com.springboot.guide.data.dto;

import com.springboot.guide.data.group.ValidationGroup1;
import com.springboot.guide.data.group.ValidationGroup2;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidatedRequestDto {
    @NotBlank
    private String name;

    @Id
    @Email
    private String email;

    @Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}||\\d{4})[.-]?(\\d{4})$")
    private String phone;

    @Min(value = 20, groups = ValidationGroup1.class)
    @Max(value = 40, groups = ValidationGroup2.class)
    private int age;

    @Size(min = 0, max = 40)
    private String description;

    @Positive(groups = ValidationGroup2.class)
    private int count;

    @AssertTrue
    private boolean booleanCheck;

}

