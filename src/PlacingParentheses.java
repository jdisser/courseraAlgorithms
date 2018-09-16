import java.util.Arrays;
import java.util.Scanner;
import java.lang.Character;

public class PlacingParentheses {
   	
	public static int[] digits = new int[15];
	public static char[] ops = new char[15];
	
	public static long[][] mx = new long[15][15];
	public static long[][] mn = new long[15][15];
	
	public static int n;
	
	public static void parse(String exp) {
		int len = exp.length();
		
		//algorithm is 1 based not 0
		Arrays.fill(digits, -1);			//use -1 to detect empty digits		
		ops[0] = '.';
		
		char[] inChars = exp.toCharArray();
		
		//digits[1] = Character.getNumericValue(inChars[0]);
		
		for(int i = 0; i < len; ++i) {
			
			if(i % 2 == 0 || i == 0) {
				digits[i/2 + 1] = Character.getNumericValue(inChars[i]);
			} else {
				ops[i/2 + 1] = inChars[i];
			}		
		}
	}
	
	public static void getN() {
		int nn = 0;
		int len = digits.length;
		for (int i = 1; i < len; ++i) {
			if(digits[i] != -1)
				++nn;
		}
		n = nn;
	}
	
	private static long getMaximValue(String exp) {
	      //write your code here
	      return 0;
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
        //System.out.println(getMaximValue(exp));
        parse(exp);
        System.out.println("ops: "+Arrays.toString(ops));
        System.out.println("digits: "+Arrays.toString(digits));
        getN();
        System.out.println("Length: "+ n);
    }
}

