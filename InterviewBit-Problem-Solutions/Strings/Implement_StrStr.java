/***
Implement StrStr


strstr - locate a substring ( needle ) in a string ( haystack ). 
Try not to use standard library string functions for this question.

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

***/


// KMP algorithm O(n) complexity
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        if(A.length() == 0 || B.length() == 0){
            return -1;
        }
        
        // lps stands for longest prefix suffix
        //  lps[i] could also be defined as longest prefix which is also proper suffix.
        int[] lps = new int[B.length()];
        
        int i = 1;
        int j = 0;
        
        while(i < B.length()){
            if(B.charAt(i) != B.charAt(j)){
                if(j == 0){
                    lps[i] = 0;
                    i++;
                }else{
                    j = lps[j - 1];
                    // note that we don't increament i over here
                }
            }else{  // B.charAt(i) != B.charAt(j)
                j++;
                lps[i] = j;
                i++;
            }
        }
        
        // System.out.println(Arrays.toString(lps));
        boolean found = false;
        
        // use lps to locate the substring
        i=0;
        j=0;
        
        int N = A.length();
        int M = B.length();
        
        while (i < N) { 
            if (B.charAt(j) == A.charAt(i)) { 
                j++; 
                i++; 
            } 
            if (j == M) { 
                // System.out.println("Found pattern "+ "at index " + (i - j));
                found = true;
                break;
            } 

            // mismatch after j matches 
            else if (i < N && B.charAt(j) != A.charAt(i)) { 
                // Do not match lps[0..lps[j-1]] characters, 
                // they will match anyway 
                if (j != 0) 
                    j = lps[j - 1]; 
                else
                    i = i + 1; 
            } 
        } 
        
        if(found){
            if(B.length() == 1){
                return 0;
            }else{
                // return i - B.length() + 1;
                return i-j;
            }
        }else{
            return -1;
        }
    }
}


// Naive Method O(M*N) complexity
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int strStr(final String A, final String B) {
        if(A.length() == 0 || B.length() == 0){
            return -1;
        }
        int curr_B = 0;
        boolean found = false;
        int i = 0;
        for(;i < A.length(); i++){
            if(B.charAt(curr_B) == A.charAt(i)){
                if(curr_B == B.length() - 1){
                    found = true;
                    break;
                }
                curr_B ++;
            }else{
                if(curr_B > 0){
                    // reset curr_B to handle the shift
                    i = i - curr_B;
                }
                curr_B = 0;
            }
        }
        
        if(found){
            return i - B.length() + 1;
        }else{
            return -1;
        }
    }
}

