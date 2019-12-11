public class Solution {
    public int coverPoints(ArrayList<Integer> A, ArrayList<Integer> B) {
        int n = A.size();
        int total_steps = 0;
        
        for(int i=1;i<n;i++){
            int x_diff = 0, y_diff = 0;
            if(A.get(i)>=A.get(i-1)){
                x_diff = A.get(i)-A.get(i-1);
            }else{
                x_diff = A.get(i-1)-A.get(i);
            }
            if(B.get(i)>=B.get(i-1)){
                y_diff = B.get(i)-B.get(i-1);
            }else{
                y_diff = B.get(i-1)-B.get(i);
            }
            total_steps += Math.max(Math.abs(x_diff), Math.abs(y_diff));
        }
        
        return total_steps;
    }
}
