import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
      //write your code here
    	

		int m1 = l;
		int m2 = l;
		int t;
		int pivot = l;
		
		for (int pi = pivot + 1; pi <= r; ++pi) {
				if(a[pi] <= a[pivot]) {
					++m1;
					//if(pi != m1){
						//swapValues(m1,pi);		//swapValues(to,from)
						t = a[m1];
						a[m1] = a[pi];
						a[pi] = t;
					//}
				}	
		}
		

		for (int pi = pivot + 1; pi <= m1; ++pi) {
			if (a[pi] < a[pivot]) {
				++m2;
				//if(pi != m2){
					//swapValues(m2,pi);
					t = a[m2];
					a[m2] = a[pi];
					a[pi] = t;
				//}
			}
		}
		
		//if(m2 != pivot){
			//swapValues(m2,pivot);
			t = a[m2];
			a[m2] = a[pivot];
			a[pivot] = t;
		//}

		int[] m = {m1, m2};
		return m;

    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int t = a[i];
                a[i] = a[j];
                a[j] = t;
            }
        }
        int t = a[l];
        a[l] = a[j];
        a[j] = t;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int k = random.nextInt(r - l + 1) + l;
        int t = a[l];
        a[l] = a[k];
        a[k] = t;
        
        //use partition2
        /*
        int m = partition2(a, l, r);
        randomizedQuickSort(a, l, m - 1);
        randomizedQuickSort(a, m + 1, r);
        */
        
        //use partition 3
        int[] m = partition3(a, l, r);				//left pointer is m2 -> m[1] & right m1 -> m[0]
        randomizedQuickSort(a, l, m[1] - 1);
        randomizedQuickSort(a, m[0] + 1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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

