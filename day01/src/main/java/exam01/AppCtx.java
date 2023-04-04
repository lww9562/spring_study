package exam01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Spring의 역할 - 객체 관리 - 스프링 컨테이너
public class AppCtx {
	@Bean	//관리할 객체임을 알려줌
	public Hello hello(){
		Hello hello = new Hello();
		return hello;
	}
}
