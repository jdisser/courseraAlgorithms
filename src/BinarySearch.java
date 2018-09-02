import java.io.*;
import java.util.*;

public class BinarySearch {

	static class Segment {
		public int left;
		public int right;
		
		public Segment(int l, int r) {
			this.left = l;
			this.right = r;
		}
		
		public int length() {
			return right - left + 1;
		}
		
		public int mid() {
			
			int len = right - left + 1;
			
			if (len < 3)
				return left;
			int half = len / 2;
			return left + half;
						
		}
		
		public Segment top() {
			int middle = this.mid();
			return new Segment(middle, this.right);
		}
		
		public Segment bottom() {
			int middle = this.mid();
			return new Segment(this.left, middle);
		}
	}
	
	
    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length;

        if(x < a[left])
        	return -1;
        
        if(x > a[right])
        	return -1;   
        
        Segment sA = new Segment(left, right);
        int lengthS = sA.length();

        while (lengthS > 2) {		//not sure if this will terminate
        	if (x == a[sA.left])
        		return sA.left;
        	if (x == a[sA.right])
        		return sA.right;
        	
        	if (x >= a[sA.mid()])	//if equal to the mid put in top ???
        		sA = sA.top();
        	else
        		sA = sA.bottom();
        	
        	lengthS = sA.length();
        	
        	//add code here to terminate the loop if the segment length is 2
        	
        }
        

        return -1;
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
            //replace with the call to binarySearch when implemented
            System.out.print(linearSearch(a, b[i]) + " ");
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
