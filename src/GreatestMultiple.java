


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;
import java.lang.Math;


public class GreatestMultiple {

	public static long shiftSwap(long[] da) {
		int m1 = 0;
		int m2 = 0;
		int t = 0;
		int i = 2;
		
		if(da.length < 2)
			return 0;
		
		if(da[0] > da[1]) {
			m1 = 0;
			m2 = 1;
		} else {
			m1 = 1;
			m2 = 0;
		}
			
		
		while (i < da.length) {

			if(da[i] > da[m2]) {	//shift to next index
				m2 = i;
				if(da[m2] > da[m1]) {	//swap if greater
					t = m1;
					m1 = m2;
					m2 = t;
				}
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
	
	
	
	
	public static void stressTest(int n, int rng, int itr) {
		
		long[] stressData = new long[n];
		long ref;
		long fast;

		
		for(int l = 0; l < itr; ++l) {
			for(int i = 0; i < n; ++i) {
				stressData[i] = Math.round(Math.random() * rng);
			}
			
			ref = searchMax(stressData);
			fast = shiftSwap(stressData);

			
			if (ref != fast) {
				System.out.println("Stress Test Failed: Loop " + l);
				return;
			}
			
		}
		System.out.println("Stress Test Passed: Loops:" + itr + " Length: " + n + " Range: " + rng);
		return;
	}
	
	public static void staticTest() {
		Set<long[]> as = new HashSet<long[]>();
		
		long[] data2 = new long[5];
		long[] data1 = new long[5];
		long[] data3 = new long[5];
		
		long[] lrgData = new long[200000];

		long[] minData1 = new long[2];
		long[] minData2 = new long[2];
		long[] minData3 = new long[2];
		
		minData1[0] = 1;
		minData1[1] = 2;
		
		as.add(minData1);
		
		minData2[0] = 2;
		minData2[1] = 1;
		
		as.add(minData2);
		
		minData3[0] = 100000;
		minData3[1] = 90000;
		
		as.add(minData3);
				
		
		for(int i = 5; i > 0; --i) {
			data2[i-1] = i;
		}
		
		for(int i = 1; i < 6; ++i) {
			data1[i-1] = 6 - i;
		}
		
		as.add(data1);
		as.add(data2);
		
		Arrays.setAll(data3, i -> i + 1);
		data3[2] = 5;
		as.add(data3); 	//test for duplicate maximum
		
		
		for(long[] ary : as) {
			System.out.print("Test Array: [");
			for(int i = 0; i < ary.length; ++i)
				System.out.print(ary[i] + ",");
			System.out.println("]");
			System.out.println("ShiftSwap: " + shiftSwap(ary));
			System.out.println("SearchMax: " + searchMax(ary));
		}
		
		System.out.println("Large Dataset Test");
		for(int i = 0; i < 200000; ++i) {
			lrgData[i] = i + 1;
		}
		System.out.println("ShiftSwap: " + shiftSwap(lrgData));
		System.out.println("SearchMax: " + searchMax(lrgData));
	}
	
	public static void timeTest() {
		
		long[] stressData = new long[200000];
		long fast = 0;
		
		
			for(int i = 0; i < 200000; ++i) {
				stressData[i] = Math.round(Math.random() * 200000);
			}
		
		long tStart;
		long tEnd;
		long elapsed;
		
		tStart = System.currentTimeMillis();
		fast = shiftSwap(stressData);
		tEnd = System.currentTimeMillis();
		elapsed = tEnd -tStart;
		
		System.out.println("Run Time Test: " + elapsed + " Milliseonds" );
		System.out.println("Max Product: " + fast);
		
	}
	
	public static void main(String[] args) {

		/*
		 * 
		 * 
		 *  This is the 2nd version submitted for assignment 1
		 *  it has a shorter algorithm than the 1st version
		 *  
		 *  
		System.out.println("Static Test");
		staticTest();
		
		System.out.println("Stress Test");
		stressTest(50, 100, 3000);
		
		timeTest();
		*/
		
		Scanner s = new Scanner(System.in);
		
		int length = s.nextInt();
		
		long[] testData = new long[length];
		
		for(int i = 0; i < length; ++i) {
			testData[i] = s.nextLong();
		}
		
		System.out.println(shiftSwap(testData));
		
		s.close();
		
		
	}

}
