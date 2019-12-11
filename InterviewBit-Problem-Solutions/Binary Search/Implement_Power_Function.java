/***
Implement pow(x, n) % d.

In other words, given x, n and d,

find (x^n % d)

Note that remainders on division cannot be negative. 
In other words, make sure the answer you return is non negative.

Input : x = 2, n = 3, d = 3
Output : 2

2^3 % 3 = 8 % 3 = 2.
***/

public class Solution {
    public int pow(int x, int n, int d) {
        return (int)poww((long)x, (long)n, (long)d);
    }
    
    public long poww(long x, long n, long d){
        if(x == 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return custom_modulos(x, d);
        }else{
            if(n%2 == 0){
                // If n is even, note the following:
                // x ^ n = (x * x) ^ n/2
                // Also note that,
                // 19 ^ 2 mod 7 == ((19 mod 7) * 19) % 7
                return poww(custom_modulos(custom_modulos(x, d) * x, d), n/2, d);
            }else{
                // if n is odd, then we calculate x^(n-1) first and
                // then we multiply it by x
                long even = poww(custom_modulos(custom_modulos(x, d) * x, d), (n-1)/2, d);
                return custom_modulos(custom_modulos(custom_modulos(even, d) * x, d), d);
            }
        }
    }
    
    long custom_modulos(long no, long mod){
        // this function is used to handle mod of negative numbers,
        // this function can generate mod of +ve & -ve no's
        return ((no % mod) + mod) % mod;
    }
}

