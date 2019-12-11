/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		try{
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
    		int t = Integer.parseInt(br.readLine());
    		
    		StringBuffer sb = new StringBuffer();
    
    		while(t>0){
    
    			String cards = br.readLine().trim();
    			
    			long count = cards.chars().filter(ch -> ch=='1').count();
    			
    			if(count % 2 == 0){
    			    sb.append("LOSE");
    			}else{
    			    sb.append("WIN");
    			}
                
                
                
    			t--;
    			if(t>0){
    			    sb.append("\n");
    			}
    		}
    
    		System.out.print(sb);
		}catch(Exception e){
		    return;
		}
	}
}
