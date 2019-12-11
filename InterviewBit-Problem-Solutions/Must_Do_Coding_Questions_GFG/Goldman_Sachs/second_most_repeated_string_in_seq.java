import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    
		    String[] arr = br.readLine().trim().split("\\s+");
            
            
            HashMap<String, Integer> occ = new HashMap<>();
            
            for(int i=0;i<n;i++){
                if(occ.containsKey(arr[i])){
                    occ.put(arr[i], occ.get(arr[i])+1);                    
                }else{
                    occ.put(arr[i], 1);
                }
            }
            
            
            // find occ of second last element
            int first_max = 0, second_max=0;
            
            Iterator<Map.Entry<String, Integer>> it = occ.entrySet().iterator();
            
            while(it.hasNext()){
                Map.Entry<String,Integer> ce = (Map.Entry<String,Integer>)it.next();
                int co = ce.getValue();
                if(co > first_max){
                    second_max = first_max;
                    first_max = co;
                }else if(co > second_max){
                    second_max = co;
                }
            }
            
            
            // get element using occ
            it = occ.entrySet().iterator();
            while(it.hasNext()){
                Map.Entry<String,Integer> ce = (Map.Entry<String,Integer>)it.next();
                int co = ce.getValue();
                if(co == second_max){
                    sb.append(ce.getKey());
                    break;
                }
            }

			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}