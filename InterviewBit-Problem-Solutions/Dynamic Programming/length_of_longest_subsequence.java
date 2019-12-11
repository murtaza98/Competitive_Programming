public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int longestSubsequenceLength(final List<Integer> A) {
        
        if(A.size() == 0){
            // System.out.println("hello");
            return 0;
        }
        
        // make and fill lis
        int[] lis = new int[A.size()];
        generateIncr(A, lis);
         
        // make and fill lds
        int[] lds = new int[A.size()];
        generateDecr(A, lds);
        
        // System.out.println(Arrays.toString(A.toArray()));
        // System.out.println(Arrays.toString(lis));
        // System.out.println(Arrays.toString(lds));
        
        int ls = Integer.MIN_VALUE;
        for(int i=0;i<A.size();i++){
            ls = Math.max(ls, lis[i] + lds[i] - 1);
        }
        
        return ls;
    }
    
    public static void generateIncr(List<Integer> A, int[] lis){
        lis[0] = 1;
        for(int i=1;i<A.size();i++){
            lis[i] = 1;
            int max_no = Integer.MIN_VALUE;
            for(int j=0;j<i;j++){
                if(A.get(i) > A.get(j) && max_no < lis[j]){
                    max_no = lis[j];
                }
            }
            lis[i] = Math.max(lis[i], max_no+1);
        }
    }
    
    public static void generateDecr(List<Integer> A, int[] lds){
        int n = A.size();
        lds[n-1] = 1;
        for(int i=n-2;i>=0;i--){
            lds[i] = 1;
            int max_no = Integer.MIN_VALUE;
            for(int j=i+1;j<n;j++){
                if(A.get(i) > A.get(j) && max_no < lds[j]){
                    max_no = lds[j];
                }
            }
            lds[i] = Math.max(lds[i], max_no+1);
        }
    }
}
