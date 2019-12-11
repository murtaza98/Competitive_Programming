/*
Given a string S consisting of lowercase latin letters, arrange all its letters in lexographical order using Counting Sort.

Input Format:
The first line of the input contains T denoting number of testcases.Then T test cases follow. Each testcase contains positive integer N denoting the length of string.The last line of input contains the string S.

Output Format:
For each testcase, in a new line, output the sorted string.

Your Task:
This is a function problem. You only need to complete the function countSort() that takes char array as parameter. The printing is done by driver code.

Constraints:
1 <= T <= 105
1 <= N <= 105

Example:
Input:
2
5
edsab
13
geeksforgeeks

Output:
abdes
eeeefggkkorss
*/

import java.util.*;
import java.lang.*;
class CountSort
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            char seq[] = new char[(int)n+1];
            String str = "";
            str = sc.next();
            seq = str.toCharArray();
            GfG gfg = new GfG();
             gfg.countSort(seq);
            System.out.println(seq);
        }
    }
}
/*This is a function problem.You only need to complete the function given below*/
class GfG
{
    
    // Function to do count sort
    // seq[]: input array
    public static void countSort(char seq[])
    {
        // add your code here    
        int n = seq.length;
        
        int[] count = new int[100];
        
        for(int i=0;i<n;i++){
            count[getIndex(seq[i])]++;
        }
        
        
        // add the sum
        for(int i=1;i<26;i++){
            count[i]+=count[i-1];
        }
        
        
        char[] result = new char[n];
        
        for(int i=n-1;i>=0;i--){
            result[count[getIndex(seq[i])]-1] = seq[i];
            count[getIndex(seq[i])]--;
        }
        
        // copy result to orig arr
        for(int i=0;i<n;i++){
            seq[i] = result[i];
        }
        
        
    }
    
    static int getIndex(char c){
        return (int)c - (int)'a';
    }
}