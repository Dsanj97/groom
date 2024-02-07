package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac  = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        // 검증
        // 임플의 인스턴스로 등록이 되어있는가?
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        // 인터페이스로 조회
        // 인터페이스의 구현체가 대상이됨
        MemberService memberService = ac.getBean(MemberService.class);
        // 검증
        // 임플의 인스턴스로 등록이 되어있는가?
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        // 스프링 컨테이너에 등록이 되어있는경우 조회 가능
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        // 검증
        // 임플의 인스턴스로 등록이 되어있는가?
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("빈 이름으로 조회 x")
    void findBeanByNameX() {
        // 이 예외가 터져야 테스트 성공
        // 오른쪽의 로직을 실행하면
        // 왼쪽의 예외가 터져야 한다
        assertThrows(NoSuchBeanDefinitionException.class, () ->
                ac.getBean("xxxxx", MemberService.class));
    }
}
