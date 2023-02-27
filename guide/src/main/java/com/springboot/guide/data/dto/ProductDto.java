package com.springboot.guide.data.dto;

import lombok.*;

import javax.persistence.Entity;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String name;
    private int price;
    private int stock;
}
