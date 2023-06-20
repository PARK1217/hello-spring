package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface MemberRepository {

    Member save(Member member);
    Optional<Member> findById(Long id); //Optional : null을 처리하는 방법
    Optional<Member> findByName(String name);
    //Optional로 감싸서 반환하는 것은 클라이언트에서 처리할 수 있도록 한다.
    //null을 처리하는 방법은 Optional로 감싸서 반환하는 것이다.
    //Optional로 감싸면 클라이언트에서 처리할 수 있도록 한다.
    List<Member> findAll();
}
