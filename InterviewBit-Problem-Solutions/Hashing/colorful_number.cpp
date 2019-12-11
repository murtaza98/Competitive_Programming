/*
For Given Number N find if its COLORFUL number or not

Return 0/1

COLORFUL number:

A number can be broken into different contiguous sub-subsequence parts. 
Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. 
And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is different
Example:

N = 23
2 3 23
2 -> 2
3 -> 3
23 -> 6
this number is a COLORFUL number since product of every digit of a sub-sequence are different. 

Output : 1
*/
void printVectorC(vector<int> a){
    for(auto i=a.begin();i!=a.end();i++){
        cout << *i << " ";
    }
    cout << endl;
}

int Solution::colorful(int A) {
    vector<int> digits;
    while(A!=0){
        int digit = A%10;
        digits.push_back(digit);
        A = A / 10;
    }
    
    reverse(digits.begin(), digits.end());
    
    unordered_set<int> product_hash_table;
    
    for(int i=0; i < digits.size(); i++){
        int product = 1;
        for(int j=i; j < digits.size(); j++){
            product = product * digits[j];
            
            // unordered_set return ptr to end IF ELEMENT IS NOT FOUND
            if(product_hash_table.find(product) == product_hash_table.end()){
                product_hash_table.insert(product);
            }else{
                return 0;
            }
        }
    }
    return 1;
}
