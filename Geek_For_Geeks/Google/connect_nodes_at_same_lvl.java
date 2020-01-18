// https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1

/*class Node
{
    int data;
    Node left, right, nextRight;
    Node(int x)
    {
        this.data = x;
        left = right = nextRight = null;
    }
    
    
}*/
class Level
{
    static void connect(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        // to mark end of this level
        q.add(null);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            
            if(curr != null){
                curr.nextRight = q.peek();
                
                if(curr.left!=null){
                    q.add(curr.left);
                }
                if(curr.right!=null){
                    q.add(curr.right);
                }
            }else if(!q.isEmpty()){
                // to mark end of this lvl
                q.add(null);
            }
        }
        
    }
}