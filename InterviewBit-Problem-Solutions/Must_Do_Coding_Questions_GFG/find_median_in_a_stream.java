/*

Given an input stream of N integers. The task is to insert these numbers into a new stream and find the median of the stream formed by each insertion of X to the new stream.

Input:
The first line of input contains an integer N denoting the number of elements in the stream. Then the next N lines contains integer x denoting the number to be inserted into the stream.
Output:
For each element added to the stream print the floor of the new median in a new line.
 
Constraints:
1 <= N <= 106
1 <= x <= 106
 
Example:
Input:
4
5
15
1 
3
Output:
5
10
5
4
 
Explanation:
Testcase 1:
Flow in stream : 5, 15, 1, 3 
5 goes to stream --> median 5 (5) 
15 goes to stream --> median 10 (5, 15) 
1 goes to stream --> median 5 (5, 15, 1) 
3 goes to stream --> median 4 (5, 15, 1, 3) 
*/



import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();
		
		PriorityQueue<Integer> min_heap = new PriorityQueue<>();
		PriorityQueue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());
        
        // add first element in min_heap
        max_heap.add(Integer.parseInt(br.readLine().trim()));
        sb.append(max_heap.peek()+"\n");
        t--;
        
		while(t>0){

			int no=Integer.parseInt(br.readLine().trim());
			
			if(min_heap.size() == max_heap.size()){
			    if(min_heap.peek() < no){
			        // remove root from min_heap and add it to max_heap, then 
			        // add new 'no' to min_heap
			        int min_root = min_heap.poll();
			        
			        max_heap.add(min_root);
			        
			        min_heap.add(no);
			    }else{
			        // add this new 'no' to max_heap
			        max_heap.add(no);
			    }
			    // odd no of elements, so median will be root of max_heap  
			    sb.append(max_heap.peek());
			}else{
			    if(max_heap.peek() > no){
			        // remove root from max_heap and add it to min_heap, then 
			        // add new 'no' to max_heap
			        
			        int max_root = max_heap.poll();
			        
			        min_heap.add(max_root);
			        
			        max_heap.add(no);
			    }else{
			        // add this to min_heap
			        min_heap.add(no);
			    }
			    
			    //  even no of elements, so median will be avg of root of min_heap and max_heap
			    int min_root = min_heap.peek();
			    int max_root = max_heap.peek();
			    
			    sb.append((min_root+max_root)/2);
			}

			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
		
	}
}