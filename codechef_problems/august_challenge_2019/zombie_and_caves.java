// https://www.codechef.com/problems/ZOMCAV

import java.util.*;
import java.lang.*;
import java.io.*;

public class zombie_and_caves
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){
			int n=Integer.parseInt(br.readLine().trim());
		    
		    int[] c = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    int[] h = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		    int[] diff = new int[n+1];

		    // OPTIMIZED WAY to calculate radiation
		    for(int i=0;i<n;i++){
		    	int l = i-c[i] >= 0 ? i-c[i] : 0;
		    	int r = i+c[i] <= n-1 ? i+c[i] : n-1;

		    	// update the diff
		    	diff[l]++;
		    	diff[r+1]--;
		    }


		    int[] radiation = calculate_radiation(diff);


		   	// BRUTE FORCE WAY to calculate radiation
		    // int[] radiation = new int[n];

		    // for(int i=0;i<n;i++){
		    // 	// current cave radiation
		    // 	radiation[i]++;

		    // 	// spred radiation in adjacent caves
		    // 	int cr = c[i];
		    // 	// forward caves
		    // 	for(int j=i+1;j<=i+cr && j<n;j++){
		    // 		radiation[j]++;
		    // 	}
		    // 	// backward caves
		    // 	for(int j=i-1;j>=i-cr && j>=0;j--){
		    // 		radiation[j]++;
		    // 	}
		    // }

		    // System.out.println(Arrays.toString(radiation));


		    // TODO, check if 2 arrays are equal using hashing
		    HashMap<Integer,Integer> h_occ = new HashMap<>();
		    for(int i=0;i<n;i++){
		    	if(h_occ.containsKey(radiation[i])){
		    		h_occ.put(radiation[i], h_occ.get(radiation[i])+1);
		    	}else{
		    		h_occ.put(radiation[i], 1);
		    	}
		    }


		    boolean possible = true;
		    for(int i=0;i<n;i++){
		    	if(!h_occ.containsKey(h[i])){
		    		possible = false;
		    		break;
		    	}else{
		    		h_occ.put(h[i], h_occ.get(h[i])-1);

		    		if(h_occ.get(h[i]) < 0){
		    			possible = false;
		    			break;
		    		}

		    	}
		    }

		    sb.append(possible?"YES":"NO");


			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}

	static int[] calculate_radiation(int[] diff){
		for(int i=1;i<diff.length-1;i++){
			diff[i] = diff[i]+diff[i-1];
		}
		// copy n element from diff which is of size n+1
		int[] radiation = new int[diff.length-1];
		System.arraycopy(diff, 0, radiation, 0, diff.length-1);
		return radiation;
	}
}
