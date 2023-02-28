package com.springboot.guide.data.dto;

import lombok.*;

import javax.persistence.Entity;

@Data
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private String name;
    private int price;
    private int stock;
}
