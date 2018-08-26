import java.util.*;

public class DotProduct {
    private static long maxDotProduct(int[] a, int[] b) {
        
    	int n = a.length;
    	int maxA = Integer.MIN_VALUE;
    	int maxB = Integer.MIN_VALUE;
    	int tA = 0;
    	int tB = 0;
    	int pA = 0;
    	int pB = 0;
        long result = 0;
        
        if(n == 1)
        	return a[0] * b[0];
    	
    	for (int top = n - 1; top > 0; --top) {
    		for(int j = 0; j <= top; ++j) {
        		if(a[j] > maxA) {
        			maxA = a[j];
        			pA = j;
        		}
        		
        		if(b[j] > maxB) {		
        			maxB = b[j];
        			pB = j;
        		}
       		
        	}
    		if(pA != top) {
    			tA = a[top];
    			a[top] = a[pA];
    			a[pA] = tA;
    		}
    		
    		if(pB != top) {
    			tB = b[top];
    			b[top] = b[pB];
    			b[pB] = tB;
    		}
    		maxA = Integer.MIN_VALUE;
    		maxB = Integer.MIN_VALUE;
    	}
 
        for (int i = 0; i < n; i++) {
            result += a[i] * b[i];
        }
        return result;
    }

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        scanner.close();        
        
        //System.out.println("a0: " + Arrays.toString(a));
    	//System.out.println("b0: " + Arrays.toString(b));
        System.out.println(maxDotProduct(a, b));
    	//System.out.println("a: " + Arrays.toString(a));
    	//System.out.println("b: " + Arrays.toString(b));
        

    }
}

