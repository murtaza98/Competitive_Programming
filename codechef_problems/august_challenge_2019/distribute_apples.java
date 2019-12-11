import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Main {
	public static void main (String[] args) throws Exception {		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long t = Long.parseLong(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			long[] tmp = Arrays.stream(br.readLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();

			long n=tmp[0];
			long k=tmp[1];

			if((n/k)%k==0){
				sb.append("NO");
			}else{
				sb.append("YES");
			}

			// WRONG SOLUTION
			// BigInteger bk = BigInteger.valueOf(k);
			// BigInteger bn = BigInteger.valueOf(n);
		    
			// if(bn.mod((bk.multiply(bk))).intValue() == 0){
			// 	sb.append("NO");
			// }else{
			// 	sb.append("YES");
			// }
			
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
}