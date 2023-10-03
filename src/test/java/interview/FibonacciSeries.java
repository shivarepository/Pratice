package interview;

public class FibonacciSeries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int fib1=0, fib2=1,fib3;
		int num=10;
		System.out.println(fib1);
		for(int i=2;i<=num;i++)
		{
			fib3 = fib1 + fib2;
			System.out.println(fib3);
			fib1 = fib2;
			fib2 = fib3;
		}
	}
}