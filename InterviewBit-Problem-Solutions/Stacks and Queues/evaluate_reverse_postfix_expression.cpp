/*
Evaluate the value of an arithmetic expression in Reverse Polish Notation.

Valid operators are +, -, *, /. Each operand may be an integer or another expression.

Examples:

  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
*/

#include <stack>

bool isNumber(char c){
    return c >=48 && c <=57 ? true : false; 
}

int Solution::evalRPN(vector<string> &A) {
    stack<string> stk;
    
    for(int i =0;i<A.size();i++){
        if(A[i] == "+" ||A[i] == "-" || A[i] == "*" || A[i] == "/"){
            int no1 = stoi(stk.top());
            stk.pop();
            int no2 = stoi(stk.top());
            stk.pop();
            int result = 0;
            if(A[i] == "+"){
                result = no2 + no1;
            }else if(A[i] == "-"){
                result = no2 - no1;
            }else if(A[i] == "*"){
                result = no2 * no1;
            }else if(A[i] == "/"){
                result = no2 / no1;
            }
            stk.push(to_string(result));
        }else{
            stk.push(A[i]);
        }
    }
    return stoi(stk.top());
}
