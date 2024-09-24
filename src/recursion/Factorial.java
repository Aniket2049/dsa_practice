package recursion;

public class Factorial {

	public long factorial(long n) {
		if (n <=1)
			return 1;
		else 
			return n * factorial (n-1);
	}
	
	public static void main(String[] args) {
		Factorial classObj = new Factorial();
		
		System.out.println(classObj.factorial(5));

	}

}
