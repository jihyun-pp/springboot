package com.springboot.guide.data.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name="product")
public class Product {

    /**
     * spring.jpa.hibernate.ddl-auto=create : 테이블 생성 가능
     *
     * @Entity : 해당 클래스가 엔티티임을 명시, 클래스 자체는 테이블과 일대일로 매칭
     * @Table : 테이블과 1:1 매핑이므로 생략 가능, 테이블 이름과 엔티티 이름이 다를 경우 사용
     * @Id : 테이블 PK, 모든 엔티티 클래스 필수
     * @GeneratedValue : @Id 와 같이 사용, 해당 필드의 값을 어떤 방식으로 자동 생성할 지 결정
     *      1. 사용 X : 애플리케이션에서 자체적으로 PK 생성할 경우 / 내부에 정해진 규칙에 의해 기본값을 생성 식별자로 사용
     *      2. AUTO : 기본값을 사용하는 DB에 맞게 자동 생성
     *      3. IDENTITY : DB에 위임 (AUTO_INCREMENT)
     *      4. SEQUENCE : @SequenceGenerator 어노테이션으로 식별자 생성기를 설정하고 값을 자동 주입 받음
     *      5. TABLE : 식별자로 사용할 숫자의 보관 테이블을 별도로 생성해서 엔티티를 생성할 때마다 값을 갱신하여 사용 (@TableGenerator)
     * @Column : 필드는 자동으로 테이블 컬럼과 매핑됨. 설정을 추가할 경우 사용.
     *      - name, nullable, length, unique
     * @Transient : DB에는 필요없는 경우 필드로만 사용하고 DB에는 추가하지 않을 수 있음
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private Integer stock;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
