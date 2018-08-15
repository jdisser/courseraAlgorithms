import java.util.*;

public class GCD {
  private static int gcd_naive(int a, int b) {
    int current_gcd = 1;
    for(int d = 2; d <= a && d <= b; ++d) {
      if (a % d == 0 && b % d == 0) {
        if (d > current_gcd) {
          current_gcd = d;
        }
      }
    }

    return current_gcd;
  }

  public static int gcd_euler(int a, int b) {

	  int abscissa;
	  int divisor;
	  int remainder;
	  
	  if (b > a) {
		  if (b % a == 0)
			  return a;
		  else {
			  abscissa = b;
			  divisor = a;
			  remainder = b % a;
		  }
	  } else {
		  if (a % b == 0)
			  return b;
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
	  }
	  
	  return divisor;

  }
  
  
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(gcd_euler(a, b));
    
    /*
    System.out.println("naive: "+gcd_naive(a, b));
    System.out.println("euler: "+gcd_euler(a, b));
    */
    scanner.close();
  }
}
