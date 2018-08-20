import java.util.*;



public class FibonacciPartialSum {
	
	public static long[] getFSumSeries() {
		
		long[] fSumSeries = new long[60];
		
		fSumSeries[0] = 0;
		fSumSeries[1] = 1;
		
		for(int i = 2; i < 60; ++i) {
			fSumSeries[i] = (fSumSeries[i -1] + fSumSeries[i - 2] + 1) % 10;
		}

		return fSumSeries;    	
	}
	
	public static long getSumLastDigit(long n) {

        
        long[] fSumSeries = getFSumSeries();
        
        int index = 0;
        
        if(n < fSumSeries.length) {
        	index = (int) n;
        } else {
        	index = (int) (n % fSumSeries.length);
        }
        
        return fSumSeries[index];
	}
	
	public static long getFibonacciPartialSum(long from, long to) {
		
		if (from == 0)
			return getSumLastDigit(to);
		
		long sfrom1 = getSumLastDigit(from-1);
		
		long sto = getSumLastDigit(to);
		
		if (sfrom1 > sto) {
			return (10 - sfrom1) + sto;
		}
		
		return sto - sfrom1;
		
	}
	
    private static long getFibonacciPartialSumNaive(long from, long to) {
        long sum = 0;

        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }

            long new_current = next;
            next = next + current;
            current = new_current;
        }

        return sum % 10;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        //System.out.println(getFibonacciPartialSumNaive(from, to));
        System.out.println(getFibonacciPartialSum(from, to));
        scanner.close();
        
    }
}

