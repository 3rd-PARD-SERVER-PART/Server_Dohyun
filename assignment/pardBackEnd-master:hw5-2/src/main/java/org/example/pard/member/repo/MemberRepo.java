package org.example.pard.member.repo;

import org.example.pard.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


// JpaRepository를 사용하여 menber entity에 대한 CRUD를 할 수 있는 method를 제공한다,
public interface MemberRepo extends JpaRepository<Member, Long> {
   // Spring data JPA는 매서드 이름을 분석하여 적절한 query 만들어냄
   List<Member> findByPart(String part);
}
