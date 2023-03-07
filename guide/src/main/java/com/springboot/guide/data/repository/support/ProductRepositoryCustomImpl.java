package com.springboot.guide.data.repository.support;

import com.springboot.guide.data.entity.Product;
import com.springboot.guide.data.entity.QProduct;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductRepositoryCustomImpl extends QuerydslRepositorySupport implements ProductRepositoryCustom {

    public ProductRepositoryCustomImpl() {
        // QuerydslRepositorySupport를 상속받으면 생성자를 통해 도메인 클래스를 부모 클래스에 전달해야 한다.
        super(Product.class);
    }

    @Override
    public List<Product> findByName(String name) {
        QProduct product = QProduct.product;

        List<Product> productList = from(product).where(product.name.eq(name)).select(product).fetch();
        // from() : 어떤 domain에 접근할 것인지 지정하는 역할을 수행하고 JPAQuery를 리턴한다.

        return productList;
    }
}
