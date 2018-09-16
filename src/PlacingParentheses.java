import java.util.Arrays;
import java.util.Scanner;
import java.lang.Character;

public class PlacingParentheses {
   	
	public static int[] digits = new int[15];		//the digits in the expression
	public static char[] ops = new char[15];		//the operators in the expression
	
	public static long[][] mx = new long[15][15];	//The maximum array of sub problems
	public static long[][] mn = new long[15][15];	//the minimum array of sub problems
	
	/*
	 * These arrays represent sub expressions in the input expression ie.
	 * d1 o1 d2 o2 (di oi d o d o d oj-1 dj) ... on-1 dn
	 * 
	 * i 			j
	 *   1 2 3 4 . . n
	 * 1
	 * 2   mx(subexpression from di to dj)
	 * 3
	 * 
	 * The elements m?[i][j] where i = j are just the digit di and are initialized not calculated
	 * the elements where j = i+1 are adjacent digits ie. di + dj and do not have max or mins with a single op
	 * the rest build up from these smaller elements as j - i or the length of the subexpression increases
	 * 
	 */
	
	public static long min;			//The minimum and maximum results after evaluation of all the ops in the sub problem
	public static long max;
	
	public static int n;			//the number of digits in the expression
	
	public static void parse(String exp) {
		int len = exp.length();
		
											//!!!!!!! algorithm is 1 based not 0 !!!!!!!
		Arrays.fill(digits, -1);			//use -1 to detect empty digits		
		ops[0] = '.';
		
		char[] inChars = exp.toCharArray();
		
		
		for(int i = 0; i < len; ++i) {
			
			if(i % 2 == 0 || i == 0) {
				digits[i/2 + 1] = Character.getNumericValue(inChars[i]);
			} else {
				ops[i/2 + 1] = inChars[i];
			}		
		}
		
//        System.out.println("ops: "+Arrays.toString(ops));
//        System.out.println("digits: "+Arrays.toString(digits));

	}
	
	public static void getN() {				//the arrays are larger than the expressions so look for digits
		int nn = 0;
		int len = digits.length;
		for (int i = 1; i < len; ++i) {
			if(digits[i] != -1)
				++nn;
		}
		n = nn;
//        System.out.println("Length: "+ n);
	}
	
	public static void initializeMnMx() {	//set the i = j elements to the value of di
		for(int i = 1; i <= n; ++i) {
			mn[i][i] = (long) digits[i];
			mx[i][i] = (long) digits[i];
		}
	}
	
	/*
	 * Find the minimum and maximum of the subexpressions by evaluating the operators in order
	 * from left to right and looking up the smaller subexpressions from the maximum and minimum arrays
	 */
	private static void setMinMax(int i, int j) {
		min = Long.MAX_VALUE;
		max = Long.MIN_VALUE;
		
		long[] results = new long[4];		//[0] = mx op mx | [1] = mx op mn | [2] = mn op mx | [3] = mn op mn 

		
		for(int k = i; k < j; ++k) {							//for each op
			results[0] = eval(mx[i][k], mx[k + 1][j], ops[k]);	//evaluate the 4 permutations of the 
			results[1] = eval(mx[i][k], mn[k + 1][j], ops[k]);	//mn & mx sub problems
			results[2] = eval(mn[i][k], mx[k + 1][j], ops[k]);
			results[3] = eval(mn[i][k], mn[k + 1][j], ops[k]);
			
			for(int ii = 0; ii < 4; ++ii) {						//and update the max and min result
				if(results[ii] < min)							//after each op
					min = results[ii];
				if(results[ii] > max)
					max = results[ii];
			}
		}		
	}
	
	
	private static long getMaximValue(String exp) {
	      
		parse(exp);				//Store the digits and ops
		getN();					//get the length of the expression
		initializeMnMx();		//initialize the maximum and minimum arrays
	
		for (int a = 1; a < n; ++a) {					// 1 5 8 10  Fill the arrays in this order
			for (int i = 1; i <= n - a; ++i) {			// 0 2 6 9	note: 1,2,3,4 are initialized to d[1], d[2] etc
				int j = i + a;							// 0 0 3 7
				setMinMax(i,j);							// 0 0 0 4
				mx[i][j] = max;
				mn[i][j] = min;
			}
		}
		
//		System.out.println("Max:");
//		printArray(mx, n);
//		System.out.println("");
//		System.out.println("Min:");
//		printArray(mn, n);
//		System.out.println("");
		
		return mx[1][n];	//This represents the maximum value of the whole expression from i = 1 to j = n
		
		
	}	
    	
    
	private static void printArray(long[][] a, int nn) {
		for(int i = 1; i <= nn; ++i) {
			System.out.println("");
			for(int j = 1; j <= nn; ++j) {
				System.out.print(" " + a[i][j]);
			}
		}
	}
 
    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
       
//        System.out.println("Max(1,n): "+getMaximValue(exp));
        System.out.println(getMaximValue(exp));
        
        scanner.close();
    }
}

