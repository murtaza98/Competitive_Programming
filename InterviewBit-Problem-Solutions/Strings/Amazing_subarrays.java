/***
You are given a string S, and you have to find all the amazing substrings of S.

Amazing Substring is one that starts with a vowel (a, e, i, o, u, A, E, I, O, U).

Input

Only argument given is string S.
Output

Return a single integer X mod 10003, here X is number of Amazing Substrings in given string.
Constraints

1 <= length(S) <= 1e6
S can have special characters
Example

Input
    ABEC

Output
    6

Explanation
	Amazing substrings of given string are :
	1. A
	2. AB
	3. ABE
	4. ABEC
	5. E
	6. EC
	here number of substrings are 6 and 6 % 10003 = 6.
***/

public class Solution {
    public int solve(String A) {
        ArrayList<Character> vowels = Arrays.asList(array);
        int subarray = 0;
        for(int i = 0;i < A.length(); i++){
            char curr_char = A.charAt(i);
            if(checkIfVowel(curr_char)){
                subarray += A.length() - i;
            }
        }
        return subarray;
    }
    
    boolean checkIfVowel(char alphabet){
        char[] vowels = {'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'};
        for(char c : vowels){
            if(alphabet == c){
                return true;
            }
        }
        return false;
    }
    
}

