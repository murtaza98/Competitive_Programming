/*
Given an array A, of N integers A.

Return the highest product possible by multiplying 3 numbers from the array.

NOTE: Solution will fit in a 32-bit signed integer.



Input Format:

The first and the only argument is an integer array A.

Output Format:

Return the highest possible product.

Constraints:

1 <= N <= 5e5

Example:

Input 1:
A = [1, 2, 3, 4]

Output 1:
24

Explanation 1:
2 * 3 * 4 = 24

Input 2:
A = [0, -1, 3, 100, 70, 50]

Output 2:
350000

Explanation 2:
70 * 50 * 100 = 350000
*/

public class Solution {
    public int maxp3(ArrayList<Integer> A) {
        
        // run selection sort for the first 3 element. no need to get sort the whole array
        // custom_selection_sort(A, 3);
        
        Collections.sort(A);
        
        int highest_prod_pos = 1;
        for(int i=A.size()-1;i>=A.size()-3&&i>=0;i--){
            highest_prod_pos *= A.get(i);
        }
        
        boolean contains_2_neg = A.size()>2 ? A.get(0)<0 && A.get(1)<0 : false;
        
        int highest_prod_neg = Integer.MIN_VALUE;
        
        if(contains_2_neg){
            int prod_of_2_neg = A.get(0) * A.get(1);
            highest_prod_neg = prod_of_2_neg * A.get(A.size()-1);
        }
        
        return highest_prod_pos >= highest_prod_neg ? highest_prod_pos : highest_prod_neg;
    }
    
    static void custom_selection_sort(ArrayList<Integer> A, int sorted_len){
        for(int i=0;i<sorted_len&&i<A.size();i++){
            int max_ele = A.get(i);
            int max_idx = i;
            for(int j=i+1;j<A.size();j++){
                if(A.get(j)>max_ele){
                    max_ele = A.get(j);
                    max_idx = j;
                }
            }
            // swap i and max_idx
            int tmp = A.get(i);
            A.set(i, A.get(max_idx));
            A.set(max_idx, tmp);
        }
    }
}