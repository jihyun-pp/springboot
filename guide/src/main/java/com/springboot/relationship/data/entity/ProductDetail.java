package com.springboot.relationship.data.entity;

import lombok.*;

import javax.persistence.*;

// CH09 연관관계 매핑

@Entity
@Table(name = "product_detail")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class ProductDetail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @OneToOne
    @JoinColumn(name = "product_number")
    private Product product;
    // 일대일 단방향 매핑 > 상품번호에 매핑하기 위해 사용

    // @JoinColumn 어노테이션 : 매핑할 외래키 설정
    // 속성
    // 1. name : 매핑할 외래키의 이름 설정
    // 2. referencedColumnName : 외래키가 참조할 상대 테이블의 컬럼명 지정
    // 3. foreignKey : 외래키 생성 시에 지정할 제약조건 설정 (unique, nullable, insertable, updatable 등)
}
