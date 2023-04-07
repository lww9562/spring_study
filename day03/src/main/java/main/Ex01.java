package main;

import config.AppCtx;
import exam02.Calculator;
import exam02.ImplCalculator;
import exam02.RecCalculator;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Ex01 {
	public static void main(String[] args){
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		/*
		RecCalculator cal = ctx.getBean(RecCalculator.class);
		long result = cal.factorial(10);
		System.out.printf("실행 결과 : %d\n", result);

		ImplCalculator cal2 = ctx.getBean(ImplCalculator.class);
		long result2 = cal.factorial(10);
		System.out.printf("실행 결과 : %d\n", result);
		*/
		Calculator cal = ctx.getBean(Calculator.class);
		long result = cal.factorial(10);
		System.out.printf("실행 결과 : %d\n", result);
		ctx.close();
	}
}
