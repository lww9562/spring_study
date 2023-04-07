package exam01;

public class ProxyCalculator implements Calculator{
	private Calculator calculator;

	public ProxyCalculator(Calculator calculator){
		this.calculator = calculator;
	}

	@Override
	public long factorial(long num) {
		long startTime = System.nanoTime();		//시작 시간 - 공통 기능
		long result = calculator.factorial(num);//핵심 기능 (대신 수행)
		long endTime = System.nanoTime();		//종료 시간 - 공통 기능
		System.out.printf("걸린 시간 : %d\n", endTime-startTime);
		return result;
	}
}
