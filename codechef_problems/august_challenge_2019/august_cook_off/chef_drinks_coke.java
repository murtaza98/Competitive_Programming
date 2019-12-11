import java.util.*;
import java.lang.*;
import java.io.*;

class chef_drinks_coke {
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){		    
		    int[] tmp = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    int n=tmp[0];
		    int m=tmp[1];
		    int k=tmp[2];
		    int l=tmp[3];
		    int r=tmp[4];

		    int min_price = Integer.MAX_VALUE;

		    while(n>0){
		    	tmp = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    	int c=tmp[0];
		    	int p=tmp[1];

		    	if(c>k){
		    		c-=m;
		    		if(c<k){
		    			c=k;
		    		}
		    	}else if(c<k){
		    		c+=m;
		    		if(c>k){
		    			c=k;
		    		}
		    	}

		    	if(c>=l && c<=r){
		    		min_price = Math.min(min_price, p);
		    	}

		    	n--;
		    }

		    if(min_price == Integer.MAX_VALUE){
		    	sb.append(-1);
		    }else{
		    	sb.append(min_price);
		    }


			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}