import java.util.Scanner;

public class Change {
    private static int getChange(int m) {
        int n1 = 0;
        int n5 = 0;
        int n10 = 0;
        
        while(m > 0) {
        	if (m >= 10) {
        		m -= 10;
        		++n10;
        		continue;
        	}
        	
        	if (m >= 5) {
        		m -= 5;
        		++n5;
        		continue;
        	}
        	if (m >= 1) {
        		m -= 1;
        		++n1;
        	}
        }
    	
    	
    	
    	
        return n1 + n5 + n10;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

