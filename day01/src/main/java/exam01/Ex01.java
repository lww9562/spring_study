package exam01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		//클래스를 설정해줌
		//스프링 컨테이너 객체에 객체들을 담아줌

		Hello hello = ctx.getBean("hello", Hello.class);
		//컨테이너에서 특정 객체를 찾아서 반환
		//객체의 이름 = 메서드명
		hello.greet("이이름");

		Hello hello2 = ctx.getBean("hello", Hello.class);
		hello2.greet("김이름");

		System.out.println(hello == hello2);	//싱글톤 패턴으로 관리

		ctx.close();	// 객체 비우기
	}
}
