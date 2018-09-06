import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        Collections.reverse(sequence);
        return sequence;
    }
    
    private static List<Integer> dynamicSequence(int n){
    	
    	
    	List<Integer> numOps = new ArrayList<Integer>();
    	List<Integer> sequence = new ArrayList<Integer>();
    	
    	numOps.add(0, 0); 	//this should never occur
    	numOps.add(1, 0);	//this is the initial value and is given
    	numOps.add(2, 1);
    	numOps.add(3, 1);
    	
    	
    	int test = 0;
    	int minOps;
    	
    	for(int i = 4; i <= n; ++i) { // the termination of this loop can be reduced by one or two ops but will cost comps
    		//for each operation test the number of ops
    		//store the # of ops in numOps[i]
    		minOps = Integer.MAX_VALUE;
    		
    		numOps.add(i, 0); 				//initialize the arraylist
    		
    		if (i % 2 == 0) {
    			test = numOps.get(i/2) + 1;
    			if(test < minOps) {
    				minOps = test;
    				numOps.set(i, test);
    			}
    		}
    		
    		if (i % 3 == 0) {
    			test = numOps.get(i/3) + 1;
    			if(test < minOps) {
    				minOps = test;
    				numOps.set(i, test);
    			}
    		}
    		
    		test = numOps.get(i-1) + 1;
    		
    		if(test < minOps) {
				minOps = test;
				numOps.set(i, test);
			}
    	}
    	
    	
    	//initialize the sequence to the n value
    	sequence.add(0, n);
    	int cV = n;
    	int is = 0;
    	int op = 0;
    	
    	while (cV >= 1) {				//last value in the sequence should be 1
    		
    		minOps = Integer.MAX_VALUE;
    		op = 0;
    		
    		++is;						//next element in the sequence
    		sequence.add(is, 0); 		//initialize the sequence element
    		
    		if(cV == 1) {				//tests will fail with base cases so handle them explicitly
    			sequence.set(is, cV);
    			break;
    		}
    		
    		if(cV == 2) {				
    			sequence.set(is, cV);
    			cV = 1;
    			continue;
    		}
    		
    		if(cV == 3) {				
    			sequence.set(is, cV);
    			cV = 1;
    			continue;
    		}
    		
    		if (cV % 2 == 0) {			//look for the least numOps to get back to 1
    			test = numOps.get(cV/2);
    			if(test < minOps) {
    				op = 2;
    				minOps = test;
    			}
    		}
    		
    		if (cV % 3 == 0) {
    			test = numOps.get(cV/3);
    			if(test < minOps) {
    				op = 3;
    				minOps = test;
    			}
    		}
    		
    		test = numOps.get(cV-1);
    		
    		if(test < minOps) {
    			op = 1;					//after all 3 tests this may be one of many but equal paths
    			minOps = test;
			}
    		
    		switch (op) {				
	    		case 1:
	    			cV -= 1;				//adjust the current value based on the min op 
					sequence.set(is, cV);	//and store the result of the op on the current value
	    		break;
	    			
	    		case 2:
	    			cV /= 2;
    				sequence.set(is, cV);
	    		break;
	    		case 3:
	    			cV /= 3;
    				sequence.set(is, cV);
	    		break;
	    		default:
	    		break;
    		}

    	}
    	
    	Collections.reverse(sequence); 		//reverse the sequence so it starts with 1
    	return sequence;
    	
    	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = dynamicSequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
        
        scanner.close();
    }
}

