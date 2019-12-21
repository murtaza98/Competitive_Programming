package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){

			int n=Integer.parseInt(br.readLine().trim());
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);








		// convert arraylist to array
		missing.stream().mapToInt(Integer::intValue).toArray();

		// sort array of primitive in descending order
		Arrays.stream(arr).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();       

		// sorting comparator 
		Collections.sort(studentList,  Comparator.comparing(Student :: getCgpa).reversed().
              thenComparing(Student :: getFname).thenComparing(Student :: getId));








		int[] tmp= Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    
	    int r = tmp[0];
	    int c = tmp[1];
	    
	    int[][] map = new int[r][c];
	    
	    {
	        int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
	        
	        int arr_c = 0;
	        for(int i=0;i<r;i++){
	            for(int j=0;j<c;j++){
	                map[i][j] = arr[arr_c++];
	            }
	        }
	    }





	    PriorityQueue<ListNode> q = new PriorityQueue<>(Comparator.comparingInt(x -> x.val));






	    static class Point{
        int x, y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int hashCode(){
            return this.x+this.y;
        }

        @Override
        public boolean equals(Object o){
            if(this==o){
                return true;
            }
            if(!(o instanceof Point)){
                return false;
            }

            Point oo = (Point)o;

            return this.x==oo.x && this.y==oo.y; 
        }

        public String toString(){
            return this.x + "," + this.y;
        }
    }









	    // C++ sample
	    #include<bits/stdc++.h>
		using namespace std;
		int main()
		 {

			  //Takes no of test cases
		      int t;
		      cin>>t;
		      while(t--)
		      {
		      /*read inputs*/
		      int n;
		      cin>>n;
		      /*to read an array  */
		      int a[n];
		      for(int i=0;i<n;i++)
		      cin>>a[i];
		      
		      /*Your logic */
		      
		      }
			return 0;
		}



		// MODULAR ADDITION AND MULTIPLICATION
		static long mod_multiply(long a, long b){
	        int mod = 1000000007;
	        return (long)((a%mod)*(b%mod))%mod;
	    }
	    
	    static long mod_add(long a, long b){
	        int mod = 1000000007;
	        return (long)((a%mod)+(b%mod))%mod;
	    }








	    class Graph{
    LinkedList<Integer> adjList[];

    Graph(int n){
        adjList = new LinkedList[n+1];
        for(int i=1;i<=n;i++){
            adjList[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int from, int to){
        adjList[from].add(to);
    }

    public int bfs_traversal(int root){
        HashSet<Integer> visited = new HashSet<>();
        int nodes_count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        visited.add(root);
        nodes_count++;

        while(q.size()>0){
            int curr = q.poll();

            for(int child : adjList[curr]){
                if(!visited.contains(child)){
                    visited.add(child);
                    q.add(child);
                    nodes_count++;
                }
            }
        }
        return nodes_count;
    }
}








class Trie{
    Node root;

    Trie(){
        root = new Node();
    }

    void insert(String s){
        Node curr = root;
        for(char c : s.toCharArray()){
            int c_idx = c - 'a';
            if(curr.childs[c_idx] == null){
                curr.childs[c_idx] = new Node();
            }
            curr.childs[c_idx].freq +=  1;
            curr = curr.childs[c_idx];
        }
        curr.isEnd = true;
    }

    int search(String s){
        Node curr = root;
        for(char c : s.toCharArray()){
            int c_idx = c - 'a';
            if(curr.childs[c_idx] == null){
                return 0;
            }
            curr = curr.childs[c_idx];
        }
        return curr.freq;
    }
}

class Node{
    int ALPHABET_SIZE = 26;
    Node[] childs;
    int freq;
    boolean isEnd;

    Node(){
        childs = new Node[ALPHABET_SIZE];
        for(int i=0;i<ALPHABET_SIZE;i++){
            childs[i] = null;
        }
        freq = 0;
        isEnd = false;
    }
}









		
		while(t>0){
		    int n=Integer.parseInt(br.readLine());
		    
		    int[] arr = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
		    
		    for(int i=0;i<arr.length-1;i++){
		        if(arr[i]>arr[i+1]){
		            sb.append(arr[i+1]+" ");
		        }else{
		            sb.append(-1+" ");
		        }
		    }
		    //  last element
		    sb.append(-1);
		    t--;
		    if(t>0){
		        sb.append("\n");
		    }
		}
		
		System.out.println(sb);
	}
}

import java.io.*;
import java.util.*;


public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            int N = Integer.parseInt(br.readLine().trim());

            long out_ = CountWays(N);
            System.out.println(out_);
           
         }

         wr.close();
         br.close();
    }
    
    static long CountWays(int N){
        // Write your code here
        
        HashMap<Integer, Long> xy = new HashMap<>();
        for(int x=1;x<=N;x++){
            for(int y=1;y<=N;y++){
                int key = x+y;
                if(!xy.containsKey(key)){
                    xy.put(key, (long)0);
                }
                xy.put(key, (long)xy.get(key)+1);
            }
        }
        
        HashMap<Integer, Long> occ = new HashMap<>();
        for(int z=1;z<=N;z++){
            Iterator<Map.Entry<Integer, Long>> iter =  xy.entrySet().iterator();
            while(iter.hasNext()){
                Map.Entry<Integer, Long> entry = iter.next();
                int key = 2*z + entry.getKey();
                if(!occ.containsKey(key)){
                    occ.put(key, entry.getValue());
                }else{
                    occ.put(key, occ.get(key) + entry.getValue());
                }
            }
        }
        
        // Iterator<Map.Entry<Integer, Long>> iter1 =  occ.entrySet().iterator();
        // while(iter1.hasNext()){
        //     Map.Entry<Integer, Long> entry = iter1.next();
        //     System.out.printf("%d %d\n", entry.getKey(), entry.getValue());
        // }
        
        
        
        long ways = 0;
        
        Iterator<Map.Entry<Integer, Long>> iter =  occ.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Integer, Long> entry = iter.next();
            
            ArrayList<Integer> divisors = find_divisors(entry.getKey());
            
            for(int div : divisors){
                if(occ.containsKey(div)){
                    ways += entry.getValue() * occ.get(div);
                }
            }
        }
        
        return ways;
    }
    
    static ArrayList<Integer> find_divisors(int n){
        ArrayList<Integer> divisors = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i == 0){
                if(n/i == i){
                    divisors.add(i);
                }else{
                    divisors.add(i);
                    divisors.add(n/i);
                }
            }
        }
        return divisors;
    }
}

