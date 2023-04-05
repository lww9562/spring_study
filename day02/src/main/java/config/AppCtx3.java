package config;

import models.member.MemberDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import java.time.format.DateTimeFormatter;

@Configuration
/*
@ComponentScan(basePackages = "models.member",
		excludeFilters = @ComponentScan.Filter(type= FilterType.ANNOTATION, classes={ManualBean.class}))

 */
/*
@ComponentScan(basePackages = "models.member",
		excludeFilters = @ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, classes = {MemberDao.class}))
 */
/*
@ComponentScan(basePackages = "models.member",
		excludeFilters={
			@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE, classes = {MemberDao.class}),
				@ComponentScan.Filter(type=FilterType.ASPECTJ, pattern="models.member.**Service")
		})
*/
@ComponentScan("models.member")

public class AppCtx3 {
	//외부에서 받은 라이브러리, JDK 등은 Bean 애너테이션을 적어주어야 한다.
	@Bean
	public DateTimeFormatter dateTimeFormatter(){
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy.MM.dd HH:mm");

		return formatter;
	}
}
