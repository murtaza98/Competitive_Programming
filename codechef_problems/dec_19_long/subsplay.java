import java.util.*;
import java.lang.*;
import java.io.*;

// LOGIC
// Find a pair of repeating chars such that they are least distance apart,
// then delete chars in between these 2 pairs
// the remaining length will be the max length of subsequence

class subsplay {
	public static void main (String[] args) throws Exception {
		try{
			FastReader ip = new FastReader();
			int t = ip.nextInt();
			StringBuffer sb = new StringBuffer();

			while(t-->0){
				int n = ip.nextInt();
                String s = ip.next();
                
                int[] last_indx = new int[26];
                Arrays.fill(last_indx, -1);

                
                int least_dist = n;
                for(int i=0;i<n;i++){
                    int ci = s.charAt(i)-'a';
                    if(last_indx[ci] != -1){
                        least_dist = Math.min(least_dist, i-last_indx[ci]);
                    }
                    last_indx[ci] = i;
                }

                sb.append(String.valueOf(n-least_dist));
				sb.append("\n");
			}

			System.out.print(sb);
		}catch(Exception e){
			System.out.println("Exception "+e);
			return;
		}
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