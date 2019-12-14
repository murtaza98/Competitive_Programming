import java.util.*;
import java.lang.*;
import java.io.*;

class pibro {
	public static void main (String[] args) throws Exception {

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int t = Integer.parseInt(br.readLine().trim());
			
			StringBuffer sb = new StringBuffer();

			while(t-->0){
			    
			    int[] tmp = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			    int n = tmp[0];
			    int k = tmp[1];

			    String a = br.readLine().trim();

			    int[] left = new int[n];
			    int[] right = new int[n];

			    for(int i=1;i<n;i++){
			    	if(a.charAt(i-1)=='1'){
			    		left[i] = left[i-1]+1;
			    	}else{
			    		left[i] = 0;
			    	}
			    }

			    for(int i=n-2;i>=0;i--){
			    	if(a.charAt(i+1)=='1'){
			    		right[i] = right[i+1]+1;
			    	}else{
			    		right[i] = 0;
			    	}
			    }

			    int max_pizza_time = Integer.MIN_VALUE;

			    for(int i=0;i<n-k+1;i++){
			    	int pizza_time = left[i] + k + right[i+k-1];
			    	max_pizza_time = Math.max(max_pizza_time, pizza_time);
			    }

			    sb.append(max_pizza_time);

				sb.append("\n");
			}

			System.out.print(sb);
		}catch(Exception e){
			System.out.println("Exception "+e);
			return;
		}
	}
}