import java.util.*;
import java.lang.*;
import java.io.*;

class combination_Sum {
    static ArrayList<ArrayList<Integer>> all_pairs = new ArrayList<ArrayList<Integer>>();
    
    
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();
		
		while(t>0){
			all_pairs.clear();
		    int n = Integer.parseInt(br.readLine().trim());
		    int[] tmp_el = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    int sum = Integer.parseInt(br.readLine().trim());
		  
		  	Arrays.sort(tmp_el);
		    ArrayList<Integer> el = new ArrayList<>();
		    
		    for(int i:tmp_el){
		        el.add(i);
		    }
		    
		  //  System.out.println(Arrays.toString(el.toArray()));
		    
		    ArrayList<Integer> seen = new ArrayList<>();
		    getPairs(el, 0, sum, seen);
		    
    		 //  print all pairs
    		 if(all_pairs.size() == 0){
    		  	// empty
    		  	sb.append("Empty");  
			 }else{
			    for(ArrayList<Integer> i:all_pairs){
	    		     sb.append("(");
	    		     for(int j=0;j<i.size();j++){
	    		         if(j==i.size()-1){
	    		             sb.append(i.get(j));
	    		         }else{
	    		             sb.append(i.get(j)+" ");
	    		         }
	    		     }
	    		     sb.append(")");
	    		}    
			 }
		    
		    
		    t--;
		    if(t>0){
		        sb.append("\n");
		    }
		}
		System.out.print(sb);
	}
	
	public static void getPairs(ArrayList<Integer> el, int i, int sum, ArrayList<Integer> seen_el){
	    if(sum == 0){
	    	if(!all_pairs.contains(seen_el)){
	    		ArrayList<Integer> final_seen = new ArrayList<>(seen_el);
	    		// System.out.println(Arrays.toString(final_seen.toArray()));
	        	all_pairs.add(final_seen);
	    	}
	    	
	        // System.out.println(Arrays.toString(seen_el.toArray()));
	        return;
	    }

	    // System.out.println(Arrays.toString(el.toArray()));
	    while(i < el.size()){
	    	
	    	if(sum - el.get(i) >= 0){
	    		// include curr element
	    		seen_el.add(el.get(i));

	    		getPairs(el, i+1, sum-el.get(i), seen_el);

	    		// exclude curr element
	    		seen_el.remove((Integer)el.get(i));
	    	}
	    	i++;
	    }
	}
}