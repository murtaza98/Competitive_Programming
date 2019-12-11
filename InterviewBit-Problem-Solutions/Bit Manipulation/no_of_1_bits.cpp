/**
Write a function that takes an unsigned integer and returns the number of 1 bits it has.

Example:

The 32-bit integer 11 has binary representation

00000000000000000000000000001011
so the function should return 3.
**/

int Solution::numSetBits(unsigned int A) {
    // Do not write main() function.
    // Do not read input, instead use the arguments to the function.
    // Do not print the output, instead return values as specified
    // Still have a doubt. Checkout www.interviewbit.com/pages/sample_codes/ for more details
    
    
    /**
    x & (x-1) will clear the lowest set bit of x
    x & ~(x-1) extracts the lowest set bit of x
    (all others are clear). Pretty patterns when applied to a linear sequence.
    **/
    
    int count = 0;
    
    while(A != 0){
        A = A & (A-1);
        count++;
    }
    
    return count;
}
