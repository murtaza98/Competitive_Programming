// https://practice.geeksforgeeks.org/problems/pots-of-gold-game/1

class GfG
{
	public static int maxCoins(int A[],int n)
	{
        int[][] dp = new int[n][n];
        
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                int x = i+2<=j ? dp[i+2][j] : 0;
                int y = i+1<=j-1 ? dp[i+1][j-1] : 0;
                int z = i<=j-2 ? dp[i][j-2] : 0;
                dp[i][j] = Math.max(A[i]+Math.min(x,y), A[j]+Math.min(y,z));
            }
        }
        
        return dp[0][n-1];
    }
}