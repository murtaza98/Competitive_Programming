import java.util.*;
import java.lang.*;
import java.io.*;

class subsplay {
	static HashMap<String, Integer> subs;
	static String s;
	public static void main (String[] args) throws Exception {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int t = Integer.parseInt(br.readLine().trim());
			
			StringBuffer sb = new StringBuffer();

			while(t-->0){

				int n=Integer.parseInt(br.readLine().trim());
			    
				s = br.readLine().trim();

				subs = new HashMap<>();

				generate_subsequences(0, new StringBuilder());

				int max_k = 0;
				int max_occ = 1;


				Iterator <Map.Entry<String, Integer>> iter = subs.entrySet().iterator();
				while(iter.hasNext()){
					Map.Entry<String, Integer> entry = iter.next();
					if(entry.getValue() > 1 && entry.getKey().length() > max_k){
						max_k = entry.getKey().length();
					}
				}

				sb.append(max_k);


				sb.append("\n");
			
			}			
			System.out.print(sb);
		}catch(Exception e){
			// System.out.print("Exception "+e);
			return;
		}
	}

	static void generate_subsequences(int i, StringBuilder curr_subs){
		if(i==s.length()){
			String key = curr_subs.toString();
			if(subs.containsKey(key)){
				subs.put(key, subs.get(key)+1);
			}else{
				subs.put(key, 1);
			}
			return;
		}
		StringBuilder with_i = new StringBuilder(curr_subs.toString());
		with_i.append(s.charAt(i));
		generate_subsequences(i+1, with_i);
		generate_subsequences(i+1, curr_subs);
	}

}