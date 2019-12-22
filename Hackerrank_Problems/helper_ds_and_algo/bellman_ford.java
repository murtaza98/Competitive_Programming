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