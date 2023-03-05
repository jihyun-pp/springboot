package com.springboot.guide.repository.data;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.entity.QProduct;
import com.springboot.guide.data.repository.ProductRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
public class QueryDSLTest {
    @Autowired
    ProductRepository productRepository;

    @PersistenceContext
    EntityManager entityManager;

    @Test
    @DisplayName("JPAQuery를 사용한 DSL테스트")
    void queryDslTest(){
        JPAQuery<Product> query = new JPAQuery<>(entityManager);
        QProduct qProduct = QProduct.product;

        // JPAQuery는 builder 형식으로 쿼리를 작성함
        List<Product> productList = query.from(qProduct).where(qProduct.name.eq("펜")).orderBy(qProduct.price.asc()).fetch();
        // List로 객체를 받기위해 fetch() 사용
        // fetch fetchOne fetchFirst fetchCount fetchResults

        for (Product product : productList) {
            System.out.println("----------------");
            System.out.println();
            System.out.println("Product Number : " + product.getNumber());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println();
            System.out.println("----------------");
        }
    }

    @Test
    @DisplayName("JPAQueryFactory를 사용한 DSL 테스트")
    void queryDSLTest2(){
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<Product> productList = jpaQueryFactory.selectFrom(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Product product : productList) {
            System.out.println("----------------");
            System.out.println();
            System.out.println("Product Number : " + product.getNumber());
            System.out.println("Product Name : " + product.getName());
            System.out.println("Product Price : " + product.getPrice());
            System.out.println("Product Stock : " + product.getStock());
            System.out.println();
            System.out.println("----------------");
        }
    }

    @Test
    @DisplayName("특정컬럼만 select")
    void queryDSLTest3(){
        JPAQueryFactory jpaQueryFactory = new JPAQueryFactory(entityManager);
        QProduct qProduct = QProduct.product;

        List<String> productList = jpaQueryFactory
                .select(qProduct.name)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (String product : productList) {
            System.out.println("----------------");
            System.out.println("Product Name : " + product);
            System.out.println("----------------");
        }

        // select할 특정 컬럼이 여러 개일 경우
        List<Tuple> tupleList = jpaQueryFactory.select(qProduct.name, qProduct.price)
                .from(qProduct)
                .where(qProduct.name.eq("펜"))
                .orderBy(qProduct.price.asc())
                .fetch();

        for (Tuple product : tupleList) {
            System.out.println("----------------");
            System.out.println("Product Name : " + product.get(qProduct.name));
            System.out.println("Product Name : " + product.get(qProduct.price));
            System.out.println("----------------");
        }
    }
}
