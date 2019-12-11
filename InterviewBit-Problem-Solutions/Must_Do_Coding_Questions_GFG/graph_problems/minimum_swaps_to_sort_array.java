/*
Given an array of N distinct elementsA[ ]. The task is to find the minimum number of swaps required to sort the array. Your are required to complete the function which returns an integer denoting the minimum number of swaps, required to sort the array.

Input:
The first line of input contains an integer T denoting the no of test cases . Then T test cases follow . Each test case contains an integer N denoting the no of element of the array A[ ]. In the next line are N space separated values of the array A[ ] .

Output:
For each test case in a new line output will be an integer denoting  minimum umber of swaps that are  required to sort the array.

Constraints:
1 <= T <= 100
1 <= N <= 103
1 <= A[] <= 104
 

User Task: Your task is to complete minSwaps() which should return number of swaps required to make the array elements sorted.

Example(To be used only for expected output):
Input:
2
4
4 3 2 1
5
1 5 4 3 2

Output:
2
2

Explanation:
Testcase 1: We need two swaps, swap 1 with 4 and 3 with 2 to make it sorted.
*/

import java.util.*;
class MinSwaps{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int n = sc.nextInt();
			int[] a=new int[n];
			for(int i = 0; i<n ; i++){
				a[i]=sc.nextInt();
			}
			GfG g=new GfG();
			System.out.println(g.minSwaps(a,n));
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
/*Complete the function*/
class GfG
{
	public static int minSwaps(int[] A, int N)
	{
	    Pair[] sA = new Pair[N]; // sorted_A
	    for(int i=0;i<N;i++){
	        Pair obj = new Pair(A[i], i+1);
	        sA[i] = obj;
	    }
	    
	    Arrays.sort(sA);
	    
	    int total_cycles = 0;
	    boolean[] visited = new boolean[N];
	    
	    for(int i=0;i<N;i++){
	        Pair cp = sA[i]; // current pair
	        if(cp.element==cp.index || visited[i]==true){
	            continue;
	        }
	        
	        // this element is not visited before and it is not on correct position
	        visited[i] = true;
	        int next = cp.index-1;
	        while(visited[next]==false){
	            total_cycles++;
	            Pair curr_pair = sA[next];
	            visited[next] = true;
	            next = curr_pair.index-1;
	            
	        }
	    }
	    
	    return total_cycles;
    }
}

class Pair implements Comparable<Pair>{
    int element, index;
    Pair(int element, int index){
        this.element = element;
        this.index = index;
    }
    
    @Override
    public int compareTo(Pair o){
        if(this.element==o.element){
            return 0;
        }else if(this.element < o.element){
            return -1;
        }else{
            return 1;
        }
    }
}