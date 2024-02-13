package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// 스프링 빈을 끌어다가 사용하기 위함
@ComponentScan (
        basePackages = "hello.core.member", // 탐색할 위치를 지정한 이게 없으면 모든 자바코드를 다뒤진다
        basePackageClasses = AutoAppConfig.class, // 이 클래스가 있는 패키지 package hello.core; 에서부터 뒤진다
        // 권장하는 방법 : 패키지 위치를 설정하지 않고 설정 정보 클래스의 위치를 최 상단에 두는걸 추천
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // 제외할 컨테이너들
)
public class AutoAppConfig {

}
