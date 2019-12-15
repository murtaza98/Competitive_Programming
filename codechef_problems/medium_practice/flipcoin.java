import java.util.*;
import java.lang.*;
import java.io.*;

class flipcoin {
	public static void main (String[] args) throws Exception {
		try{
			FastReader ip = new FastReader();
            int n = ip.nextInt(), q = ip.nextInt();
            StringBuffer sb = new StringBuffer();
            SegmentTreeWithLazyProp seg_tree = new SegmentTreeWithLazyProp(n);

			while(q-->0){
                int type=ip.nextInt(), a=ip.nextInt(), b=ip.nextInt();

                switch(type){
                    case 0:
                        seg_tree.update(a, b);
                        break;
                    case 1:
                        int heads_up = seg_tree.query(a, b);
                        sb.append(heads_up + "\n");
                        break;
                }
            }
            
			System.out.print(sb);
		}catch(Exception e){
			System.out.println("Exception "+e);
			return;
		}
	}
}

class SegmentTreeWithLazyProp {
    int[] st;
    int[] lazy;
    int n;

	SegmentTreeWithLazyProp(int n){
        int bit_set_pos = (int)Math.ceil(Math.log(n)/Math.log(2));
        int st_size = 2*(int)Math.pow(2, bit_set_pos) - 1;
        st = new int[st_size];
        lazy = new int[st_size];
        this.n = n;
	}
    
    int query(int l, int r){
        return queryUtil(0, 0, n-1, l, r);
    }

    int queryUtil(int st_idx, int start, int end, int l, int r){
        if(start>end || start>r || end<l){
            // range represented by a node is completely outside the given range
            return 0;
        }
        
        if(lazy[st_idx] != 0){
            // this node is lazy, so update it first
            if(lazy[st_idx]%2 != 0){
                st[st_idx] = Math.abs((end-start+1) - st[st_idx]);
            }
            if(start != end){
                // it is a non-leaf node, so propogate update to childs
                lazy[2*st_idx+1] += lazy[st_idx];
                lazy[2*st_idx+2] += lazy[st_idx];
            }
            lazy[st_idx] = 0;
        }

        if(start>=l && end<=r){
            // node is completely within range
            return st[st_idx];
        }else{
            // node is partially within range
            int mid = (start+end)/2;
            int p1 = queryUtil(2*st_idx+1, start, mid, l, r);
            int p2 = queryUtil(2*st_idx+2, mid+1, end, l, r);
            return p1+p2;
        }         
    }

    // increament arr[l...r] with val
    void update(int l, int r){
        updateUtil(0, 0, n-1, l, r);
    }

    void updateUtil(int st_idx, int start, int end, int l, int r){
        if(lazy[st_idx] != 0){
            // This node needs to be updated
            if(lazy[st_idx]%2 != 0){
                st[st_idx] = Math.abs((end-start+1) - st[st_idx]);
            }
            if(start != end){
                // this is a non-leaf node, so mark its childs as lazy
                lazy[2*st_idx+1] += lazy[st_idx];
                lazy[2*st_idx+2] += lazy[st_idx];
            }
            lazy[st_idx] = 0;
        }

        if(start>end || r<start || l>end){
            // node not within range
            return;
        }

        if(start>=l && end<=r){
            // this node is within range
            st[st_idx] = Math.abs((end-start+1) - st[st_idx]);
            if(start != end){
                // this is a non-leaf node, so mark its childs as lazy
                lazy[2*st_idx+1] += 1;
                lazy[2*st_idx+2] += 1;
            }
            return;
        }

        int mid = (start+end)/2;
        updateUtil(2*st_idx+1, start, mid, l, r);
        updateUtil(2*st_idx+2, mid+1, end, l, r);
        st[st_idx] = st[2*st_idx+1] + st[2*st_idx+2];
    }
}

class FastReader { 
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
