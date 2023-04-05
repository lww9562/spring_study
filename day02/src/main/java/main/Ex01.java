package main;

import config.AppCtx;
import config.AppCtx2;
import models.member.JoinService;
import models.member.ListService;
import models.member.Member;
import models.member.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		//애너테이션으로 설정되는 스프링 컨테이너

		JoinService joinService = ctx.getBean(JoinService.class);
		ListService listService = ctx.getBean(ListService.class);

		Member member = new Member();
		member.setUserId("user01");
		member.setUserPw("123456");
		member.setUserNm("사용자01");

		joinService.join(member);

		listService.print();

		ctx.close(); //Bean 객체의 소멸
	}
}