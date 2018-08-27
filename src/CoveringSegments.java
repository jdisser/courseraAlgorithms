import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
    	
    	int[] points = new int[segments.length + 1];
    	int pointP = 0;										//pointer into the points array
    	
    	segments = sort(segments);
    	
    	Segment current = segments[0];						//Initialize the algorithm to the first segment
    	Segment container = segments[0];

    	int point = current.getStart();
		points[pointP] = point;								//add the initial point for the first segment
    	
    	int n = segments.length;							//initialize the loop parameters
    	int p = 0;
    	
    	if (n==1) {											//return for single segment case
    		return points;
    	}
    	
    	while(p < n - 1) {
    		
    		for(int i = p+1; i < n; ++i) {
    			if(container.contains(segments[i])) {			//process the group of nested segments

    				p = i;										//if the segment is contained move the list pointer and
    				point = segments[i].getStart();			
    				points[pointP] = point;						//move the point to it's start
    				current = segments[p];						//and make it the current segment
    				container = container.getContainer(current);//The container is the union of the area above all segs
    				
    			} else {									//if it's not contained start a new group
    				p = i;									//move the list pointer
    				current = segments[p];					//and make it the current segment
       				point = current.getStart();				
    				++pointP;
    				points[pointP] = point;					//add it's start to points
    				container = current;					//reset the group container to the current segment
    				
    				break;									//then break and reenter the group processing loop
    			}
    		}

    	}
    	
    	return points;
    	
    }

    private static class Segment {
        

		int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
        
        public int getStart() {
        	return this.start;
        }
        
        public int getEnd() {
        	return this.end;
        }
        
        
        public boolean contains(Segment s) {
        	if(s.getStart() >= this.start && s.getStart() <= this.end)
        		return true;
        	else
        		return false;
        	
        }
        
        public Segment getContainer(Segment s) {
        	int start = s.getStart();
        	int end = s.getEnd();
        	
        	if(end >= this.end)
        		end = this.end;
        	
        	Segment c = new Segment(start, end);
        	return c;
        	
        }
        
        @Override
		public String toString() {
			return "Segment [start=" + start + ", end=" + end + "]";
		}
        
    }
    
    public static Segment[] sort(Segment[] segments) {
    	
    	Segment t;
    	int pS = 0;
    	int minStart = Integer.MAX_VALUE;
    	int n = segments.length;
    	
    	for(int top = 0; top < n-1; ++top) {
    		for(int i = top; i < n; ++i ) {
        		if(segments[i].getStart() < minStart)
        			minStart = segments[i].getStart();
        			pS = i;
        	}
    		if(pS != top) {
    			t = segments[top];
    			segments[top] = segments[pS];
    			segments[pS] = t;
    		}
    		
    		minStart = Integer.MAX_VALUE;
    		
    		
    	}
    	
    	
    	return segments;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
        scanner.close();
    }
}
 
