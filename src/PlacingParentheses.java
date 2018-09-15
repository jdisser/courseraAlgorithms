import java.util.Arrays;
import java.util.Scanner;
import java.lang.Character;

public class PlacingParentheses {
   	
	public static int[] digits;
	public static char[] ops;
	
	public static void parse(String exp) {
		int len = exp.length();
		
		digits[0] = 0;			//algorithm is 1 based not 0
		ops[0] = '.';
		
		char[] inChars = exp.toCharArray();
		
		//digits[1] = Character.getNumericValue(inChars[0]);
		
		for(int i = 0; i < len; ++i) {
			
			if(i % 2 == 0 || i == 0) {
				digits[i/2 + 1] = Character.getNumericValue(inChars[i]);
			} else {
				ops[i/2 + 1] = inChars[i + 1];
			}		
		}
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
    }
}

