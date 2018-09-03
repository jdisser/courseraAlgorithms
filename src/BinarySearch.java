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
		
		public int mid() {						//this function has to compliment the splitting functions
			
			if (this.length() < 3)
				return left;					//check if mid == left for segments length 1,2
			int half = this.length() / 2;
			if (this.length() % 2 != 0)
				return left + half;				//[0,1,2] 1 is mid  [0,1,2,3,4] 2 is mid		
			else
				return left + half - 1;			//[0,1] 0 = mid [0,1,2,3] 1 = mid	[0,1,2,3,4,5] 2 = mid	
						
		}
		
		public Segment top() {
			int middle = this.mid();
			return new Segment(middle + 1, this.right);		//upper half without middle
		}
		
		public Segment bottom() {
			int middle = this.mid();
			return new Segment(this.left, middle);		//lower half with middle
		}
	}
	
	
    static int binarySearch(int[] a, int x) {
        int left = 0, right = a.length - 1;

        if(x < a[left])
        	return -1;
        
        if(x > a[right])
        	return -1;   
        
        Segment sA = new Segment(left, right);


        //the looping overhead is causing this to run overtime and needs to be replaced with recursion
        
        while (sA.left != sA.right) {		//not sure if this will terminate
        	/*
        	if (x == a[sA.left])
        		return sA.left;
        	if (x == a[sA.right])
        		return sA.right;
        	*/
        	
        	if (x > a[sA.mid()])	//The middle element is returned in the bottom segment
        		sA = sA.top();
        	else
        		sA = sA.bottom();
        	
        	
        }
        if(x == a[sA.left])
        	return sA.left;
        else
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
            //grading version
        	System.out.print(binarySearch(a, b[i]) + " ");
        	//test version
        	//System.out.print("bs: " + binarySearch(a, b[i]) + " ");
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
