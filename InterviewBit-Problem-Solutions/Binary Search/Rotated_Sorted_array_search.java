/**
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7  might become 4 5 6 7 0 1 2 ).

You are given a target value to search. If found in the array, return its index, otherwise return -1.

You may assume no duplicate exists in the array.

**/


public class Solution {
	// DO NOT MODIFY THE LIST
	public int search(final List<Integer> a, int b) {
	    int i=0;
	    int j = a.size()-1;
	    
	    // find pivot
        while(i < j){
	        int mid = (i+j)/2;
	        if(a.get(j) < a.get(mid)){
                i = mid + 1;
            }else if(a.get(j) > a.get(mid)){
                j = mid;
            } 
	    }
	   // System.out.println(i+" "+j);
	   
        if(b >= a.get(i) && b <= a.get(a.size()-1)){
           // result present in right part
           j = a.size()-1;
        }else{
           //result present in left part
           j = i - 1;
           i = 0;
        }
	   
	   
	    boolean found =  false;
        int mid = 0;
        // search in respective part
        while(i<=j){
            mid=(i+j)/2;
            if(a.get(mid) == b){
                found=true;
                break;
            }else if(a.get(mid) < b){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
	    
	    if(found){
	        return mid;
	    }else{
	        return -1;
	    }
	}
}

