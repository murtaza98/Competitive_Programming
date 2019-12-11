import java.util.*;
import java.lang.*;
import java.io.*;

public class hotelier {
  public static void main(String[] args) throws Exception {
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			int n = Integer.parseInt(br.readLine().trim());
			String m = br.readLine().trim();

			int[] rooms = new int[10];

			for(int i=0;i<n;i++){
				char cc = m.charAt(i);
				switch(cc){
					case 'L':
						for(int j=0;j<10;j++){
							if(rooms[j]==0){
								// mark as occupied
								rooms[j]=1;
								break;
							}
						}
						break;
					case 'R':
						for(int j=9;j>=0;j--){
							if(rooms[j]==0){
								// mark as occupied
								rooms[j]=1;
								break;
							}
						}
						break;
					default:
						int room_no = cc - '0';
						// mark this room as un-occupied
						rooms[room_no] = 0;
						break;
				}
			}
			System.out.println(String.join("", Arrays.stream(rooms).mapToObj(String::valueOf).toArray(String[]::new)));
		}catch(Exception e){
			return;
		}
  }
}