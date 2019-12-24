import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class determining_dna_health {
    public static void main(String[] args) {
        FastReader ip = new FastReader();
        StringBuilder sb = new StringBuilder();

        int n = ip.nextInt();

        String[] genes = new String[n];
        int[] health = new int[n];

        for(int i=0;i<n;i++){
            genes[i] = ip.next().trim();
        }
        for(int i=0;i<n;i++){
            health[i] = ip.nextInt();
        }

        long startTime = System.nanoTime();
        Aho ahoAlg = new Aho();

        for(int i=0;i<n;i++){
            ahoAlg.AddString(genes[i], i, health[i]);
        }
        ahoAlg.PrepareAho();
        long endTime   = System.nanoTime();
        long totalTime1 = endTime - startTime;

        System.out.println(TimeUnit.NANOSECONDS.toSeconds(totalTime1));


        long totalTime2 = 0, totalTime3 = 0;

        long min_health = Integer.MAX_VALUE;
        long max_health = Integer.MIN_VALUE;

        int s = ip.nextInt();

        while(s-- > 0){
            int start = ip.nextInt();
            int end = ip.nextInt();

            String d = ip.next().trim();

            startTime = System.nanoTime();
            // ArrayList<Integer> match_idx = ahoAlg.ProcessString(d);
            long curr_health = ahoAlg.ProcessString(d, start, end);
            
            endTime = System.nanoTime();

            totalTime2 += endTime - startTime;

            
            startTime = System.nanoTime();


            // to handle duplicate genes
            // HashMap<String, Integer> match_genes = new HashMap<>();
            // for(int idx :  match_idx){
            //     if(idx>=start && idx<=end){
            //         String gene = genes[idx];
            //         if(match_genes.containsKey(gene)){
            //             match_genes.put(gene, match_genes.get(gene) + 1);
            //         }else{
            //             match_genes.put(gene, 1);
            //         }
            //     }
            // }

            // long curr_health = 0;

            // // System.out.println(Arrays.toString(match_idx.toArray()));

            // for(int idx=start; idx<=end; idx++){
            //     String gene = genes[idx];
            //     if(match_genes.containsKey(gene)){
            //         int gene_occ = match_genes.get(gene);
            //         curr_health += health[idx] * gene_occ;
            //     }
            // }

            min_health = Math.min(curr_health, min_health);
            max_health = Math.max(curr_health, max_health);


            endTime = System.nanoTime();

            totalTime3 += endTime - startTime;
        }

        System.out.printf("%d %d\n", min_health, max_health);
        System.out.println(TimeUnit.NANOSECONDS.toSeconds(totalTime2));
        System.out.println(TimeUnit.NANOSECONDS.toSeconds(totalTime3));
    }
}

class FastReader { 
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


class Aho {
    static class Vertex 
    {
        // Links to the child vertexes in the trie:
        // Key: A single character
        // Value: The ID of vertex
        public Hashtable<Character, Integer> Children;
    
        // Flag that some word from the dictionary ends in this vertex
        public boolean Leaf;
    
        // Link to the parent vertex
        public int Parent;
    
        // Char which moves us from the parent vertex to the current vertex
        public char ParentChar;
    
        // Suffix link from current vertex (the equivalent of P[i] from the KMP algorithm)
        public int SuffixLink;
    
        // Link to the leaf vertex of the maximum-length word we can make from the current prefix
        public int EndWordLink;
    
        // If the vertex is the leaf, we store the ID of the word
        public ArrayList<Integer> WordID;

        // store health
        public long health;
        
        Vertex()
        {
            Children = new Hashtable<>();            
            Leaf = false;
            Parent = -1;
            SuffixLink = -1;
            WordID = new ArrayList<>();
            health = 0;
            EndWordLink= -1;
        }
    }

	List<Vertex> Trie;
	List<Integer> WordsLength;
	int size = 0;
	int root = 0;

	public Aho()
	{
		Trie = new ArrayList<Vertex>();
		WordsLength = new ArrayList<Integer>();
		Init();
	}

	private void Init()
	{
		Trie.add(new Vertex());            
		size++;
    }
    
    public void AddString(String s, int wordID, long geneHealth)
    {
        int curVertex = root;
        for (int i = 0; i < s.length(); ++i) // Iterating over the string's characters
        {
            char c = s.charAt(i);

            // Checking if a vertex with this edge exists in the trie:
            if (!Trie.get(curVertex).Children.containsKey(c))
            {
                // If not - add vertex
                Trie.add(new Vertex());
                
                Trie.get(size).SuffixLink = -1;
                Trie.get(size).Parent = curVertex;
                Trie.get(size).ParentChar = c;
                Trie.get(curVertex).Children.put(c, size);
                size++;
            }
            curVertex = (int)Trie.get(curVertex).Children.get(c); // Move to the new vertex in the trie
        }
        // Mark the end of the word and store its ID
        Trie.get(curVertex).Leaf = true;
        Trie.get(curVertex).WordID.add(wordID);
        Collections.sort(Trie.get(curVertex).WordID);
        Trie.get(curVertex).health += geneHealth;
        WordsLength.add(s.length());
    }

    public void PrepareAho()
    {
        Queue<Integer> vertexQueue = new LinkedList<>();
        vertexQueue.add(root);
        while (vertexQueue.size() > 0)
        {
            int curVertex = vertexQueue.poll();
            CalcSuffLink(curVertex);

            for(char key : Trie.get(curVertex).Children.keySet()){
                vertexQueue.add((int)Trie.get(curVertex).Children.get(key));
            }
        }
    }

    // helper function to calculate suffix link
    public void CalcSuffLink(int vertex)
    {
        // Processing root (empty string)
        if (vertex == root)
        { 
            Trie.get(vertex).SuffixLink = root;
            Trie.get(vertex).EndWordLink = root;
            return;
        }
        // Processing children of the root (one character substrings)
        if (Trie.get(vertex).Parent == root)
        { 
            Trie.get(vertex).SuffixLink = root;
            if (Trie.get(vertex).Leaf) Trie.get(vertex).EndWordLink = vertex;
            else Trie.get(vertex).EndWordLink = Trie.get(Trie.get(vertex).SuffixLink).EndWordLink;
            return;
        }
        // Cases above are degenerate cases as for prefix function calculation; the
        // value is always 0 and links to the root vertex.

        // To calculate the suffix link for the current vertex, we need the suffix
        // link for the parent of the vertex and the character that moved us to the
        // current vertex.
        int curBetterVertex = Trie.get(Trie.get(vertex).Parent).SuffixLink;
        char chVertex = Trie.get(vertex).ParentChar; 
        // From this vertex and its substring we will start to look for the maximum
        // prefix for the current vertex and its substring.
        
        while (true)
        {
            // If there is an edge with the needed char, we update our suffix link
            // and leave the cycle
            if (Trie.get(curBetterVertex).Children.containsKey(chVertex))
            {
                    Trie.get(vertex).SuffixLink = (int)Trie.get(curBetterVertex).Children.get(chVertex);
                    break;
            }
            // Otherwise, we are jumping by suffix links until we reach the root
            // (equivalent of k == 0 in prefix function calculation) or we find a
            // better prefix for the current substring.
            if (curBetterVertex == root)
            { 
                    Trie.get(vertex).SuffixLink = root;
                    break;
            }
            curBetterVertex = Trie.get(curBetterVertex).SuffixLink; // Go back by sufflink
        }
        // When we complete the calculation of the suffix link for the current
        // vertex, we should update the link to the end of the maximum length word
        // that can be produced from the current substring.
        if (Trie.get(vertex).Leaf) Trie.get(vertex).EndWordLink = vertex; 
        else Trie.get(vertex).EndWordLink = Trie.get(Trie.get(vertex).SuffixLink).EndWordLink;
    }

    public long ProcessString(String text, int start, int end)
    {
        // Current state value
        int currentState = root;

        // Targeted result value
        int result = 0;     // count of no of matched patterns
        ArrayList<Integer> indexes = new ArrayList<>();
        long total_health = 0;

        for (int j = 0; j < text.length(); j++)
        {
            // Calculating new state in the trie
            while (true)
            {
                // If we have the edge, then use it
                if (Trie.get(currentState).Children.containsKey(text.charAt(j)))
                {
                    currentState = (int)Trie.get(currentState).Children.get(text.charAt(j));
                    break;
                }
                // Otherwise, jump by suffix links and try to find the edge with
                // this char

                // If there aren't any possible edges we will eventually ascend to
                // the root, and at this point we stop checking.
                if (currentState == root) break;
                currentState = Trie.get(currentState).SuffixLink;
            }
            int checkState = currentState;

            // Trying to find all possible words from this prefix
            while (true)
            { 
                // Checking all words that we can get from the current prefix
                checkState = Trie.get(checkState).EndWordLink;

                // If we are in the root vertex, there are no more matches
                if (checkState == root) break;
                
                // If the algorithm arrived at this row, it means we have found a
                // pattern match. And we can make additional calculations like find
                // the index of the found match in the text. Or check that the found
                // pattern is a separate word and not just, e.g., a substring.
                result++;
                ArrayList<Integer> wordIds = Trie.get(checkState).WordID;
                if(withinRangeSorted(wordIds, start, end+1)){
                    total_health += Trie.get(checkState).health;
                } 
                // indexes.add(Trie.get(checkState).WordID);
                
                // int indexOfMatch = j + 1 - WordsLength.get(Trie.get(checkState).WordID);
        
                // Trying to find all matched patterns of smaller length
                checkState = Trie.get(checkState).SuffixLink;
            }
        }

        return total_health;
    }

    boolean withinRangeSorted (ArrayList<Integer> arr, int l, int u) {
        int start = 0;
        int end = arr.size();
        while (start < end) {
            int current = (start + end) / 2;
            if (arr.get(current) >= u) {
                end = current;
            } else if (arr.get(current) < l) {
                start = current + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}


