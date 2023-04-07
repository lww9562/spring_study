package exam01;

public class ImplCalculator implements Calculator{
	@Override
	public long factorial(long num) {
		int total = 1;
		for(int i = 1; i <= num; i++){
			total *= i;
		}
		return total;
	}
}
