package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();    //테스트가 끝날 때마다 repository를 깔끔하게 지워준다.
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

//        Assertions.assertEquals(member, result);    //Assertions.assertEquals(기대하는 값, 실제 값)
        //Assertions.assertEquals(member, null);    //실패 케이스
        assertThat(member).isEqualTo(result);    //Assertions.assertThat(기대하는 값).isEqualTo(실제 값)
    }


    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);   //repository에 저장

        Member member2 = new Member();

        member2.setName("spring2");
        repository.save(member2);   //repository에 저장

        Member result = repository.findByName("spring1").get();   //spring1이라는 이름을 가진 member를 찾아서 반환

        assertThat(result).isEqualTo(member1);    //Assertions.assertThat(기대하는 값).isEqualTo(실제 값)
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);   //repository에 저장

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();   //repository에 저장된 모든 member를 반환
        assertThat(result.size()).isEqualTo(2);    //Assertions.assertThat(기대하는 값).isEqualTo(실제 값

    }
}
