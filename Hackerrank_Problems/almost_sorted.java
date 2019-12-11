import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class almost_sorted {

    // Complete the almostSorted function below.
    static void almostSorted(int[] arr) {
        
        int[] arrn = new int[arr.length+2];
        System.arraycopy(arr, 0, arrn, 1, arr.length);
        arrn[arrn.length-1] = Integer.MAX_VALUE;

        arr = arrn;

        int fm = -1;        // first_misplaced_idx
        int lm = -1;        // last_misplaced_idx

        int i=1;
        while(i<arr.length-1 && arr[i]<arr[i+1]){
            i++;
        }
        fm = i;

        i=arr.length-1;
        while(i>0 && arr[i]>arr[i-1]){
            i--;
        }
        lm = i;

        if(fm==-1){
            System.out.println("no");
        }else{
            // perform swap
            cswap(arr, fm, lm);
            if(isSorted(arr)){
                System.out.printf("yes\nswap %d %d", fm, lm);
            }else{
                // reverse prev swap
                cswap(arr, fm, lm);

                // perform reverse
                reverse(arr, fm, lm);

                System.out.printf("%d %d\n", fm, lm);
                System.out.println(Arrays.toString(arr));
                if(isSorted(arr)){
                    System.out.printf("yes\nreverse %d %d", fm, lm);
                }else{
                    System.out.println("no");
                }
            }
        }
    }

    static boolean isSorted(int[] arr){
        for(int i=1;i<arr.length-1;i++){
            if(arr[i]>arr[i-1] && arr[i]<arr[i+1]){
                continue;
            }else{
            	System.out.printf("condition fail   %d  %d", i, arr[i]);
                return false;
            }
        }
        return true;
    }

    static void reverse(int[] arr, int l, int h){
        while(l<h){
            cswap(arr, l, h);
            l++;
            h--;
        }
    }

    static void cswap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        almostSorted(arr);

        scanner.close();
    }
}
