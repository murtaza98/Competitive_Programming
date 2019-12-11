import java.util.*;
import java.io.*;

class bottle_necks {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	int n = Integer.parseInt(br.readLine().trim());

	long[] radius = Arrays.stream(br.readLine().trim().split("\\s+")).mapToLong(Long::parseLong).toArray();
	
    long max_no = Arrays.stream(radius).max().getAsLong();;

    // cout occurance of max_no
    int occ = 0; 
    for(int i=0;i<n;i++){
    	if(radius[i] == max_no){
    		occ++;
    	}
    }
	System.out.println(occ);
  }
}