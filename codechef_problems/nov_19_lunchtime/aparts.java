import java.util.*;
import java.lang.*;
import java.io.*;

class aparts {
	public static void main (String[] args) throws Exception {

		try{
			FastReader ip = new FastReader();			
			StringBuffer sb = new StringBuffer();

			int t = ip.nextInt();

			while(t-->0){
			    int n = ip.nextInt(), m=ip.nextInt();
			    int[][] a = new int[n+1][m+1];
			    for(int i=1;i<=n;i++){
			    	for(int j=1;j<=m;j++){
			    		a[i][j] = ip.nextInt();
			    	}
			    }

			    int[][] turn = new int[n+1][m+1];
			    for(int i=1;i<=n;i++){
			    	for(int j=1;j<=m;j++){
			    		turn[i][j] = a[n-i+1][j];
			    	}
			    }

			    for(int[] ct : a){
			    	System.out.println(Arrays.toString(ct));
			    }

			    System.out.println("\n");

			    for(int[] ct : turn){
			    	System.out.println(Arrays.toString(ct));
			    }


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