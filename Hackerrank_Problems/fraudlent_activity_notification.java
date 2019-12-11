import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class node { 
    int key; 
    node left; 
    node right; 
    int height; 
    int count; 
} 


class AVLTree { 
  
    node t_root;  

    int size;

    AVLTree(){
        t_root = null;
    }

    void insert_api(int key){
        this.t_root = insert(this.t_root, key);
        this.size++;
    }

    void delete_api(int key){
        this.t_root = deleteNode(this.t_root, key);
        this.size--;
    }

    node maxValueNode(node root)  
    {  
        node current = root;  
  
        /* loop down to find the leftmost leaf */
        while (current.right != null)  
        current = current.right;  
  
        return current;  
    }  

    int getMin(){
        if(this.t_root == null){
            return -1;
        }
        return minValueNode(this.t_root).key;
    }

    int getMax(){
        if(this.t_root == null){
            return -1;
        }
        return maxValueNode(this.t_root).key;
    }

    int size(){
        return this.size;
    }

    boolean contains(int target){
        node curr = t_root;
        while(curr!=null){
            if(curr.key == target){
                return true;
            }else if(curr.key < target){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
        return false;
    }
  
    // A utility function to get height of the tree 
    static int height(node N) 
    { 
        if (N == null) 
            return 0; 
        return N.height; 
    } 
  
    // A utility function to get maximum of two integers 
    static int max(int a, int b) 
    { 
        return (a > b) ? a : b; 
    } 
  
    /* Helper function that allocates a new node with the given key and  
    null left and right pointers. */
    static node newNode(int key) 
    { 
        node node = new node(); 
        node.key = key; 
        node.left = null; 
        node.right = null; 
        node.height = 1; // new node is initially added at leaf 
        node.count = 1; 
        return (node); 
    } 
  
    // A utility function to right rotate subtree rooted with y 
    // See the diagram given above. 
    static node rightRotate(node y) 
    { 
        node x = y.left; 
        node T2 = x.right; 
  
        // Perform rotation 
        x.right = y; 
        y.left = T2; 
  
        // Update heights 
        y.height = max(height(y.left), height(y.right)) + 1; 
        x.height = max(height(x.left), height(x.right)) + 1; 
  
        // Return new root 
        return x; 
    } 
  
    // A utility function to left rotate subtree rooted with x 
    // See the diagram given above. 
    static node leftRotate(node x) 
    { 
        node y = x.right; 
        node T2 = y.left; 
  
        // Perform rotation 
        y.left = x; 
        x.right = T2; 
  
        // Update heights 
        x.height = max(height(x.left), height(x.right)) + 1; 
        y.height = max(height(y.left), height(y.right)) + 1; 
  
        // Return new root 
        return y; 
    } 
  
    // Get Balance factor of node N 
    static int getBalance(node N) 
    { 
        if (N == null) 
            return 0; 
        return height(N.left) - height(N.right); 
    } 
  
    static node insert(node node, int key) 
    { 
        /*1.  Perform the normal BST rotation */
        if (node == null) 
            return (newNode(key)); 
  
        // If key already exists in BST, increment count and return 
        if (key == node.key) { 
            (node.count)++; 
            return node; 
        } 
  
        /* Otherwise, recur down the tree */
        if (key < node.key) 
            node.left = insert(node.left, key); 
        else
            node.right = insert(node.right, key); 
  
        /* 2. Update height of this ancestor node */
        node.height = max(height(node.left), height(node.right)) + 1; 
  
        /* 3. Get the balance factor of this ancestor node to check whether  
       this node became unbalanced */
        int balance = getBalance(node); 
  
        // If this node becomes unbalanced, then there are 4 cases 
  
        // Left Left Case 
        if (balance > 1 && key < node.left.key) 
            return rightRotate(node); 
  
        // Right Right Case 
        if (balance < -1 && key > node.right.key) 
            return leftRotate(node); 
  
        // Left Right Case 
        if (balance > 1 && key > node.left.key) { 
            node.left = leftRotate(node.left); 
            return rightRotate(node); 
        } 
  
        // Right Left Case 
        if (balance < -1 && key < node.right.key) { 
            node.right = rightRotate(node.right); 
            return leftRotate(node); 
        } 
  
        /* return the (unchanged) node pointer */
        return node; 
    } 
  
    /* Given a non-empty binary search tree, return the node with minimum  
   key value found in that tree. Note that the entire tree does not  
   need to be searched. */
    static node minValueNode(node node) 
    { 
        node current = node; 
  
        /* loop down to find the leftmost leaf */
        while (current.left != null) 
            current = current.left; 
  
        return current; 
    } 
  
    static node deleteNode(node root, int key) 
    { 
        // STEP 1: PERFORM STANDARD BST DELETE 
  
        if (root == null) 
            return root; 
  
        // If the key to be deleted is smaller than the root's key, 
        // then it lies in left subtree 
        if (key < root.key) 
            root.left = deleteNode(root.left, key); 
  
        // If the key to be deleted is greater than the root's key, 
        // then it lies in right subtree 
        else if (key > root.key) 
            root.right = deleteNode(root.right, key); 
  
        // if key is same as root's key, then This is the node 
        // to be deleted 
        else { 
            // If key is present more than once, simply decrement 
            // count and return 
            if (root.count > 1) { 
                (root.count)--; 
                return null; 
            } 
            // ElSE, delete the node 
  
            // node with only one child or no child 
            if ((root.left == null) || (root.right == null)) { 
                node temp = root.left != null ? root.left : root.right; 
  
                // No child case 
                if (temp == null) { 
                    temp = root; 
                    root = null; 
                } 
                else // One child case 
                    root = temp; // Copy the contents of the non-empty child 
            } 
            else { 
                // node with two children: Get the inorder successor (smallest 
                // in the right subtree) 
                node temp = minValueNode(root.right); 
  
                // Copy the inorder successor's data to this node and update the count 
                root.key = temp.key; 
                root.count = temp.count; 
                temp.count = 1; 
  
                // Delete the inorder successor 
                root.right = deleteNode(root.right, temp.key); 
            } 
        } 
  
        // If the tree had only one node then return 
        if (root == null) 
            return root; 
  
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE 
        root.height = max(height(root.left), height(root.right)) + 1; 
  
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether 
        // this node became unbalanced) 
        int balance = getBalance(root); 
  
        // If this node becomes unbalanced, then there are 4 cases 
  
        // Left Left Case 
        if (balance > 1 && getBalance(root.left) >= 0) 
            return rightRotate(root); 
  
        // Left Right Case 
        if (balance > 1 && getBalance(root.left) < 0) { 
            root.left = leftRotate(root.left); 
            return rightRotate(root); 
        } 
  
        // Right Right Case 
        if (balance < -1 && getBalance(root.right) <= 0) 
            return leftRotate(root); 
  
        // Right Left Case 
        if (balance < -1 && getBalance(root.right) > 0) { 
            root.right = rightRotate(root.right); 
            return leftRotate(root); 
        } 
  
        return root; 
    } 
  
    // A utility function to print preorder traversal of the tree. 
    // The function also prints height of every node 
    static void preOrder(node root) 
    { 
        if (root != null) { 
            System.out.printf("%d(%d) ", root.key, root.count); 
            preOrder(root.left); 
            preOrder(root.right); 
        } 
    } 
} 


public class fraudlent_activity_notification {

    // Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {

        int fraud_notifications = 0;

        AVLTree left_side = new AVLTree();
        AVLTree right_side = new AVLTree();

        int n = 0;

        for(int i=0;i<d;i++){
            int to_add = expenditure[i];

            if(n%2 == 0){
                if(n==0){
                    left_side.insert_api(to_add);
                }else if(to_add <= right_side.getMin()){
                    left_side.insert_api(to_add);
                }else if(to_add > right_side.getMin()){
                    // shift min of right to left and insert new ele in right
                    int rs_min = right_side.getMin();

                    right_side.delete_api(rs_min);
                    left_side.insert_api(rs_min);

                    right_side.insert_api(to_add);
                }
            }else{
                if(to_add >= left_side.getMax()){
                    right_side.insert_api(to_add);
                }else if(to_add < left_side.getMax()){
                    // shift max of left to right and insert new ele in left
                    int ls_max = left_side.getMax();

                    left_side.delete_api(ls_max);
                    right_side.insert_api(ls_max);

                    left_side.insert_api(to_add);
                }
            }
            n++;
        }



        for(int i=d;i<expenditure.length;i++){
            
            // calc median
            int to_add = expenditure[i];
            double median = 0;
            if(n%2==1){
                median = left_side.getMax();
            }else{
                median = (left_side.getMax()+right_side.getMin())/2.0;
            }

            // System.out.printf("median %f\n", median);

            if((double)to_add >= 2*median){
                fraud_notifications++;
            }


            // remove
            int to_remove = expenditure[i-d];
            if(n%2==1){
                left_side.delete_api(to_remove);
            }else{
                // move max from right to left
                left_side.delete_api(to_remove);
                int rs_max = right_side.getMax();
                right_side.delete_api(rs_max);
                left_side.insert_api(rs_max);
            }
            n--;

            // add new expense
            if(n%2 == 0){
                if(n==0){
                    left_side.insert_api(to_add);
                }else if(to_add <= right_side.getMin()){
                    left_side.insert_api(to_add);
                }else if(to_add > right_side.getMin()){
                    // shift min of right to left and insert new ele in right
                    int rs_min = right_side.getMin();

                    right_side.delete_api(rs_min);
                    left_side.insert_api(rs_min);

                    right_side.insert_api(to_add);
                }
            }else{
                if(to_add >= left_side.getMax()){
                    right_side.insert_api(to_add);
                }else if(to_add < left_side.getMax()){
                    // shift max of left to right and insert new ele in left
                    int ls_max = left_side.getMax();

                    left_side.delete_api(ls_max);
                    right_side.insert_api(ls_max);

                    left_side.insert_api(to_add);
                }
            }
            n++;
        }

        return fraud_notifications;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        System.out.println(result);

        // bufferedWriter.write(String.valueOf(result));
        // bufferedWriter.newLine();

        // bufferedWriter.close();

        scanner.close();
    }
}
