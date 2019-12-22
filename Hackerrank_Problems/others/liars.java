import java.util.*;
import java.lang.*;
import java.io.*;

class liars {
    public static void main(String[] args) throws Exception {
        final FastReader ip = new FastReader();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = ip.nextInt(), m = ip.nextInt();

        int[][] input = new int[m][3];
        for(int i=0;i<m;i++){
            input[i][0] = ip.nextInt();
            input[i][1] = ip.nextInt();
            input[i][2] = ip.nextInt();
        }

        int total_nodes = n+1;
        int total_edges = 2*m + 2*(total_nodes);
        
        // FIND MAXIMUM
        Graph graph = new Graph(n+1, total_edges);

        for(int i=0;i<m;i++){
            int src = input[i][0];
            int dest = input[i][1];
            int weight = input[i][2];
            graph.addEdge(src-1, dest, weight);
            graph.addEdge(dest, src-1, -weight);
        }
        for(int i=0;i<n;i++){
            graph.addEdge(i, i+1, 1);
            graph.addEdge(i+1, i, 0);
        }

        // for max_liars find shortest path from node 0 to node n
        int max_liars = graph.bellmanFord(0, true);

        // for min_liars find shotest path from node n to node 0
        int min_liars = graph.bellmanFord(n, false);        

        bufferedWriter.write(String.format("%d %d", min_liars, max_liars));

        bufferedWriter.newLine();
        bufferedWriter.close();
    }
}

class Graph{

    class Edge{
        private int src, dest, weight;
        Edge(final int src, final int dest, final int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
    }

    int V, E;
    Edge[] edges;
    int edges_ptr;

    Graph(final int v, final int e) {
        this.V = v;
        this.E = e;
        edges = new Edge[e];
        edges_ptr = 0;
    }

    void addEdge(int src, int dest, int weight){
        edges[this.edges_ptr] = new Edge(src, dest, weight);
        this.edges_ptr++;
    }

    // return distance from start to first or last node based on getLast flag
    int bellmanFord(int start, boolean getLast){
        int[] prev_dist = new int[V];
        int[] curr_dist = new int[V];

        // Step 1: Initialize distances from src to all other 
        // vertices as INFINITE
        for(int i=0;i<V;i++){
            curr_dist[i] = Integer.MAX_VALUE;
        }
        curr_dist[start] = 0;

        // Step 2: Main Step, repeat atmost v-1 times
        for(int i=0;i<V-1;i++){
            for(int j=0;j<E;j++){
                if(edges[j] != null){
                    int src = edges[j].src;
                    int dest = edges[j].dest;
                    int weight = edges[j].weight;

                    if(curr_dist[src] != Integer.MAX_VALUE && curr_dist[src]+weight < curr_dist[dest]){
                        curr_dist[dest] = curr_dist[src]+weight;
                    }
                }
            }

            // check if any distance is changed, early stop
            if(Arrays.equals(curr_dist, prev_dist)){
                // System.out.println("Early pause");
                break;
            }else{
                // store copy of curr_dist in prev_dist
                System.arraycopy(curr_dist, 0, prev_dist, 0, curr_dist.length);
            }
        }
        
        // System.out.println(Arrays.toString(curr_dist));
        
        return getLast ? Math.abs(curr_dist[V-1]) : Math.abs(curr_dist[0]);
    }
}

class FastReader {
    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (final IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
}
