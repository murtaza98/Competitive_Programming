// https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1

class Celebrity
{
    // The task is to complete this function
    int getId(int M[][], int n)
    {
        // Your code here
        LinkedList<Integer> celeb = new LinkedList<>();
        for(int r=0;r<n;r++){
            int cnt=0;
            for(int c=0;c<n;c++){
                if(M[c][r]==1){
                    cnt++;
                }
            }
            if(cnt>=n-1){
                celeb.add(r);
            }
        }
        
        return celeb.size()==1 ? celeb.get(0) : -1;
    }
}