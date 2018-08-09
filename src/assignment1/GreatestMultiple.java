package assignment1;

public class GreatestMultiple {

	public long greatestMultiple(long[] da) {
		int m1 = -1;
		int m2 = -1;
		int t = 0;
		int i = 0;
		
		if(da.length < 2)
			return 0;
		
		while (i < da.length) {
			if (m2 == -1){
				if (m1 == -1) {
					m1 = i;
					++i;
					continue;
				} else
					m2 = i;
					continue;
			}
			
			if(da[m2] > da[m1]) {
				t = m1;
				m1 = m2;
				m2 = t;
			}
			
			if(da[i] > da[m2]) {
				m2 = i;
			}
			
			++i;
			
		}
		
		return da[m1] * da[m2];
	}
	
	
	public static void main(String[] args) {
		
		long data[];
		

		

	}

}
