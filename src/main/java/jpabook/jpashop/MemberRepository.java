package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;


    // Command 와 Query 분리 원칙에 따라
    // 아래 Command 의 side effect 방지를 위해 리턴 값을 생성 하지 않음
    public Long save(Member member){
        em.persist(member);
        return member.getId();
    }
}
