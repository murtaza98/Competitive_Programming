import java.util.*;
import java.lang.*;

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
        public int WordID;
        
        Vertex()
        {
            Children = new Hashtable<>();            
            Leaf = false;
            Parent = -1;
            SuffixLink = -1;
            WordID = -1;
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
    
    public void AddString(String s, int wordID)
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
        Trie.get(curVertex).WordID = wordID;
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

    public ArrayList<Integer> ProcessString(String text)
    {
        // Current state value
        int currentState = root;

        // Targeted result value
        int result = 0;     // count of no of matched patterns
        ArrayList<Integer> indexes = new ArrayList<>();

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
                indexes.add(Trie.get(checkState).WordID);
                int indexOfMatch = j + 1 - WordsLength.get(Trie.get(checkState).WordID);
        
                // Trying to find all matched patterns of smaller length
                checkState = Trie.get(checkState).SuffixLink;
            }
        }

        return indexes;
    }
}



public class aho_corasick {
    public static void main(String[] args){
        String text = "caaab";
        String[] patterns = {"b", "c", "aa", "d", "b"};

        Aho ahoAlg = new Aho();

        for (int i = 0; i < patterns.length; i++)
        {
            ahoAlg.AddString(patterns[i], i); // Add all patterns to the structure
        }
        // Prepare algorithm for work (calculates all links in the structure):
        ahoAlg.PrepareAho();

        // Process the text. Output might be different; in my case, it's a count of
        // matches. We could instead return a structure with more detailed information.
        ArrayList<Integer> patternMatches = ahoAlg.ProcessString(text);

        System.out.println(Arrays.toString(patternMatches.toArray()));
    }
}