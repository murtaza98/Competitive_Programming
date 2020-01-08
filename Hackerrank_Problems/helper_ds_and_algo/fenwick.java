// ALSO KNOWN AS BINARY INDEXED TREE


class fenwick{
    // use 1-indexed notation, so arr will be n+1
    int[] bit_arr;

    fenwick(int[] arr){
        // initialize bit_arr
        int n = arr.length;
        bit_arr = new int[n+1];
        for(int i=0;i<n;i++){
            bit_arr[i+1] = arr[i];
        }

        for(int idx=1;idx<n+1;idx++){
            int idx2 = idx + (idx & -idx);
            if(idx2 < n+1){
                bit_arr[idx2] += arr[idx];
            }
        }
    }


    // remove last set bit
    long sum(int idx){
        long result = 0;
        while(idx != 0){
            result += bit_arr[idx];
            idx -= idx & -idx;
        }
        return result;
    }


    // add last set bit
    void add(int idx, int val){
        
        while(idx < bit_arr.length){
            bit_arr[idx] += val;
            idx += idx & -idx;
        }
    }
}