package com.springboot.guide.data.repository;

import com.springboot.guide.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface QProductRepository extends JpaRepository<Product, Long>, QuerydslPredicateExecutor<Product> {
    /**
     * QuerydslPredicateExecutor
     * 메서드 대부분이 Predicate 타입을 매개변수로 받는다. Predicate 는 표현식을 작성할 수 있게 QueryDSL 에서 제공하는 인터페이스이다.
     * Optional<T> findOne(Predicate predicate);
     */
}
