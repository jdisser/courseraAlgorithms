import java.util.*;

public class LCM {
	
  private static long lcm_naive(int a, int b) {
    for (long l = 1; l <= (long) a * b; ++l)
      if (l % a == 0 && l % b == 0)
        return l;

    return (long) a * b;
  }
  
  public static int gcd_euler(int a, int b) {

	  int gcd = 1;
	  int abscissa;
	  int divisor = 1;
	  int remainder;
	  
	  if (b > a) {
		  if (b % a == 0) {
			  gcd = a;
			  remainder = 0;
		  }

		  else {
			  abscissa = b;
			  divisor = a;
			  remainder = b % a;
		  }
	  } else {
		  if (a % b == 0) {
			  gcd = b;
			  remainder = 0;
		  }

		  else {
			  abscissa = a;
			  divisor = b;
			  remainder = a % b;
		  }
	  }
	  
	  while (remainder != 0) {
		  abscissa = divisor;
		  divisor = remainder;
		  remainder = abscissa % divisor;
		  gcd = divisor;
	  }
	  
	  return gcd;

  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();
    
    int gcd = gcd_euler(a,b);
    int lcm = b/gcd * a;
    
    //System.out.println("a: " + a + " b: "+b+" GCD: "+ gcd);
    //System.out.println(lcm_naive(a, b));
    System.out.println(lcm);
    
  }
}
