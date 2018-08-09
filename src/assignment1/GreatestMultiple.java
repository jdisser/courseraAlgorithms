package assignment1;

public class GreatestMultiple {

	public long shiftSwap(long[] da) {
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
	
	
	public long searchMax(long[] da) {
		
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

}
