import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib_naive(int n) {
    if (n <= 1)
      return n;

    return calc_fib_naive(n - 1) + calc_fib_naive(n - 2);
  }
  
  private static long calc_fib(int n) {
	  long[] fibs = new long[n <= 1 ? 2 : n + 1];
	  fibs[0] = 0;
	  fibs[1] = 1;
	  
	  if(n <= 1 )
		  return n;

	  for(int i = 2; i <= n; ++i) {
		  fibs[i] = fibs[i - 1] + fibs[i - 2];
	  }
  
	  return fibs[n];
  }

  private static void testFib(int n) {
	  long fibNaive;
	  long fib;
	  long tStart;
	  long t;
	  long tn;
	  
	  for(int i = 0; i <= n; ++i) {
		  tStart = System.nanoTime();
		  fibNaive = calc_fib_naive(i);
		  tn = System.nanoTime() - tStart;
		  tn /= 1000; //convert to us
		  
		  tStart = System.nanoTime();
		  fib = calc_fib(i);
		  t = System.nanoTime() - tStart;
		  t /= 1000;
		  
		  System.out.println("Naive Algorithm: " + fibNaive + " tn: " + tn + "    Array Algorithm: " + fib + " t: " + t);
	  }
	  
  }
  
  
  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    //testFib(n);
   
    //System.out.println("Naive Algorithm: " + calc_fib_naive(n));
    System.out.println(calc_fib(n));
    in.close();
   
  }
}
