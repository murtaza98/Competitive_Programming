import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    static class City implements Comparable<City> {
        long p, x;
        City(long p, long x){
            this.p = p;
            this.x = x;
        }

        @Override
        public int compareTo(City o) {
            long diff = this.x-o.x;
            if(diff > 0){
                return 1;
            }else if(diff < 0){
                return -1;
            }else{
                return 0;
            }
        }

        @Override
        public String toString(){
            return String.format("pop %d, loc %d\n", this.p, this.x);
        }
    }

    static City[] city;

    // Complete the maximumPeople function below.
    static long maximumPeople(long[] p, long[] x, long[] y, long[] r) {
        TreeMap<Long,Long> tmp = new TreeMap<>();
        for(int i=0;i<x.length;i++){
            if(tmp.get(x[i])==null){
                tmp.put(x[i],p[i]);
            }else{
                tmp.put(x[i],tmp.get(x[i]) + p[i]);
            }
        }
        int m = y.length;
        int n = tmp.size();

        city = new City[n];
        int j=0;
        for(Map.Entry<Long,Long> e : tmp.entrySet()){
            city[j] = new City(e.getValue(), e.getKey());
            j++;
        }

        // Arrays.sort(city);

        // for(City c : city){
        //     System.out.println(c);
        // }

        int[] count = new int[n];

        for(int i=0;i<m;i++){
            long cl = y[i] - r[i];
            long cr = y[i] + r[i];

            // binary search to find the lowest city
            int le = binary_search_lower_end(cl);
            // binary search to find the highest city
            int re = binary_search_high_end(cr);

            // System.out.println(le + " " + re);

            if(le==-1 || re==-1){
                continue;
            }else{
                count[le]++;
                if(re+1 < n){
                    count[re+1]--;
                }
            }             
        }

        for(int i=1;i<n;i++){
            count[i] += count[i-1];
        }

        long[] preSum = new long[n];
        long no_cloud = 0;

        for(int i=0;i<n;i++){
            if(count[i]==1){
                preSum[i] += city[i].p;
            }else if(count[i]==0){
                no_cloud += city[i].p;
            }
        }

        // form continues sum
        for(int i=1;i<n;i++){
            preSum[i] += preSum[i-1];
        }

        long max_sum = 0;
        for(int i=0;i<m;i++){
            long cl = y[i] - r[i];
            long cr = y[i] + r[i];

            // binary search to find the lowest city
            int le = binary_search_lower_end(cl);
            // binary search to find the highest city
            int re = binary_search_high_end(cr);

            if(le==-1 || re==-1){
                continue;
            }else{
                long curr_sum = preSum[re] - ((le-1>=0) ? preSum[le-1] : 0);
                max_sum = Math.max(max_sum, curr_sum);
            }
        }


        return max_sum + no_cloud;
    }

    static int binary_search_lower_end(long val){
        int l=0, h=city.length-1;
        int le = -1;    // lower end (index)
        while(l<=h){
            int mid = (l+h)/2;
            if(city[mid].x == val){
                le = mid;
                h = mid-1;
            }else if(city[mid].x > val){
                le = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return le;
    }

    static int binary_search_high_end(long val){
        int l=0, h=city.length-1;
        int re = -1;    // right end (index)
        while(l<=h){
            int mid = (l+h)/2;
            if(city[mid].x == val){
                re = mid;
                l = mid+1;
            }else if(city[mid].x > val){
                h = mid-1;
            }else{
                re = mid;
                l = mid+1;
            }
        }
        return re;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] p = new long[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long pItem = Long.parseLong(pItems[i]);
            p[i] = pItem;
        }

        long[] x = new long[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long xItem = Long.parseLong(xItems[i]);
            x[i] = xItem;
        }

        int m = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] y = new long[m];

        String[] yItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long yItem = Long.parseLong(yItems[i]);
            y[i] = yItem;
        }

        long[] r = new long[m];

        String[] rItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            long rItem = Long.parseLong(rItems[i]);
            r[i] = rItem;
        }

        long result = maximumPeople(p, x, y, r);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
