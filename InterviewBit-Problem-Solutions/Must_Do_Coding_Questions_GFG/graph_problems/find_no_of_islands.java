/*
A group of connected 1's forms an island. The task is to complete the method findIslands() which returns the number of islands present. The function takes three arguments the first is the boolean matrix A and then the next two arguments are N and M denoting the size(N*M) of the matrix A .

Input:
The first line of input will be the number of testcases T, then T test cases follow. The first line of each testcase contains two space separated integers N and M. Then in the next line are the NxM inputs of the matrix A separated by space .

Output:
For each testcase in a new line, print the number of islands present.

User Task:
Since this is a functional problem you don't have to worry about input, you just have to complete the function findIslands().

Constraints:
1 <= T <= 100
1 <= N, M <= 50
0 <= A[i][j] <= 1

Example(To be used only for expected output) :
Input
2
3 3
1 1 0 0 0 1 1 0 1
4 4
1 1 0 0 0 0 1 0 0 0 0 1 0 1 0 0

Output
2
2

Explanation:
Testcase 1: The graph will look like
1 1 0
0 0 1
1 0 1
Here, two islands will be formed
First island will be formed by elements {A[0][0] ,  A[0][1], A[1][2], A[2][2]}
Second island will be formed by {A[2][0]}.
*/


//Initial Template for Java
import java.util.*;
import java.io.*;
import java.lang.*;
class Driverclass
{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            
            ArrayList<ArrayList<Integer>> list = new ArrayList<>(N);
            
            // creating arraylist of arraylist
            for(int i = 0; i < N; i++)
            {
                ArrayList<Integer> temp = new ArrayList<>(M);
                list.add(i, temp);
            }
            
            // adding elements to the arraylist of arraylist
            for(int i = 0; i < N; i++)
            {
                for(int j = 0; j < M; j++)
                {
                    int val = sc.nextInt();
                    list.get(i).add(j, val);
                }
            }
            
            
            System.out.println(new Islands().findIslands(list, N, M));
            
        }
    }
}

/*This is a function problem.You only need to complete the function given below*/
//User function Template for Java
class Islands
{
    
    // Function to find the number of island in the given list
    // N, M: size of list row and column respectively
    static int findIslands(ArrayList<ArrayList<Integer>> a, int N, int M)
    {
        
        // Your code here
        int island_count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(a.get(i).get(j) == 1){
                    island_count++;
                    explore_island(a, i, j);
                }
            }
        }
        
        return island_count;
        
    }
    
    static void explore_island(ArrayList<ArrayList<Integer>> a, int cr, int cc){
        int r=a.size();
        int c=a.get(0).size();
        if(cr>=r || cc>=c || cr<0 || cc<0){
            return;
        }
        
        if(a.get(cr).get(cc) == 0){
            return;
        }
        
        // Here a[cr][cc] == 1
        
        // first mark this island as visited
        a.get(cr).set(cc, 0);
        
        // visit nearly islands
        explore_island(a, cr-1, cc-1);
        explore_island(a, cr-1, cc);
        explore_island(a, cr-1, cc+1);
        explore_island(a, cr, cc-1);
        explore_island(a, cr, cc+1);
        explore_island(a, cr+1, cc-1);
        explore_island(a, cr+1, cc);
        explore_island(a, cr+1, cc+1);
        
        
    }
    
}