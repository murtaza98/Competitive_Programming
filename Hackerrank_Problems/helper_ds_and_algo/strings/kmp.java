import java.util.*;
import java.lang.*;
import java.io.*;

class kmp {
	public static void main (String[] args) throws Exception {
        
        String text = "aaabaaa";
        String pattern = "aabaa";

        int[] lps = calc_lps(pattern);      // longest prefix that is also a suffix

        int t_i = 0;    // text_index
        int p_i = 0;    // pattern_index
        boolean found = false;

        while(t_i < text.length()){
            if(text.charAt(t_i) == pattern.charAt(p_i)){
                t_i++;
                p_i++;
                if(p_i == pattern.length()){
                    found = true;
                    break;
                }
            }else{      // chars not equal
                if(p_i != 0){
                    p_i = lps[p_i-1];
                }else{
                    t_i++;
                }
            }
        }

        // System.out.println(Arrays.toString(lps));
        System.out.println("Pattern " + (found ? "" : "Not ") + "Found");
    }
    
    static int[] calc_lps(String pattern){
        int l=0;
        int r=1;

        int n = pattern.length();
        int[] lps = new int[n];

        while(r < n) {
            if(pattern.charAt(l) == pattern.charAt(r)){
                lps[r] = lps[r-1] + 1;
                l++;
                r++;
            }else{
                while(l != 0 && pattern.charAt(l) != pattern.charAt(r)){
                    l = lps[l-1];
                }
                if(l == 0){
                    lps[r] = 0; 
                }else{
                    lps[r] = lps[l-1] + 1;
                }
                r++;
            }
        }

        return lps;
    }
}
