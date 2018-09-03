import java.util.*;
import java.io.*;

public class MajorityElement {
	
	static int[] aa;
	static int majority; 
	
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
			return m1 - m2 + 1;
		}
		
		public int lengthRight() {
			return right - m1;
		}
		public int lengthLeft() {
			return m2 - left;
		}
		
		public void setN() {
			n = right - left + 1;
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
		
		// l <= (*i < *pivot) < m2 <= (*i == *pivot) <= m1 < (*i > *pivot) <= r
		public void doPartition3() {
			setPivotToMid();
			m1 = pivot;
			m2 = pivot;
			
			for (int pi = pivot + 1; pi <= right; ++pi) {
					if(aa[pi] <= aa[pivot]) {
						++m1;
						if(pi != m1)
							swapValues(m1,pi);
					}	
			}
			

			for (int pi = pivot + 1; pi <= m1; ++pi) {
				if(aa[pi] < aa[pivot]) {
					++m2;
					if(pi != m2)
						swapValues(m2,pi);
				}
			}
			
			if(m2 != pivot)
				swapValues(m2,pivot);

			
			return;
		
		}

		@Override
		public String toString() {
			return "Partition [left=" + left + ", right=" + right + ", m1=" + m1 + ", m2=" + m2 + ", pivot=" + pivot
					+ ", t=" + t + ", n=" + n + ", leftL:" + lengthLeft() +  ", midL:" + lengthMid() + ", rightL:" + lengthRight() +"]";
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
        //System.out.println("Initially");
        //System.out.println(p.toString());
        //System.out.println(Arrays.toString(aa));
        
        int safety = 0;
        
        while(p.n >= majority ) {	//a majority of aa -> petition length > n/2
        	p.setPivotToMid();
        	p.doPartition3();
        	
        	//System.out.println("after setPivot and doPartition");
        	//System.out.println(p.toString());
            //System.out.println(Arrays.toString(aa));

            
            
        	if(p.lengthMid() >= majority)
        		return true;
        	if(p.lengthLeft() > p.lengthRight()) {
        		p.right = p.m2 - 1;
        		p.setN();
        		//System.out.println("left is greater");
        	} else {
        		p.left = p.m1 + 1;
        		p.setN();
        		//System.out.println("right is greater");
        	}
        	
        	//System.out.println("after majority test and set ends");
        	//System.out.println(p.toString());
            //System.out.println(Arrays.toString(aa));
        	//break;	//for debug
        	/*
        	if(++safety > 10) {
        		System.out.println("SAFETY BREAK !!!!!!");
        		break;
        	}
        	*/
        		
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
        majority = (aa.length / 2) + 1;
        
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

