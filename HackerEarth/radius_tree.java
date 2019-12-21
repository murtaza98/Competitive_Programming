import java.io.*;
import java.util.*;


// INPUT
// 1    -- Testcase
// 9    -- no of nodes
// 1 2  -- n-1 edges, where 1 is parent and 2 is child
// 1 3
// 2 4
// 2 5
// 4 6
// 4 7
// 6 8
// 7 9

public class radius_tree {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());
            int[][] edges = new int[N-1][2];
            for(int i_edges=0; i_edges<N-1; i_edges++)
            {
            	String[] arr_edges = br.readLine().split(" ");
            	for(int j_edges=0; j_edges<arr_edges.length; j_edges++)
            	{
            		edges[i_edges][j_edges] = Integer.parseInt(arr_edges[j_edges]);
            	}
            }

            int[] out_ = solve(edges,N);
            for(int i_out_=0; i_out_<out_.length; i_out_++)
            {
            	System.out.print(out_[i_out_] + " ");
            }
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    
    static int[] solve(int[][] edges, int N){
        // return an array with arr[0] = center of the circle and arr[1] = radius
        // of the circle.
        
        Graph tree = new Graph(N);
        
        for(int[] edge : edges){
            tree.addEdge(edge[0], edge[1]);
        }
        
        int max_radius = Integer.MIN_VALUE;
        int max_radius_node = -1;
        
        
        for(int i=1;i<=N;i++){
            int ancestors = tree.getAncestor(i);
            int descendant = tree.getDescendant(i);
            int radius = Math.min(ancestors, descendant);

            if(radius > max_radius){
                max_radius = radius;
                max_radius_node = i;
            }
        }

        return new int[]{max_radius_node, max_radius};    
    }
    
    static class Graph{
        LinkedList<Integer> adjList[];
        int[] ancestor, decendant;
        int[] parent;
        
        Graph(int n){
            adjList = new LinkedList[n+1];
            ancestor = new int[n+1];
            decendant = new int[n+1];
            parent = new int[n+1];
            for(int i=1;i<=n;i++){
                adjList[i] = new LinkedList<Integer>();
            }
            Arrays.fill(ancestor, -1);
            Arrays.fill(decendant, -1);
        }
        
        public int getAncestor(int node){
            if(ancestor[node] != -1){
                return ancestor[node];
            }else{
                int curr_node = node;
                int ht = -1;
                if(curr_node == 1){
                    ht = 0;
                }else{
                    ht = 1;
                    while(parent[curr_node] != 1){
                        curr_node = parent[curr_node];
                        ht++;
                    }
                }
                ancestor[node] = ht;
                return ancestor[node];
            }
        }

        public int getDescendant(int node){
            if(decendant[node] != -1){
                return decendant[node];
            }else{
                int ht = calc_height(node);
                decendant[node] = ht;
                return decendant[node];
            }
        }
        
        public int calc_height(int node){
            LinkedList<Integer> childs = adjList[node];
            if(childs.size()==0){
                // this is leaf
                decendant[node] = 0;
                return 0;
            }else{
                int ht = Integer.MAX_VALUE;
                for(int child : adjList[node]){
                    ht = Math.min(ht, calc_height(child));
                }
                
                decendant[node] = ht+1;
                return decendant[node];
            }
        }   
        
        public void addEdge(int from, int to){
            adjList[from].add(to);
            parent[to] = from;
        }
    }
    
}