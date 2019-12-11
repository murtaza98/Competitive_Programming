import java.util.*;
import java.io.*;

class marathon1 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());

		int[][] main_map = new int[n][(t-1)/2];

		for(int i=0;i<n;i++){
			int[] b = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			int psp = b[b.length-1];   
			int csc = b[0]*psp;  
			int[] tmm = new int[(t-1)/2]; 
			for(int j=1;j<t-1;j++){
				csc += b[j]*psp;
				if(j%2 != 0){
					tmm[j/2] = csc;
				}
			}
			main_map[i] = tmm;
		}
		int[] score = new int[n];
		for(int i=0;i<(t-1)/2;i++){
			int max_val = main_map[0][i];
			for(int j=1;j<n;j++){
				if(main_map[j][i] > max_val){
					max_val = main_map[j][i];
				}
			}

			for(int j=0;j<n;j++){
				if(main_map[j][i] == max_val){
					score[j] += 1;
				}
			}
		}
		int max_val = score[0];
		for(int i=1;i<n;i++){
			if(score[i] > max_val){
				max_val = score[i];
			}
		}
		for(int i=0;i<n;i++){
			if(max_val == score[i]){
				System.out.println(i+1);
				break;
			}
		}
  }
}