import java.util.*;
import java.io.*;

class marathon {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int t = Integer.parseInt(br.readLine());

		// int[] steps = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

		int[][] map = new int[n][(t-1)/2];

		for(int i=0;i<n;i++){
			int[] steps = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

			int sps = steps[steps.length-1];   //steps per second

			int cs = steps[0]*sps;  //current steps

			int[] ms = new int[(t-1)/2]; // main steps to be considered
			for(int j=1;j<t-1;j++){
				cs += steps[j]*sps;
				if(j%2 != 0){
					// include
					ms[j/2] = cs;
				}
				// System.out.println(i+" "+j+" "+cs+" "+n);
			}
			map[i] = ms;
		}

		for(int i=0;i<n;i++){
			System.out.println(Arrays.toString(map[i]));
		}

		int[] score = new int[n];


		for(int i=0;i<(t-1)/2;i++){
			int max_val = map[0][i];
			for(int j=1;j<n;j++){
				if(map[j][i] > max_val){
					max_val = map[j][i];
				}
			}

			// update score using max_val
			for(int j=0;j<n;j++){
				if(map[j][i] == max_val){
					score[j] += 1;
				}
			}
		}

		System.out.println("Score\n"+Arrays.toString(score));
		// get max from score
		int max_val = score[0];
		for(int i=1;i<n;i++){
			if(score[i] > max_val){
				max_val = score[i];
			}
		}

		// get max score index
		for(int i=0;i<n;i++){
			if(max_val == score[i]){
				System.out.println(i+1);
				break;
			}
		}


  }
}