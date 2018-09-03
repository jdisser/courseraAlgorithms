import java.io.*;
import java.util.*;

public class BinarySearch {

	
	
    static int binarySearch(int[] a, int l, int r, int x) {

    	//System.out.println(" ");
    	//System.out.println("Entry l: " + l + " r: " +  r  + " x: " + x);
    	//System.out.println(Arrays.toString(a));
    	
        if(x < a[l])
        	return -1;
        
        if(x > a[r])
        	return -1;   
    	
        if(l >= r)
        	if (a[l] == x) 
        		return l;
        	else
        		return -1;					//if x is not found
        
    	int m;								//midpoint
        
        m = l + (r - l)/2;
        
        //System.out.println("m: " +  m);
        
        if(x == a[m])
        	return m;
        
        if(x < a[m])
        	return binarySearch(a, l, m, x);
        else
        	return binarySearch(a, m+1, r, x);        
         
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
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
        for (int i = 0; i < m; i++) {
            //grading version
        	
            int left = 0, right = a.length - 1;

        	System.out.print(binarySearch(a, left, right, b[i]) + " ");
        	
        	//test version
        	//System.out.print("bs: " + binarySearch(a, left, right, b[i]) + " ");
        	//System.out.print("ls: " + linearSearch(a, b[i]) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
