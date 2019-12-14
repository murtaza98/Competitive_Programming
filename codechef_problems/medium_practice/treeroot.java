import java.util.*;
import java.lang.*;
import java.io.*;

class treeroot {
	public static void main (String[] args) throws Exception {
		try{
			FastReader ip = new FastReader();
		
			int t = ip.nextInt();
			
			StringBuffer sb = new StringBuffer();

			while(t-->0){

				int n=ip.nextInt();

				// calc sum(node_id - sum_of_childs_node_id)
				int id_minus_sid = 0;

				for(int i=0;i<n;i++){
					id_minus_sid += ip.nextInt() - ip.nextInt();
				}

				// all childs will get cancelled out, the remainder will be root
				int root = id_minus_sid;

				sb.append(root);
			    
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