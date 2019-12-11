/***
Write a function to find the longest common prefix string amongst an array of strings.

Longest common prefix for a pair of strings S1 and S2 is the longest string S which is the prefix of both S1 and S2.

As an example, longest common prefix of "abcdefgh" and "abcefgh" is "abc".

Given the array of strings, you need to find the longest S which is the prefix of ALL the strings in the array.

Example:

Given the array as:

[

  "abcdefgh",

  "aefghijk",

  "abcefgh"
]
The answer would be “a”.
***/
public class Solution {
    public String longestCommonPrefix(ArrayList<String> A) {
        int min_idx = getMinLength(A);
        String min_string = A.get(min_idx);
        // remove min_len_string from arraylist
        A.remove(min_idx);
        
        int last_idx = min_string.length() - 1;

        for(int i=0;i<A.size();i++){
            int j = 0;
            for(;j<=last_idx;j++){
                if(min_string.charAt(j) != A.get(i).charAt(j)){
                    break;
                }
            }
            last_idx = j - 1;
            
            if(j == 0){
                // none matched
                return "";
            }
        }
        
        return min_string.substring(0, last_idx+1);
    }
    
    int getMinLength(ArrayList<String> A){
        int min_idx = 0;
        int min_length = A.get(0).length();
        
        for(int i = 0;i< A.size();i++){
            if(A.get(i).length() < min_length){
                min_idx = i;
                min_length = A.get(i).length();
            }
        }
        
        return min_idx;
    }
}

