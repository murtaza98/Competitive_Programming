/**
Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

Example:

Given s = "Hello World",

return 5 as length("World") = 5
**/



public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int lengthOfLastWord(final String A) {
        
        int i = A.length() - 1;
        int len = 0;
        
        // eliminate spaces at back
        while(i >= 0 && A.charAt(i) == ' '){
            i--;
        }
        
        if(i < 0){
            return 0;
        }
        
        while(i >= 0){
            if(A.charAt(i) == ' '){
                break;
            }
            len++;
            i--;
        }
        return len;
        
    }
}

