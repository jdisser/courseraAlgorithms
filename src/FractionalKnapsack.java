
import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        
        int n = values.length;
        

        double[] worth = new double[n] ;			
        Arrays.fill(worth, 0);
        int maxWorthPtr = 0;
        double totalValue = 0;
        
        if (capacity == 0)
        	return 0;					//in this case the bag can't carry anything!!!
        
        for (int i = 0 ; i < n; ++i) {	
        	if(weights[i] != 0)
        		worth[i] = (double)values[i]/(double)weights[i];
        	else
        		worth[i] = 0;					//nothing is worthless!!!
        	if(worth[i] > worth[maxWorthPtr])
        		maxWorthPtr = i;
        }
        
        if(worth[maxWorthPtr] == 0)
        	return 0;					//in this case everything is worthless!!!

        while(capacity > 0) {
        	for(int j = 0 ; j < n; ++j) {
            	if(worth[j] > worth[maxWorthPtr])
            		maxWorthPtr = j;
        	}
        	
        	if(capacity >= weights[maxWorthPtr]) {
        		capacity -= weights[maxWorthPtr];
        		totalValue += worth[maxWorthPtr]*weights[maxWorthPtr];
        		worth[maxWorthPtr] = 0;							//this effectively removes the item from the search
        	} else {
        		totalValue += worth[maxWorthPtr]*capacity;
        		capacity = 0;
        	}
        	
        }
        
        
        return totalValue;
    }

    public static void main(String args[]) {
    	
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        
        System.out.format("%.4f %n", getOptimalValue(capacity, values, weights));
        scanner.close();
        
    	/*
    	int capacity = 1000;
    	int[] values = {500};
    	int[] weights = {30};
    	
    	System.out.println("Capacity: " + capacity);
    	System.out.println("Values: " + Arrays.toString(values));
    	System.out.println("Weights: " + Arrays.toString(weights));
        System.out.format("Optimal Value: %.4f %n", getOptimalValue(capacity, values, weights));
        */
    }
} 
