import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    final static BigInteger MOD = BigInteger.valueOf(1000000007);

    /*
     * Complete the beadOrnaments function below.
     */
    static long beadOrnaments(int[] b) {
        BigInteger n = BigInteger.valueOf(b.length);

        if(n == BigInteger.valueOf(1)){
            BigInteger base = cayleys(b[0]);

            return base.mod(MOD).longValue();
        }else{
            int sum_i = 0;
            for(int i : b){
                sum_i += i;
            }

            BigInteger sum = BigInteger.valueOf(sum_i);
            BigInteger nminus2B = n.subtract(BigInteger.valueOf(2));

            BigInteger base = sum.modPow(nminus2B, MOD);

            for(int i : b){
                BigInteger iB = BigInteger.valueOf(i);
                base = base.multiply(iB.multiply(cayleys(i))).mod(MOD);
            }

            return base.longValue();
        }
    }

    static long mod_multiply(long a, long b){
        int mod = 1000000007;
        return (long)((a%mod)*(b%mod))%mod;
    }

    static BigInteger cayleys(int n){
        if(n<=2){
            return BigInteger.valueOf(1);
        }else{
            BigInteger nB = BigInteger.valueOf(n);
            BigInteger nminus2B = nB.subtract(BigInteger.valueOf(2));

            return nB.modPow(nminus2B, MOD);
        }
        // if(n<=2){
        //     return 1;
        // }else{
        //     return ((long)Math.pow(n, n-2))%MOD;
        // }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int tItr = 0; tItr < t; tItr++) {
            int bCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            int[] b = new int[bCount];

            String[] bItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

            for (int bItr = 0; bItr < bCount; bItr++) {
                int bItem = Integer.parseInt(bItems[bItr]);
                b[bItr] = bItem;
            }

            long result = beadOrnaments(b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
