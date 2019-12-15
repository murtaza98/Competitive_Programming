import java.util.*;
import java.lang.*;
import java.io.*;

class SegmentTreeWithLazyProp{
    int[] st;
    int[] lazy;
    int n;

	SegmentTreeWithLazyProp(int[] arr, int n){
        int bit_set_pos = (int)Math.ceil(Math.log(n)/Math.log(2));
        int st_size = 2*(int)Math.pow(2, bit_set_pos) - 1;
        st = new int[st_size];
        lazy = new int[st_size];
        this.n = n;

		build_segment_tree(arr, 0, n-1, 0);
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
        if(start>end || start>r || end<l){
            // range represented by a node is completely outside the given range
            return 0;
        }
        
        if(lazy[st_idx] != 0){
            // this node is lazy, so update it first
            st[st_idx] += (end-start+1) * lazy[st_idx];
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
    void update(int l, int r, int val){
        updateUtil(0, 0, n-1, l, r, val);
    }

    void updateUtil(int st_idx, int start, int end, int l, int r, int val){
        if(lazy[st_idx] != 0){
            // This node needs to be updated
            st[st_idx] += (end-start+1) * lazy[st_idx];
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
            st[st_idx] += (end-start+1) * val;
            if(start != end){
                // this is a non-leaf node, so mark its childs as lazy
                lazy[2*st_idx+1] += val;
                lazy[2*st_idx+2] += val;
            }
            return;
        }

        int mid = (start+end)/2;
        updateUtil(2*st_idx+1, start, mid, l, r, val);
        updateUtil(2*st_idx+2, mid+1, end, l, r, val);
        st[st_idx] = st[2*st_idx+1] + st[2*st_idx+2];
    }
}