import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    // Complete the substrings function below.
    static int substrings(String no) {
        int len = no.length();

        long[] dp = new long[len];

        dp[0] = ctoi(no.charAt(0));

        for(int i=1;i<len;i++){
            // dp[i] = dp[i-1]*10 + (i+1)*Integer.parseInt(String.valueof(no.charAt(i)));
            dp[i] = mod_add(mod_multiply(dp[i-1], 10L), (long)(i+1)*ctoi(no.charAt(i)));
        }

        // return sum of dp
        int sum = 0;
        for(long i : dp){
            sum = (int)mod_add(i, (long)sum);
        }

        return sum;
    }

    static int ctoi(char c){
        return c-'0';
    }

    // MODULAR ADDITION AND MULTIPLICATION
    static long mod_multiply(long a, long b){
        int mod = 1000000007;
        return (long)((a%mod)*(b%mod))%mod;
    }
    
    static long mod_add(long a, long b){
        int mod = 1000000007;
        return (long)((a%mod)+(b%mod))%mod;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String n = scanner.nextLine();

        int result = substrings(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}



// ANOTHER SOLUTION
// import java.io.*;
// import java.math.*;
// import java.security.*;
// import java.text.*;
// import java.util.*;
// import java.util.concurrent.*;
// import java.util.regex.*;

// public class Solution {
//     // Complete the substrings function below.
//     static int substrings(String no) {
//         int len = no.length();

//         int sum = 0;

//         long ones = 1;

//         for(int i=len-1;i>=0;i--){
//             // sum += ctoi(no.charAt(i)) * ones * i+1;
//             // ones = ones*10 + 1;

//             // handle mod in above exp
//             sum = (int)mod_add(sum, mod_multiply(
//                                     mod_multiply(ctoi(no.charAt(i)), ones),
//                                 i+1)
//             );
//             ones = mod_multiply(ones, 10L) + 1;
//         }

//         return sum;
//     }

//     static int ctoi(char c){
//         return c-'0';
//     }

//     // MODULAR ADDITION AND MULTIPLICATION
//     static long mod_multiply(long a, long b){
//         int mod = 1000000007;
//         return (long)((a%mod)*(b%mod))%mod;
//     }
    
//     static long mod_add(long a, long b){
//         int mod = 1000000007;
//         return (long)((a%mod)+(b%mod))%mod;
//     }

//     private static final Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) throws IOException {
//         BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

//         String n = scanner.nextLine();

//         int result = substrings(n);

//         bufferedWriter.write(String.valueOf(result));
//         bufferedWriter.newLine();

//         bufferedWriter.close();

//         scanner.close();
//     }
// }
