import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {

		try{
			FastReader ip = new FastReader();
		
			int t = ip.nextInt();
			
			StringBuffer sb = new StringBuffer();

			while(t-->0){

				int n=ip.nextInt();
				int[] arr = new int[n+1];
				for(int i=1;i<=n;i++){
					arr[i] = ip.nextInt();
				}


                int noi = 0;    // number of inversions
                int li = 0;     // local inversions

                for(int i=1;i<=n;i++){
                    for(int j=i+1;j<=n;j++){
                        if(arr[i]>arr[j]){
                            noi++;
                        }
                    }
                }

                for(int i=1;i<n;i++){
                    if(arr[i]>arr[i+1]){
                        li++;
                    }
                }

                if(noi == li){
                    sb.append("YES");
                }else{
                    sb.append("NO");
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