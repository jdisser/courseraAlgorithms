import java.util.*;
import java.io.*;

public class Partition3 {
    private static boolean partition3(int[] A) {
        
    	int n = A.length;
    	int sum = 0;
    	
    	if(n < 3)
    		return false;
    	
    	
    	for(int i = 0; i < n; ++i) {
    		sum += A[i];
    	}
    	
    	if(sum % 3 != 0)
    		return false;
    	
    	boolean[][] T = new boolean[n][sum];	//default initialization to false
    	
    	// T [elemets in set A][partial sums]
    	
    	for (int el = 0; el < n; ++el)
    		T[el][0] = true;											//can always form an empty set
    	
    	T[0][A[0]] = true;												//with a single element only that value can be created
    	
    	for (int el = 1; el < n; ++el) {								//for each remaining element
    		for(int ps = 1; ps <= sum; ++ps) {							//for each partial sum
    			
    			T[el][ps] = T[el - 1][ps] || T[el - 1][ps - A[el]];		//this ps can be formed from the previous elements
    																	//or from a partial sum less this element's value     			
    		}
    	}
 
        return T[n-1][sum/3] && T[n-1][2*sum/3];						//if both partial sums can be formed then 3 equal sets
        																//exist since an element can't be summed twice
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

