import java.util.*;
import java.lang.*;
import java.io.*;

class palin {
	public static void main (String[] args) throws Exception {

		try{
			FastReader ip = new FastReader();
		
			int t = ip.nextInt();
			
			StringBuffer sb = new StringBuffer();

			while(t-->0){

				String k = ip.next().trim();


                boolean all_9 = check_for_all_9(k);

                if(all_9){
                    StringBuilder zeros = new StringBuilder();
                    for(int i=0;i<k.length()-1;i++){
                        zeros.append("0");
                    }

                    String new_k = "1" + zeros.toString() + "1";

                    sb.append(new_k);
                }else{
                    int left_half = Integer.parseInt(k.substring(0, (int)Math.ceil(k.length()/2.0)));
                    boolean isOdd = k.length()%2!=0;

                    String new_k = copy_left_side_to_right_reversed(String.valueOf(left_half), isOdd);
                    // System.out.println(left_half + " " + new_k);

                    if(Integer.parseInt(k)>=Integer.parseInt(new_k)){
                        // increament left half by 1 and then reverse it n add to right
                        left_half += 1;
                        new_k = copy_left_side_to_right_reversed(String.valueOf(left_half), isOdd);
                    }

                    sb.append(new_k);
                }
			    
				sb.append("\n");
			}

			System.out.print(sb);
		}catch(Exception e){
			System.out.println("Exception "+e);
			return;
		}
	}

    static String copy_left_side_to_right_reversed(String left_half, boolean isOdd){
        String reversed_left_half = (new StringBuilder(left_half)).reverse().toString();
        String left_right_merged = "";
        if(isOdd){
            if(reversed_left_half.length()>1){
                left_right_merged = left_half + reversed_left_half.substring(1);
            }else{
                left_right_merged = left_half;
            }
        }else{
            left_right_merged = left_half + reversed_left_half;
        }
        return left_right_merged;
    }

    static boolean check_for_all_9(String k){
        for(char c : k.toCharArray()){
            if(c != '9'){
                return false;
            }
        }
        return true;
    }
}

class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
        br = new BufferedReader(new
                 InputStreamReader(System.in)); 
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
} 	