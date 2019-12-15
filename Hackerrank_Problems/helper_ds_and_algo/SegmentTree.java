import java.util.*;
import java.lang.*;
import java.io.*;

class SegmentTree{
    int[] st;
    int n;
	SegmentTree(int[] arr, int n){
        int bit_set_pos = (int)Math.ceil(Math.log(n)/Math.log(2));
        int st_size = 2*(int)Math.pow(2, bit_set_pos) - 1;
        st = new int[st_size];
        this.n = n;

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
        return queryUtil(0, 0, n-1, l, r);
    }

    int queryUtil(int st_idx, int start, int end, int l, int r){
        if(start>r || end<l){
            // range represented by a node is completely outside the given range
            return 0;
        }else if(l<=start && r>=end){
            // range represented by a node is completely inside the given range
            return st[st_idx];
        }
        
        // this node contains partial range
        int mid = (start+end)/2;
        int p1 = queryUtil(2*st_idx+1, start, mid, l, r);
        int p2 = queryUtil(2*st_idx+2, mid+1, end, l, r);

        return p1+p2;
    }

    void update(int idx, int val){
        updateUtil(0, 0, n-1, idx, val);
    }

    void updateUtil(int st_idx, int start, int end, int idx, int val){
        if(start==end){
            // leaf node
            st[st_idx] += val;
            return;
        }
        int mid = (start+end)/2;
        if(start<=idx && idx<=mid){
            // idx is in left child
            updateUtil(2*st_idx+1, start, mid, idx, val);
        }else{
            // idx is in right child
            updateUtil(2*st_idx+2, mid+1, end, idx, val);
        }

        st[st_idx] = st[2*st_idx+1] + st[2*st_idx+2];
    }
}