/*

NOTE THAT THE WE START INDEX FROM 1 INSTEAD OF 0, SO THAT FORMULA TO CHECK IF QUEEN
IS IN ATTACK FORMULA BECOMES USABLE 


The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

N Queens: Example 1

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens’ placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/


// Helper Function to check if queen can be placed 
bool canPlace(int k, int i, vector<int> arr){ 
    for (int j = 1;j <= k - 1;j++){ 
        if (arr[j] == i ||  
            (abs(arr[j] - i) == abs(j - k))) 
           return false; 
    } 
    return true; 
} 

vector<string> convert_vector_for_display(vector<int> &arr, int A){
    vector<string> result;
    for(int i=1;i<=A;i++){
        string tmp_row = "";
        for(int j=1;j<=A;j++){
            if(arr[i] == j){
                tmp_row += 'Q';
            }else{
                tmp_row += '.';
            }
        }
        result.push_back(tmp_row);
    }
    return result;
}

void nQueens(int row, vector<int> &tmp_result, vector<vector<string>> &result, int A){
    for(int i=1;i<=A;i++){
        if(canPlace(row,i,tmp_result)){
            tmp_result[row] = i;
            if(row == A){
                vector<string> tmp_result_str = convert_vector_for_display(tmp_result, A);
                result.push_back(tmp_result_str);
                return;
            }else{
                nQueens(row+1, tmp_result, result, A);
            }
        }
    }
    return;
}

vector<vector<string> > Solution::solveNQueens(int A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    
    vector<int> tmp_result;
    
    for(int i=1;i<=A;i++){
        tmp_result.push_back(0);
    }
    
    vector<vector<string>> result;
    
    nQueens(1, tmp_result, result, A);
    
    return result;
    
}



