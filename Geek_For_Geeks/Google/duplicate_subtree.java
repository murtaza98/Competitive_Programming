// https://practice.geeksforgeeks.org/problems/duplicate-subtree-in-binary-tree/1

/*node class of the binary tree
class Node
{
    char data;
    Node left, right;
    Node(char key)
    {
        data = key;
        left = right = null;
    }
}*/
class GfG
{
    static final char MARKER = '$';
    static Set<String> subtrees = new HashSet<String>();
    public static boolean dupSub(Node root)
    {
        subtrees.clear();
        
        String res = dupSubUtil(root);
        
        if(res.compareTo("") == 0){
            return true;
        }else{
            return false;
        }
    }
    
    public static String dupSubUtil(Node root)
    {
        
        if(root==null){
            // passed leaf node
            return ""+MARKER;
        }
        
        String lSt = dupSubUtil(root.left);
        if(lSt.compareTo("")==0){
            return "";
        }
        
        String rSt = dupSubUtil(root.right);
        if(rSt.compareTo("")==0){
            return "";
        }
        
        String s = root.data+lSt+rSt;
        
        if(s.length()>3 && subtrees.contains(s)){
            // dup subtree found
            return "";
        }
        
        subtrees.add(s);
        
        return s;
    }
}