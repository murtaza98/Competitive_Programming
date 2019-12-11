/*
Write a program to validate if the input string has redundant braces?
Return 0/1

0 -> NO
1 -> YES
Input will be always a valid expression

and operators allowed are only + , * , - , /

Example:

((a + b)) has redundant braces so answer will be 1
(a + (a + b)) doesn't have have any redundant braces so answer will be 0


As per the expected output, ((2+3)*(3+4))/6 has redundant braces which is wrong logically.
But, the question is basically asking you to make sure that every pair of braces is matched with at least one operator 
and one number per pair. Now you can see why the above expression gives redundant braces. 

*/

#include <stack>

bool isOperator(char c){
    if(c=='*'||c=='/'||c=='+'||c=='-'){
        return true;
    }
    return false;
}

int Solution::braces(string A) {
    stack<char> stk;
    
    for(int i=0;i < A.length();i++){
        if(isOperator(A[i]) || A[i] == '('){
            stk.push(A[i]);
        }else if(A[i] == ')'){
            if(stk.top() == '('){
                return 1;
            }else{
                while(!stk.empty() && stk.top()!='('){
                    stk.pop();
                }
                // to remove '('
                stk.pop();
            }
        }
    }
    return 0;
}
