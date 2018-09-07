import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //this code is string/char based and needs to be refactored for arrays
    	int n = a.length;
        int m = b.length;
        
        int[][] D = new int[n + 1][m + 1];	// The distance matrix has an additional 0 index row and column 
        
        
    	for(int i = 0; i <= n; ++i)			//Initialize the 0 index row and column to the index
    		D[i][0] = i;
    	for(int j = 0; j <= m; ++j)
    		D[0][j] = j;
        
        int ins = 0;
        int del = 0;
        int mis = 0;
        int mtc	= 0;
        int minCost = 0;
    	
    	for(int j = 1; j <= m; ++j) {				//build the cost matrix
    	   
    	   ins = 0;
    	   del = 0;
    	   mis = 0;
    	   mtc = 0;
    	   
    	   for(int i = 1; i <= n; ++i) {
    		  ins = D[i][j - 1] + 1;					//compute the cost for all possibilities
    		  del = D[i - 1][j] + 1;
    		  mis = D[i - 1][j - 1] + 1;
    		  mtc = D[i - 1][j -1];
    		  
    		  if(a[i - 1] == b[j - 1] ) {		//if the characters match use the match cost
    			  minCost = Math.min(ins, del);
    			  minCost = Math.min(minCost, mtc);
    		  } else  {
    			  minCost = Math.min(ins, del);				//otherwise use the mismatch cost
    			  minCost = Math.min(minCost, mis);
    		  }
    		  
    		  D[i][j] = minCost;							//set the Cost matrix to the minimum
    		   
    	   }	   
       }
    	
    	
    	
        //D matrix needs to be traversed back to the 0,0 point while counting the number of matches found along the minimum path
       int ics = 0;
       int i = n;		//start at the end of each array
       int j = m;
       int ni = i;
       int nj = j;
       int mi = 0;
       int mj = 0;
      
       /*
       if(i == 1 && j == 1) {				//test the 1,1 case for a 1 x 1 matrix
    	   if(a[i-1] == b[j-1])				//the a & b indexes are 1 less than the D indexes due to the 0 row
    		   ++ics;
       }
		*/

       while(i > 0 && j > 0) {				//loop until back at 1,1
    	   
    	   int min = Integer.MAX_VALUE;		//reset the min
    	   
    	   ni = i;							//set the next indexes to the current
    	   nj = j;
    	   
    	   if(a[i-1] == b[j-1]) {					//check for a match and increment the length of the common segment
    		   ++ics;
    		   System.out.println("i: " + i + " j: " + j);
    	   }
    	   
    	   /*
    	    * in the case of 5,2,8,7 and 2,7,8,3
    	    * this is missing the 2,1 match
    	    * there is a point in the cost matrix where
    	    * two costs are the same but one is a match
    	    * The procedure needs to check for matches and
    	    * give priority to them for the next indexes
    	    * 
    	    */
    	   
    	   mi = 0;
    	   mj = 0;
    	   
    	   if(D[i][j - 1] < min) {			//look for the minimum cost move in the matrix
    		   ni = i;
    		   nj = j - 1;
    		   min = D[i][j - 1];

    	   }
    	   
    	   if(D[i - 1][j - 1] < min) {
    		   ni = i - 1;
    		   nj = j - 1;
    		   min = D[i - 1][j - 1];
    	   }
    	   
    	   if(D[i - 1][j] < min) {
    		   ni = i - 1;
    		   nj = j;
    		   min = D[i - 1][j];
    	   }
    	   									//!!!!!!NOT SURE IF THERE COULD BE > 1 MINIMUM MATCHES HERE!!!!!
    	   if(D[i][j - 1] == min) {			//look for matches at the minimum cost positions
    		   if(a[i-1] == b[j - 2]) {		//look for a match in the adjacent elements and go to that
    			   mi = i;
    			   mj = j - 1;
    		   }
    	   }
    	   
    	   if(D[i - 1][j - 1] == min) {
    		   if(a[i - 2] == b[j - 2]) {		
    			   mi = i - 1;
    			   mj = j - 1;
    		   }
    	   }
    	   
    	   if(D[i - 1][j] == min) {
    		   if(a[i - 2] == b[j - 1]) {		
    			   mi = i - 1;
    			   mj = j;
    		   }
    	   }
    	   
    	   
    	   if(mi != 0 || mj != 0) {
    		   i = mi;							//move to the match if it exists
    		   j = mj;
    	   } else {
    		   i = ni;							// otherwise move to the minimum
    		   j = nj;
    	   }
    	   
    	   
    	   
    	   

    	   
       }
       
       return ics;								//return the number of matches in the minimum path
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
        scanner.close();
    }
}

