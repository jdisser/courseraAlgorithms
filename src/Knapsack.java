import java.util.*;

public class Knapsack {
	

	
    static long optimalWeight(int W, int[] w) {
        
    	int n = w.length;
    	long[][] val = new long [W + 1][n + 1];			//default initialized to 0
    	long tmp = 0;
    	
    	for (int i = 1; i <= n; ++i) {				//i is the item number (offset this -1 for array of items)
    		for( int j = 1; j <= W; ++j) {			//j is the weight for the subproblem
    			
    			val[j][i] = val[j][i - 1];			//The value without the item added
    			if(w[i - 1] <= j) {
    				tmp = val[j - w[i - 1]][i - 1] + w[i - 1];	
    				if(tmp > val[j][i])
    					val[j][i] = tmp;			//if the val (total weight of items) is larger with the item add it
    			}
    		}
    	}

        return val[W][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

