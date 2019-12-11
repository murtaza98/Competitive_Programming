/*
Given N bags, each bag contains Ai chocolates. There is a kid and a magician. In one unit of time, kid chooses a random bag i, eats Ai chocolates, then the magician fills the ith bag with floor(Ai/2) chocolates.

Given Ai for 1 <= i <= N, find the maximum number of chocolates kid can eat in K units of time.

For example,

K = 3
N = 2
A = 6 5

Return: 14
At t = 1 kid eats 6 chocolates from bag 0, and the bag gets filled by 3 chocolates
At t = 2 kid eats 5 chocolates from bag 1, and the bag gets filled by 2 chocolates
At t = 3 kid eats 3 chocolates from bag 0, and the bag gets filled by 1 chocolate
so, total number of chocolates eaten: 6 + 5 + 3 = 14

*/

#include <algorithm>
#include <cmath>
#include <queue>

long modulo_add(long a, int b){
    return (a+(long)b) % (long)(pow(10,9)+7);
}

int Solution::nchoc(int A, vector<int> &B) {
    long total = 0;
    
    priority_queue<int> queue;
    
    for(int i=0;i<B.size();i++){
        queue.push(B[i]);
    }
    
    while(A>0){
        int max_no = queue.top();
        
        if(max_no == 0){
            break;
        }
        
        total = modulo_add(total, max_no);
        
        queue.pop();

        int new_no = floor(max_no/2);
        queue.push(new_no);
        
        A--;
    }
    
    return total;
}
