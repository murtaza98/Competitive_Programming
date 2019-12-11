import java.util.*;
import java.lang.*;
import java.io.*;

class chef_and_pizza {
	public static void main (String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine().trim());
		
		StringBuffer sb = new StringBuffer();

		while(t>0){		    
		    int n = Integer.parseInt(br.readLine().trim());

		    int[][] pizza = new int[n][n];

		    for(int i=0;i<n;i++){
		    	pizza[i] = Arrays.stream(br.readLine().trim().split("")).mapToInt(Integer::parseInt).toArray();
		    }

		    int abs_diff=0, left_sum=0, right_sum=0;

		    HashSet<Integer> abs_diff_occ = new HashSet<>();

		    for(int i=0;i<n;i++){
		    	int mid = n/2, c_left_sum=0, c_right_sum=0;;
		    	// left half
		    	for(int j=0;j<mid;j++){
		    		if(pizza[i][j]==1){
		    			c_left_sum++;
		    		}
		    	}

		    	// right half
		    	for(int j=mid;j<n;j++){
		    		if(pizza[i][j]==1){
		    			c_right_sum++;
		    		}
		    	}

		    	abs_diff_occ.add(Math.abs(c_left_sum - c_right_sum));
		    	abs_diff += Math.abs(c_left_sum - c_right_sum);
		    	left_sum += c_left_sum;
		    	right_sum += c_right_sum;
		    }

		    if(left_sum == right_sum){
		    	sb.append(-1);
		    }else{
		    	int diff = Math.abs(left_sum-right_sum);

		    	int target = (int)Math.ceil(diff/2);

		    	boolean found = false;

		  		for(int j=target;j>=0;j--){
		  			if(abs_diff_occ.contains(j)){
		  				int min_value = Math.min(left_sum, right_sum);
		  				int max_value = Math.max(left_sum, right_sum);

		  				min_value += (target-j);
		  				max_value -= (target-j);

		  				sb.append(max_value-min_value);
		  				found = true;
		  				break;
		  			}
		  		}

		  		if(!found){
		  			sb.append(Math.abs(left_sum-right_sum));
		  		}
		    }


		    // int result = -1;

		    // if(left_sum==right_sum){
		    // 	result = 0;
		    // }else{
		    // 	int max_side = Math.max(left_sum, right_sum);
		    // 	result = Math.abs(max_side - abs_diff);	
		    // }

		    // sb.append(result);

			t--;
			if(t>0){
			    sb.append("\n");
			}
		}

		System.out.print(sb);
	}

	static void printArray(int[][] a, String log_text){
		System.out.println(log_text);
		for(int[] i:a){
			System.out.println(Arrays.toString(i));
		}
	}

	static void multiply(int mat1[][], int mat2[][], int res[][], int N) 
    { 
        int i, j, k; 
        for (i = 0; i < N; i++) 
        { 
            for (j = 0; j < N; j++) 
            { 
                res[i][j] = 0; 
                for (k = 0; k < N; k++) 
                    res[i][j] += mat1[i][k]  * mat2[k][j]; 
            } 
        } 
    }

    static void transpose(int A[][], int B[][], int N) 
    { 
        int i, j; 
        for (i = 0; i < N; i++) 
            for (j = 0; j < N; j++) 
                B[i][j] = A[j][i]; 
    }
}