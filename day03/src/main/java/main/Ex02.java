package main;

import config.AppCtx;
import exam02.Calculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex02 {
	public static void main(String[] args){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);

		Calculator cal = ctx.getBean(Calculator.class);
		long result = cal.factorial(10);
		System.out.printf("실행 결과 : %d\n", result);

		result = cal.factorial(10);
		System.out.printf("실행 결과 : %d\n", result);

		result = cal.factorial(10);
		System.out.printf("실행 결과 : %d\n", result);

		result = cal.factorial(10);
		System.out.printf("실행 결과 : %d\n", result);

		ctx.close();
	}
}
