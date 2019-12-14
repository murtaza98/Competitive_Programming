import java.util.*;
import java.lang.*;
import java.io.*;

class deadend {
	public static void main (String[] args) throws Exception {

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int t = Integer.parseInt(br.readLine().trim());
			
			StringBuffer sb = new StringBuffer();

			while(t-->0){

				int n=Integer.parseInt(br.readLine().trim());
			    
			    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

			    Arrays.sort(arr);

			    int planted = 0;

			    for(int i=0;i<n;i++){
			    	if((i>0 && arr[i]-1==arr[i-1]) || (i<n-1 && arr[i]+1==arr[i+1])){
			    		// this is beautiful
			    	}else{
			    		planted++;
			    		arr[i]++;
			    	}
			    }

			    sb.append(planted);

				sb.append("\n");
			}

			System.out.print(sb);
		}catch(Exception e){
			System.out.println("Exception "+e);
			return;
		}
	}
}