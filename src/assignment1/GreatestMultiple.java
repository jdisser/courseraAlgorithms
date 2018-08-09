package assignment1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class GreatestMultiple {

	public static long shiftSwap(long[] da) {
		int m1 = -1;
		int m2 = -1;
		int t = 0;
		int i = 0;
		
		if(da.length < 2)
			return 0;
		
		while (i < da.length) {
			if (m2 == -1){			//load first two numbers
				if (m1 == -1) {
					m1 = i;
					++i;
					continue;
				} else
					m2 = i;
					if(da[m2] > da[m1]) {	//swap if greater
						t = m1;
						m1 = m2;
						m2 = t;
					}
					++i;
					continue;
			}
			
			if(da[i] > da[m2]) {	//shift to nest index
				m2 = i;
			}
			
			if(da[m2] > da[m1]) {	//swap if greater
				t = m1;
				m1 = m2;
				m2 = t;
			}

			
			++i;
			
		}
		
		return da[m1] * da[m2];
	}
	
	
	public static long searchMax(long[] da) {
		
		int m1 = 0;
		int m2 = 1;			//put max in [0] and start at [1] for the 2nd loop
		long t = 0;
		
		if(da.length < 2)
			return 0;
		
		for( int i=0; i < da.length; ++i) {			//find max in first loop
			if(da[m1] < da[i])
				m1 = i;
		}
		
		if(m1 != 0) {								//swap with [0]
			t = da[0];
			da[0] = da[m1];
			da[m1] = t;
		}
		
		for( int i=1; i < da.length; ++i) {			//find max in remaining numbers

			if(da[m2] < da[i])
				m2 = i;
		}

		return da[0] * da[m2];
	}
	
	public static void main(String[] args) {
		List<long[]> as = new ArrayList<long[]>();
		long[] data;
		data = new long[5];

		for(int i = 5; i > 0; --i) {
			data[i-1] = i;
		}
		
		as.add(data);
		
		for(int i = 1; i > 6; ++i) {
			data[i-1] = i;
		}
		
		as.add(data);
		
		for(long[] ary : as) {
			System.out.print("Test Array: [");
			for(int i = 0; i < ary.length; ++i)
				System.out.print(ary[i] + ",");
			System.out.println("]");
			System.out.println("ShiftSwap: " + shiftSwap(ary));
			System.out.println("SearchMax: " + searchMax(ary));
		}
		
	}

}
