import java.util.*;
import java.io.*;

class digitPairs {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
	int n = Integer.parseInt(br.readLine().trim());

	int[] nos = Arrays.stream(br.readLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();

	int[] bitscore = new int[nos.length];

	for(int i=0;i<n;i++){
		int max_digit = getMaxDigit(nos[i]);
		int min_digit = getMinDigit(nos[i]);

		// make the bitscore 2 digit
		bitscore[i] = (max_digit*11 + min_digit*7) % 100;
	}


	// System.out.println(Arrays.toString(bitscore));

	HashMap<Integer,Integer> even_pairs = new HashMap<>();
	HashMap<Integer,Integer> odd_pairs = new HashMap<>();

	for(int i=0;i<n;i++){
		if(i%2 == 0){
			// odd position
			int first_digit = bitscore[i]/10;
			odd_pairs.put(first_digit, odd_pairs.getOrDefault(first_digit,0)+1);
		}else{
			// even position
			int first_digit = bitscore[i]/10;
			even_pairs.put(first_digit, even_pairs.getOrDefault(first_digit,0)+1);
		}
	}

	int tp = 0; // total_pairs

	for(int i=0;i<10;i++){
		int ep = even_pairs.getOrDefault(i,0);
		int op = odd_pairs.getOrDefault(i,0);

		if(ep == 2){
			tp++;
		}
		if(op == 2){
			tp++;
		}
		if(ep > 2 || op > 2){
			tp+=2;
		}
	}

	// for(int key:even_pairs.keySet()){
	// 	int no_pairs = even_pairs.get(key);
	// 	if(no_pairs == 2){
	// 		tp++;
	// 	}else if(no_pairs > 2){
	// 		tp+=2;
	// 	}
	// }

	// for(int key:odd_pairs.keySet()){
	// 	int no_pairs = odd_pairs.get(key);
	// 	if(no_pairs == 2){
	// 		tp++;
	// 	}else if(no_pairs > 2){
	// 		tp+=2;
	// 	}
	// }


	System.out.print(tp);
  }

  public static int getMaxDigit(int n){
  	int max = Integer.MIN_VALUE;

  	while(n>0){
  		max = Math.max(max, n%10);
  		n/=10;
  	}
  	return max;
  }

  public static int getMinDigit(int n){
  	int min = Integer.MAX_VALUE;

  	while(n>0){
  		min = Math.min(min, n%10);
  		n/=10;
  	}
  	return min;
  }
}