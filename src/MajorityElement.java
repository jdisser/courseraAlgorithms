import java.util.*;
import java.io.*;

public class MajorityElement {
	
	static int[] aa;
	static int majority = (aa.length / 2) + 1; 
	
	static class Partition {
		public int left;
		public int right;
		public int m1;
		public int m2;
		public int pivot;
		public int t;
		public int n;
		
		
		public Partition(int l, int r) {
			this.left = l;
			this.right = r;
			this.n = r - l + 1;
		}
		
		public int lengthMid() {
			return m2 - m1 + 1;
		}
		
		public int lengthRight() {
			return right - m2 + 1;
		}
		public int lengthLeft() {
			return m1 - left + 1;
		}
		
		public void swapValues(int to, int from) {
			t = aa[to];
			aa[to] = aa[from];
			aa[from] = t;
			return;
		}
		
		public void setPivotToMid() {
			int mid = (right - left)/2;	
			swapValues(left, mid);
			pivot = left;
			return;	
		}
		
		public void doPartition3() {
			setPivotToMid();
			m1 = pivot;
			m2 = pivot;
			
			for (int pi = pivot + 1; pi <= right; ++pi) {
					if(aa[pi] <= aa[pivot]) {
						// ++[m1],swap [pi] <-> [m1]
						++m1;
						swapValues(m1,pi);
					}	
			}
			
			//add a 2nd loop here to run on the lower partition to sort out [pi] = [pivot]
			for (int pi = pivot + 1; pi <= m1; ++pi) {
				if(aa[pi] < aa[pivot]) {
					// ++[m2],swap [pi] <-> [m2]
					++m2;
					swapValues(m2,pi);
				}
			}
			
			swapValues(m2,pivot);
			--m2;
			
			return;
		
		}
		
	}
	
    private static boolean isMajorityElement() {
    	
    	Partition p = new Partition(0, aa.length - 1);
 
        if (p.left == p.right) {
            return true;
        }
        if (p.left + 1 == p.right) {
            if(aa[p.left] == aa[p.right])
            	return true;
            else
            	return false;
        }
        
        while(p.n >= majority ) {	//a majority of aa -> petition length > n/2
        	p.setPivotToMid();
        	p.doPartition3();
        	if(p.lengthMid() >= majority)
        		return true;
        	if(p.lengthLeft() > p.lengthRight()) {
        		p.right = p.m2;
        	} else {
        		p.left = p.m1;
        	}
        	
        }
        
        return false;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        
        aa = a;
        
        if (isMajorityElement() == true) {
            System.out.println(1);
        } else {
            System.out.println(0);
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

