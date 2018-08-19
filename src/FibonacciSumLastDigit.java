import java.util.*;

public class FibonacciSumLastDigit {
    private static long getFibonacciSumNaive(long n) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            sum += current;
        }

        return sum % 10;
    }
    
    private static long[] getFibonacciSum(long n) {
        
    	long[] fsr = new long[3];
    	
    	if (n == 0) {
    		fsr[0] = 0;	//the f number
    		fsr[1] = 0;	//the sum
    		fsr[2] = 0;	//the sum % 10
    		return fsr;
    	}
        
    	if (n == 1) {
    		fsr[0] = 1;
    		fsr[1] = 1;
    		fsr[2] = 1;
    		return fsr;
    	}
        
        long fn2 = 0;
        long fn1 = 0;
        long fn0 = 1;
        long sum = 1;

        for (long i = 2; i <= n; ++i) {
            fn2 = fn1;
            fn1 = fn0;
            fn0 = fn2 + fn1;
            fsr[0] = fn0;
            fsr[1] += fn0; 
            fsr[2] = fsr[1] % 10;
            
        }

        return fsr;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        
        long n2 = 0;
        long n1 = 0;
        long n0 = 0;
        long d = 0;
        long[] fsr = new long[3];
        
        
        for(long i = 0; i <= n; ++i) {
            //long sn = getFibonacciSumNaive(i);
            fsr = getFibonacciSum(i);
            
            n2 = n1;
            n1 = n0;
            n0 = fsr[2];
            
            d = -(n0 - ((n1 + n2 + 2) % 10));
            
            System.out.println(i + " " + fsr[0] + " " + fsr[1] + " " + fsr[2] + " " + d);
            
        }

        //System.out.println(s);
        scanner.close();
    }
}

