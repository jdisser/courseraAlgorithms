import java.util.*;

public class FibonacciHuge {
	
	
    private static long getFibonacciHugeNaive(long n, long m) {
        if (n <= 1)
            return n;

        long previous = 0;
        long current  = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = tmp_previous + current;
            if (current >= m)
            	current %= m;
        }

        //return current % m;
        return current;
    }
    
    private static ArrayList<Integer> getFibonacciPattern(long n, long m) {
        
        
        int n2 = 0;
        int n1 = 0;
        int n0  = 1;


        
        ArrayList<Integer> pattern = new ArrayList<Integer>();
        
        pattern.add(n1, 0);
        
        if (n == 0)
        	return pattern;
        
        pattern.add(n0, 1);
        
        if(n == 1)
        	return pattern;

        

        for (int i = 2; i <= n; ++i) {
            n2 = n1;
            n1 = n0;
            n0 = n2 + n0;
            if (n0 >= m)
            	n0 %= m;
            pattern.add(i, n0);
            
            if(n0 == 1 && (n0 + n1) == m)	//this condition will lead to the 0-1-1 pattern which restarts the sequence
            	break;
            
            
        }

        return pattern;
    }
    
    public static long getFibonacciHuge(long n, long m) {
    	ArrayList<Integer> pattern = getFibonacciPattern(n,m);
    	int patternModulus = pattern.size();
    	
    	Integer f = null;
    	long index = 0;
    	
    	if(n < patternModulus) {
    		index = n;

    	} else {
    		index = n % patternModulus;
    	}
    	
    	f = pattern.get((int) index);
    	return (long) f.intValue();
    	
    	
    }
    
    public static void testFibonacci(long n, long m, int loops) {
       ArrayList<Integer> pattern = null;
        
        long nRnd = 0;
        long mRnd = 0;
        long fNative = 0;
        long fA = 0;
        
        for(int j = 0; j < loops; ++j) {
        	nRnd = Math.round(Math.random() * n);
        	mRnd = Math.round(Math.random() * m) + 2; // 2 <= modulus
        	
        	fNative = getFibonacciHugeNaive(nRnd, mRnd);
        	fA = getFibonacciHuge(nRnd, mRnd);
        	
        	if(fNative != fA) {
        		System.out.println("N: " + nRnd + " M: " + mRnd + " Native: " + fNative + " Algrthm: " + fA);        		
        		pattern = getFibonacciPattern(nRnd, mRnd);
        		System.out.println("Pattern Length: " + pattern.size());
        		System.out.println(pattern);
        		pattern.clear();
        		
        	}
        }
        
        System.out.println("Test Complete with loops: " + loops);
    }
    
    
    
    
    public static void main(String[] args) {
        
    	Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        
        /*
        long n = Long.parseLong(args[0]);
        long m = Long.parseLong(args[1]);
        int loops = Integer.parseInt(args[2]);
        
        testFibonacci(n,m,loops);
		*/
        
        
        
        
        //System.out.println(getFibonacciHugeNaive(n, m));
        System.out.println(getFibonacciHuge(n, m));
        
        
        
        scanner.close();
    }
}

