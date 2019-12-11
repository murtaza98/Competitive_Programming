import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		//code
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();


		    long sum = 0;
		    for(int i:arr){
		    	sum += (long)i;
		    }
		    long mean = sum%n==0 ? sum/n : -1;

		    // check if mean is present in array
		    int idx = -1;
		    for(int i=0;i<n;i++){
		    	if(arr[i] == mean){
		    		idx = i+1;
		    		break;
		    	}
		    }

		    if(idx == -1){
		    	sb.append("Impossible");
		    }else{
		    	sb.append(idx);
		    }


			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}