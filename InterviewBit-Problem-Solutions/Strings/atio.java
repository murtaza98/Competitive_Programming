/**
Implement atoi to convert a string to an integer.

Example :

Input : "9 2704"
Output : 9
Note: There might be multiple corner cases here. Clarify all your doubts using “See Expected Output”.

 Questions: Q1. Does string contain whitespace characters before the number?
A. Yes Q2. Can the string have garbage characters after the number?
A. Yes. Ignore it. Q3. If no numeric character is found before encountering garbage characters, what should I do?
A. Return 0. Q4. What if the integer overflows?
A. Return INT_MAX if the number is positive, INT_MIN otherwise. 
**/



public class Solution {
	public int atoi(final String A) {
	    int idx;
	    long num;
	    int n = A.length();
	    boolean sign = true;
	    
	    idx = 0;
	    
	    while (idx < n && A.charAt(idx) == ' ')
	        idx++;
	        
	    if (idx == n)
	        return 0;
	    
	    if (A.charAt(idx) == '-') {
	        sign = false;
	        idx++;
	    } else if (A.charAt(idx) == '+') {
	        idx++;
	    }
	    
	    num = 0;
	    
	    while (idx < n && A.charAt(idx) >= '0' && A.charAt(idx) <= '9') {
	        
	        num = Math.abs(num);
	        num = num * 10 + A.charAt(idx) - '0';
	        
	        if (!sign)
	            num = -num;
	        
	        if (num > Integer.MAX_VALUE)
	            return Integer.MAX_VALUE;
	            
	        else if (num < Integer.MIN_VALUE)
	            return Integer.MIN_VALUE;
	            
	        idx++;
	            

	    }
	    
	    return (int) num;
	    
	}
}
