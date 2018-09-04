import java.io.*;
import java.util.*;

public class BinarySearch {

	static int aa[];
	/*
	 * 
	 //recursive solution
    static int binarySearch(int l, int r, int x) {

    	//System.out.println(" ");
    	//System.out.println("Entry l: " + l + " r: " +  r  + " x: " + x);
    	//System.out.println(Arrays.toString(a));
    	    	
    	if(l >= r)
        	return l;
    	
    	int m;								//midpoint
        
        m = l + (r - l)/2;
        
        //System.out.println("m: " +  m);
        
        if(x == aa[m])
        	return m;
        
        if(x < aa[m])
        	return binarySearch(l, m - 1, x);
        else
        	return binarySearch(m+1, r, x);        
         
    }
	*/
	
	//iterative solution
	static int binarySearch(int l, int r, int x) {

    	//System.out.println(" ");
    	//System.out.println("Entry l: " + l + " r: " +  r  + " x: " + x);
    	//System.out.println(Arrays.toString(a));
    	    	
    	
    	
    	int m;								//midpoint
    	
    	while (l < r) {
        
	        m = l + (r - l)/2;
	        
	        //System.out.println("m: " +  m);
	        
	        /*
	        if(x == aa[m])
	        	return m;
	        */
	        if(x <= aa[m]) {
	        	r = m;
	        } 	
	        else {
	        	l = m + 1;
	        }
 
    	}
    	
        return l;
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
        aa = new int[n];
        for (int i = 0; i < n; i++) {
            aa[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
          b[i] = scanner.nextInt();
        }
        
        int left = 0, right = aa.length - 1;
        int pa;
        
        for (int i = 0; i < m; i++) {
            //grading version
        	

            pa = binarySearch(left, right, b[i]);

            if(b[i] == aa[pa])
            	System.out.print(pa + " ");
            else
            	System.out.print("-1 ");
        	
        	//test version
        	//System.out.print("bs: " + binarySearch(left, right, b[i]) + " ");
        	//System.out.print("ls: " + linearSearch(aa, b[i]) + " ");
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
