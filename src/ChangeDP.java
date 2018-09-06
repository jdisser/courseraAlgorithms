import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        
    	int[] coins = {1,3,4};
    	
    	int[] minCoins = new int[1010];
    	
    	if(m == 0)
    		return 0;
    	else
    		minCoins[0] = 0;
   
    	int test = 0;
    	
    	for(int mon = 1; mon<=m; ++mon) {
    		
    		int min = Integer.MAX_VALUE;

    		for(int c = 0; c < 3; ++c) {

    			if(coins[c] <= mon) {
       				test = (minCoins[mon - coins[c]] + 1);
    				if( test < min)
    					min = test;  					
    			}
    		}
    		minCoins[mon] = min;
    	}
 
    	return minCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

