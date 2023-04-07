package config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Order(2)
@Aspect
public class ProxyCalculator2 {
	/*
	@Pointcut("execution(* exam02..*(..))") //공통기능을 적용할 범위 설정
	public void publicTarget(){	}
*/
	@Around("config.CommonPointCut.publicTarget()")	//공통 기능
	public Object process(ProceedingJoinPoint joinPoint) throws Throwable{
		long startTime = System.nanoTime();
		
		Object result = joinPoint.proceed(); //factorial(핵심 기능)

		long endTime = System.nanoTime();
		System.out.printf("걸린 시간 : %d\n", endTime - startTime);
		return result;
	}
}
