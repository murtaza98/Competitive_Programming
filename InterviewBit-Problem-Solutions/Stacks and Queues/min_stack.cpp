/*
Design a stack that supports push, pop, top, and retrieving the minimum 
element in constant time.

push(x) – Push element x onto stack.
pop() – Removes the element on top of the stack.
top() – Get the top element.
getMin() – Retrieve the minimum element in the stack.
Note that all the operations have to be constant time operations.

Questions to ask the interviewer :

Q: What should getMin() do on empty stack? 
A: In this case, return -1.

Q: What should pop do on empty stack? 
A: In this case, nothing. 

Q: What should top() do on empty stack?
A: In this case, return -1
 NOTE : If you are using your own declared global variables, 
 make sure to clear them out in the constructor. 
*/

#include <stack>

stack<int> stk;
int min_no = INT_MAX;

MinStack::MinStack() {
    while(!stk.empty()){
        stk.pop();
    }
    min_no = INT_MAX;
};

void MinStack::push(int x) {
    if(stk.empty()){
        stk.push(x);
        min_no = x;
    }else{
        if(x >= min_no){
            stk.push(x);
        }else{
            // 2*x-min_no makes sure that the min is less than curr_minimum & 
            // also that we could retrieve back old min_no from the new min no
            int new_min = 2 * x - min_no;
            stk.push(new_min);
            min_no = x;
        }
    }
}

void MinStack::pop() {
    if(stk.empty()){
        return;
    }
    if(stk.top() > min_no){
        // min element still on stack
        stk.pop();
    }else{
        // retrieve prev min_no from min_no
        min_no = 2 * min_no - stk.top();
        stk.pop();
    }
}

int MinStack::top() {
    if(stk.empty()){
        return -1;    
    }else{
        int tmp = stk.top();
        
        // since the min_no is encoded & then stores in stack
        if(tmp < min_no){
            return min_no;
        }else{
            return tmp;
        }
    }
}

int MinStack::getMin() {
    if(stk.empty()){
        return -1;
    }else{
        return min_no;
    }
}

