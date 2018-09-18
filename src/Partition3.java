import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        
    	int n = A.length;
    	int sum = 0;
    	
    	if(n < 3)
    		return 0;
    	
    	
    	for(int i = 0; i < n; ++i) {
    		sum += A[i];
    	}
    	
    	if(sum % 3 != 0)
    		return 0;
    	
    	boolean[][] T = new boolean[n][sum + 1];	//default initialization to false
    	
    	// T [elemets in set A][partial sums]
    	
    	for (int el = 0; el < n; ++el)
    		T[el][0] = true;											//can always form an empty set
    	
    	T[0][A[0]] = true;												//with a single element only that value can be created
    	
    	//System.out.println("");
    	
    	for (int el = 1; el < n; ++el) {								//for each remaining element
    		for(int ps = 1; ps <= sum; ++ps) {							//for each partial sum
    			//System.out.println("el: " + el + " ps: " + ps);
    			
    			if(A[el] <= ps)
    				T[el][ps] = T[el - 1][ps] || T[el - 1][ps - A[el]];		//this ps can be formed from the previous elements
    			else														//or from a partial sum less this element's value
    				T[el][ps] = T[el - 1][ps];								//unless the value of the element is > than ps
    																	     			
    		}
    	}
 
    	if(T[n-1][sum/3] && T[n-1][2*sum/3])						//if both partial sums can be formed then 3 equal sets
    		return 1;						
    	else														//exist since an element can't be summed twice
    		return 0;
        															//and the remaining set is equal since the sum % 3 = 0
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
        scanner.close();
    }
}

