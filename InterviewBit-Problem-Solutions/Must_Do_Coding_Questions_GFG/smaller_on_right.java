import java.io.*;
import java.lang.*;
import java.util.*;

class smaller_on_Right { 
    
    static int getMaxSmallerOnRight(int[] arr, int n){
        int cnt = 0;
        TreeSet<Integer> tst = new TreeSet<Integer>();
        for(int i=n-1; i>=0; i--){
            tst.add(arr[i]);
            cnt = Integer.max(tst.headSet(arr[i]).size(), cnt);
        }
        return cnt;
    }
    
    public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    inputLine = br.readLine().trim().split(" ");
		    int[] arr = new int[n];
		    for(int i=0; i<n; i++){
		        arr[i]=Integer.parseInt(inputLine[i]);
		    }
		    System.out.println(getMaxSmallerOnRight(arr, n));
		}
	}
} 