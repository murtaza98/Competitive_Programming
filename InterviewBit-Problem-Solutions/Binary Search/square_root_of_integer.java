/**
Implement int sqrt(int x).

Compute and return the square root of x.

If x is not a perfect square, return floor(sqrt(x))

**/


public class Solution {
    public int sqrt(int x) {
        // Base Cases 
        if (x == 0 || x == 1) 
            return x; 
  
        // Do Binary Search for floor(sqrt(x)) 
        int start = 1, end = x, ans=0; 
        while (start <= end) 
        { 
            long mid = (start + end) / 2; 
            // System.out.println(mid+"");
  
            // If x is a perfect square 
            if (mid*mid == (long)x) 
                return (int)mid; 
  
            // Since we need floor, we update answer when mid*mid is 
            // smaller than x, and move closer to sqrt(x) 
            if (mid*mid < (long)x) 
            { 
                start = (int)mid + 1; 
                ans = (int)mid; 
            } 
            else   // If mid*mid is greater than x 
                end = (int)mid-1; 
        } 
        return ans; 
    }
}

