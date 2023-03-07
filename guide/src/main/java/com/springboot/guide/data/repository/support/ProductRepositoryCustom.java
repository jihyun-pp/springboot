package com.springboot.guide.data.repository.support;

import com.springboot.guide.data.entity.Product;

import java.util.List;

public interface ProductRepositoryCustom {
    List<Product> findByName(String name);
}
