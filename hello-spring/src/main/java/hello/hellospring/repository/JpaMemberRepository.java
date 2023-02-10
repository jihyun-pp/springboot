package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;
    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {  // insert
        em.persist(member);
        return member;
        /**
         * JPA 데이터 변경 시 트랜잭션 안에서 실행되어야 함 > Service 단에 @Transactional
         */
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // jpql ? 쿼리지향언어?
        List<Member> result = em.createQuery("select m from Member m where m.name= : name", Member.class)
                .setParameter("name", name).getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // 객체(멤버 엔티티)를 대상으로 쿼리를 던짐
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

}

