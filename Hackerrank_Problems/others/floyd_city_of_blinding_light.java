import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    final static int INFINITY = 9999999;
    public static void main (String[] args) throws Exception {

        FastReader ip = new FastReader();
    
        int n = ip.nextInt(), m = ip.nextInt();
        
        StringBuffer sb = new StringBuffer();

        int[][] graph = new int[n+1][n+1];        // n+1 for 1 based indexing
        for(int i=1;i<=n;i++){
            Arrays.fill(graph[i], INFINITY);
        }

        // self-loop
        for(int i=1;i<=n;i++){
            graph[i][i] = 0;
        }

        // fill edges
        for(int i=0;i<m;i++){
            int from = ip.nextInt();
            int to = ip.nextInt();
            int cost = ip.nextInt();

            graph[from][to] = cost;
        }

        // main-code, calc all pair shortest path
        for(int k=1; k<=n; k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(graph[i][j] > graph[i][k]+graph[k][j]){
                        graph[i][j] = graph[i][k]+graph[k][j];
                    }
                }
            }
        }

        // run each query
        int q = ip.nextInt();
        while(q-- > 0){
            int from = ip.nextInt();
            int to = ip.nextInt();

            if(graph[from][to] == INFINITY){
                // no path exists
                sb.append("-1\n");
            }else{
                sb.append(graph[from][to]+"\n");
            }
        }

        System.out.print(sb);
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