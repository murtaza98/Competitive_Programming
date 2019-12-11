import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}