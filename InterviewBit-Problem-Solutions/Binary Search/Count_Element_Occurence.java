/***
Given a sorted array of integers, find the number of occurrences of a given target value.
Your algorithm’s runtime complexity must be in the order of O(log n).
If the target is not found in the array, return 0

**Example : **
Given [5, 7, 7, 8, 8, 10] and target value 8,
return 2.
***/

// LOGIC --- USE 2 binary search, first to get the start and then to get the last

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int findCount(final List<Integer> A, int B) {
        // calculate first occurance of B
        int start_idx_B = -1;
        int low = 0;
        int high = A.size() - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(A.get(mid) == B){
                start_idx_B = mid;
                high = mid - 1;
            }else if(A.get(mid) < B){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        
        if(start_idx_B == -1){
            // no occurance found
            return 0;
        }
        
        // calculate last occurance of B
        int last_index_B = start_idx_B;
        low = start_idx_B;
        high = A.size() - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(A.get(mid) == B){
                last_index_B = mid;
                low = mid + 1;
            }else if(A.get(mid) < B){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return last_index_B - start_idx_B + 1;
    }
}
