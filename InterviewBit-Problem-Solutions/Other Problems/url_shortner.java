/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws IOException {
		//code
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){
            
            long n=Long.parseLong(br.readLine().trim());
            
            String url = idToUrl(n);
            
            long new_id = urlToId(url);
            
            sb.append(url+"\n"+new_id);
            
			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}
	
	public static long urlToId(String url){
	    long id = 0;
	    
	    for(int i=0;i<url.length();i++){
	        if('a'<=url.charAt(i) && url.charAt(i)<='z'){
	            id = id*62 + url.charAt(i)-'a';     
	        }else if('A'<=url.charAt(i) && url.charAt(i)<='Z'){
	            id = id*62 + url.charAt(i)-'A'+26;
	        }else if('0'<=url.charAt(i) && url.charAt(i)<='9'){
	            id = id*62 + url.charAt(i)-'0'+52;
	        }
	    }
	    
	    return id;
	}
	
	public static String idToUrl(long n){
	    StringBuffer sb = new StringBuffer();
	    
	    String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	    
	    while(n > 0){
	        sb.append(map.charAt((int)(n%62)));
	        n/=62;
	    }
	    
	    sb.reverse();
	    
	    return sb.toString();
	}
}