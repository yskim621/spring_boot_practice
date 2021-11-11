package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor // 여기서는 아래 EntityManager에 final을 제외하고 @PersistenceContext를 한 것과 같은 기능
public class MemberRepository {

    // @PersistenceContext
    private final EntityManager em;

    /*
    public MemberRepository(EntityManager em) {
        this.em = em;
    }*/

    // Command 와 Query 분리 원칙에 따라
    // 아래 Command 의 side effect 방지를 위해 리턴 값을 생성 하지 않음
    /*public Long save(Member member){
        em.persist(member);
        return member.getId();
    }*/

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
