package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // 스프링 데이터 JPA가 proxy를 이용해서 SpringDataJpaMemberRepository를 자동으로 스프링 빈 객체를 생성해 줌

    @Override
    Optional<Member> findByName(String name);
    // JPQL > select m from Member m where m.name = ?
}
