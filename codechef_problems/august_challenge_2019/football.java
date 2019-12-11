import java.util.*;
import java.lang.*;
import java.io.*;

class football {
	public static void main (String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    
		    int[] goals = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    int[] fouls = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		    int max_score = Integer.MIN_VALUE;

		    for(int i=0;i<n;i++){
		    	int c_g = goals[i]*20;
		    	int c_f = fouls[i]*10;

		    	int c_s = c_g-c_f<0 ? 0 : c_g-c_f;

		    	max_score = Math.max(c_s, max_score);
		    }

		    sb.append(max_score);

			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}