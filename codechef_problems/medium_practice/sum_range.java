import java.util.*;
import java.lang.*;
import java.io.*;

public class sum_range {
	public static void main (String[] args) throws Exception {
		// try{
			FastReader ip = new FastReader();
		
			int t = ip.nextInt();
			
			StringBuffer sb = new StringBuffer();

			while(t-->0){

				int n=ip.nextInt();
				int[] arr = new int[n];
				for(int i=0;i<n;i++){
					arr[i] = ip.nextInt();
				}

				SegmentTree segmentTree = new SegmentTree(arr, n);




				
			    
				sb.append("\n");
			}

			System.out.print(sb);
		// }catch(Exception e){
		// 	System.out.println("Exception "+e);
		// 	return;
		// }
	}
}

class SegmentTree{
	int[] st;
	SegmentTree(int[] arr, int n){
        int pos = (int)Math.ceil(Math.log(n)/Math.log(2));
        int st_size = 2*(int)Math.pow(2, pos) - 1;
        System.out.println("SIZE OF ST "+st_size + " "+pos);
		st = new int[st_size];

		build_segment_tree(arr, 0, n-1, 0);

		System.out.println(Arrays.toString(st));
	}

	void build_segment_tree(int[] arr, int start, int end, int st_idx){
		if(start==end){
			st[st_idx] = arr[start];
			return;
		}
		int mid = (start+end)/2;
		build_segment_tree(arr, start, mid, 2*st_idx+1);
		build_segment_tree(arr, mid+1, end, 2*st_idx+2);

		st[st_idx] = st[2*st_idx+1] + st[2*st_idx+2];
    }
    
    int query(int l, int r){
        return 1;
    }

    void update(int i, int val){

    }
}

class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
        br = new BufferedReader(new
                 InputStreamReader(System.in)); 
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
} 	