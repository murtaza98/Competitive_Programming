/*
Given a grid of size m * n, lets assume you are starting at (1,1) and your goal is to reach (m,n). At any instance, if you are on (x,y), you can either go to (x, y + 1) or (x + 1, y).

Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Example :
There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
The total number of unique paths is 2.

 Note: m and n 
*/


int getUniquePaths(int r, int c, int g_r, int g_c, vector<vector<int> > &A){
    if(r == g_r && c == g_c){
        return 1;
    }
    
    int right_paths = 0,down_paths = 0;
    
    if(c < g_c && A[r][c+1] != 1 ){
        right_paths = getUniquePaths(r, c+1, g_r, g_c, A);
    }
    
    if(r < g_r && A[r+1][c] != 1){
        down_paths = getUniquePaths(r+1, c, g_r, g_c, A);
    }

    return right_paths + down_paths;
}


int Solution::uniquePathsWithObstacles(vector<vector<int> > &A) {

    int g_r = A.size()-1;
    int g_c = A[0].size()-1;
    
    int u_paths = getUniquePaths(0, 0, g_r, g_c, A);
    
    return u_paths;
    
}
