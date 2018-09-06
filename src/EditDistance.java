import java.util.*;

class EditDistance {
  
	
	public static int editDistance(String a, String b) {
    int n = a.length();
    int m = b.length();
    
    int[][] D = new int[n + 1][m + 1];	// The distance matrix has an additional 0 index row and column 
    
    
	for(int i = 0; i <= n; ++i)			//Initialize the 0 index row and column to the index
		D[i][0] = i;
	for(int j = 0; j <= m; ++j)
		D[j][0] = j;
    
    int ins = 0;
    int del = 0;
    int mis = 0;
    int mtc	= 0;
    int minCost = 0;
	
	for(int j = 1; j <= m; ++j) {
	   
	   ins = 0;
	   del = 0;
	   mis = 0;
	   mtc = 0;
	   
	   for(int i = 1; i <= m; ++i) {
		  ins = D[i][j - 1] + 1;					//compute the cost for all possibilities
		  del = D[i - 1][j] + 1;
		  mis = D[i - 1][j - 1] + 1;
		  mtc = D[i - 1][j -1];
		  
		  if(a.charAt(i - 1) == b.charAt(j - 1) ) {		//if the characters match use the match cost
			  minCost = Math.min(ins, del);
			  minCost = Math.min(minCost, mtc);
		  } else  {
			  minCost = Math.min(ins, del);				//otherwise use the mismatch cost
			  minCost = Math.min(minCost, mis);
		  }
		  
		  D[i][j] = minCost;							//set the Cost matrix to the minimum
		   
	   }	   
   }    
    return D[n][m];
  }
	

  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(editDistance(s, t));
    scan.close();
  }
  
}
