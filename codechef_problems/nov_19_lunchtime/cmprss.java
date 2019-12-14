import java.util.*;
import java.lang.*;
import java.io.*;

class cmprss {
	public static void main (String[] args) throws Exception {

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int t = Integer.parseInt(br.readLine().trim());
			
			StringBuffer sb = new StringBuffer();

			while(t-->0){

				int n=Integer.parseInt(br.readLine().trim());
			    
			    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

			    ArrayList<Integer> valid_nos = new ArrayList<>();

			    int l=0, r=1;

			    while(l<n){
			    	while(r<n){
				    	if(arr[r]-arr[r-1]==1){
				    		// increasing
				    		r++;
				    	}else{
				    		break;
				    	}
				    }

				    if((r-1)-l <= 1){
				    	// comma seperated
				    	while(l<r){
				    		// valid_nos.add(arr[l]);
				    		sb.append(arr[l]);
				    		l++;
				    		if(l!=r){
				    			sb.append(",");
				    		}
				    	}
				    }else{
				    	// range ...
				    	sb.append(String.format("%d...%d", arr[l], arr[r-1]));
				    	// valid_nos.add(arr[l]);
				    	// valid_nos.add(arr[r-1]);
				    }



				    l = r;
				    r = r+1;

				    if(l!=n){
				    	sb.append(",");
				    }
			    }

			    // System.out.println(Arrays.toString(valid_nos.toArray()));

				sb.append("\n");
			}

			System.out.print(sb);
		}catch(Exception e){
			System.out.println("Exception "+e);
			return;
		}
	}
}