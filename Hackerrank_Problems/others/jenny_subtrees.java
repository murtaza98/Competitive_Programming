import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class jenny_subtrees {

    static class Graph{
        LinkedList<Integer> adjList[];
        int n;
        String[] signatures;

        Graph(int n){
            adjList = new LinkedList[n+1];
            this.n = n;
            for(int i=1;i<=n;i++){
                adjList[i] = new LinkedList<Integer>();
            }
        }

        public void addEdge(int from, int to){
            adjList[from].add(to);
            adjList[to].add(from);
        }

        public Graph create_subtree(int root, int radius){

            class QNode{
                int node, level;
                QNode(int node, int level){
                    this.node = node;
                    this.level = level;
                }
            }

            class Edge{
                int from, to;
                Edge(int from, int to){
                    this.from = from;
                    this.to = to;
                }
            }

            HashSet<Integer> nodes = new HashSet<>();
            LinkedList<Edge> edges = new LinkedList<>();

            Queue<QNode> q = new LinkedList<>();
            q.add(new QNode(root, 0));
            HashSet<Integer> visited = new HashSet<>();
            visited.add(root);
            nodes.add(root);
            
            while(!q.isEmpty()){
                QNode curr_node = q.poll();

                for(int child : adjList[curr_node.node]){
                    int new_node_level = curr_node.level+1;
                    QNode new_node = new QNode(child, new_node_level);
                    if(new_node_level<=radius && !visited.contains(child)){
                        q.add(new_node);
                        nodes.add(child);
                        edges.add(new Edge(curr_node.node, child));
                        visited.add(child);
                    }
                }
            }

            // create graph
            int total_nodes = nodes.size();
            // map all nodes values to 1....total_nodes
            HashMap<Integer, Integer> map = new HashMap<>();
            int mp = 1;
            // make sure that root is always at index 1
            map.put(root, 1);
            mp++;
            nodes.remove(root);
            for(int i : nodes){
                map.put(i, mp);
                mp++;
            }
            Graph subtree = new Graph(total_nodes);
            for(Edge e : edges){
                subtree.addEdge(map.get(e.from), map.get(e.to));
            }
            return subtree;
        }
    
        public String generate_signature(){
            signatures = new String[n+1];
            
            HashSet<Integer> visited = new HashSet<>();

            assign_canonical_names(1, visited);

            return signatures[1];
        }

        void assign_canonical_names(int node, HashSet<Integer> visited){
            HashSet<Integer> childs = new HashSet<>();
            if(adjList[node].size() == 1){
                // leaf node
                signatures[node] = "10";
            }else{
                for(int child : adjList[node]){
                    if(!visited.contains(child)){
                        visited.add(child);
                        childs.add(child);
                        assign_canonical_names(child, visited);
                    }
                }
            }

            LinkedList<String> childs_sig = new LinkedList<>(); 
            for(int child : adjList[node]){
                if(childs.contains(child)){
                    childs_sig.add(signatures[child]);
                }
            }

            Collections.sort(childs_sig);
            
            // node_sig = 1 + (concat(child_sig)) + 0
            StringBuilder node_sig_buffer = new StringBuilder();
            node_sig_buffer.append("1");
            // concat(child_sig)
            for(String child_sig : childs_sig){
                node_sig_buffer.append(child_sig);
            }
            node_sig_buffer.append("0");

            String node_sig = node_sig_buffer.toString();

            signatures[node] = node_sig;
        }


    }



    /*
     * Complete the jennysSubtrees function below.
     */
    static int jennysSubtrees(int n, int r, int[][] edges) {
        Graph graph = new Graph(n);

        for(int[] edge : edges){
            graph.addEdge(edge[0], edge[1]);
        }

        HashSet<String> signatures = new HashSet<>();

        for(int i=1;i<=n;i++){
            Graph subtree = graph.create_subtree(i, r);

            String subtree_signature = subtree.generate_signature();
            signatures.add(subtree_signature);
        }


        return signatures.size();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String[] nr = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nr[0].trim());

        int r = Integer.parseInt(nr[1].trim());

        int[][] edges = new int[n-1][2];

        for (int edgesRowItr = 0; edgesRowItr < n-1; edgesRowItr++) {
            String[] edgesRowItems = scanner.nextLine().split(" ");

            for (int edgesColumnItr = 0; edgesColumnItr < 2; edgesColumnItr++) {
                int edgesItem = Integer.parseInt(edgesRowItems[edgesColumnItr].trim());
                edges[edgesRowItr][edgesColumnItr] = edgesItem;
            }
        }

        int result = jennysSubtrees(n, r, edges);

        System.out.println(result);
    }
}
