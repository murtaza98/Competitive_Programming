import java.util.*;
import java.lang.*;
import java.io.*;

class restaurants {

	static int[][] grid, grid_v;
	static int n, m;

	static class Point{
        int x, y;
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }

        @Override
        public int hashCode(){
            return this.x+this.y;
        }

        @Override
        public boolean equals(Object o){
            if(this==o){
                return true;
            }
            if(!(o instanceof Point)){
                return false;
            }

            Point oo = (Point)o;

            return this.x==oo.x && this.y==oo.y; 
        }

        public String toString(){
            return this.x + "," + this.y;
        }
    }

	static class State{
		int cost;
		Point point;
		State(Point point, int cost){
			this.point = point;
			this.cost = cost;
		}
		@Override
        public int hashCode(){
            return this.point.hashCode();
        }

        @Override
        public boolean equals(Object o){
            if(this==o){
                return true;
            }
            if(!(o instanceof State)){
                return false;
            }

            State oo = (State)o;

            return this.point.equals(oo.point); 
        }
	}

	public static void main (String[] args) throws Exception {
		
		FastReader input = new FastReader();

		n = input.nextInt();
		m = input.nextInt();

		grid = new int[n][m];		// cost
		grid_v = new int[n][m];		// check if visisted

		int k = input.nextInt();

		for(int i=0;i<k;i++){
			int n_tmp = input.nextInt();
			int m_tmp = input.nextInt();
			// mark a restaurant
			grid[n_tmp-1][m_tmp-1] = -1;
		}

		int max_block = input.nextInt();


		for(int i=0;i<n;i++){
			for(int j=0;j<m;j++){
				if(grid[i][j]==-1){
					mark_block(new Point(i, j), max_block);
				}
			}
		}

		// for(int[] i:grid){
		// 	System.out.println(Arrays.toString(i));
		// }
		// System.out.println("\n");
		// for(int[] i:grid_v){
		// 	System.out.println(Arrays.toString(i));
		// }

		int max_rest = Integer.MIN_VALUE;
		int max_x = -1;
		int max_y = -1;

		for(int i=0;i<m;i++){
			for(int j=0;j<n;j++){
				if(grid_v[j][i]!=-1){
					if(grid_v[j][i]>max_rest){
						max_rest = grid_v[j][i];
						max_x = j;
						max_y = i;
					}
				}
			}
		}

		System.out.printf("%d %d %d\n", max_x+1, max_y+1, max_rest);

	}


	static void mark_block(Point start, int max_block){

		HashSet<State> visited = new HashSet<>();
		Queue<State> queue = new LinkedList<>();
		queue.add(new State(start, 0));
		visited.add(new State(start, 0));

		grid[start.x][start.y] = 0;

		while(!queue.isEmpty()){

			State curr_state = queue.poll();
			Point curr = curr_state.point;

			if(curr.x>=m || curr.y>=n || curr.x<0 || curr.y<0 || grid[curr.x][curr.y]==-1 || curr_state.cost > max_block){
				continue;
			}

			grid[curr.x][curr.y] += curr_state.cost;
			grid_v[curr.x][curr.y] += 1;

			int[] dx = {-1, 1, 0, 0};
			int[] dy = {0, 0, 1, -1};

			for(int i=0;i<4;i++){
				int new_x = curr.x+dx[i];
				int new_y = curr.y+dy[i];

				State new_state = new State(new Point(new_x, new_y), curr_state.cost+1);

				if(!visited.contains(new_state)){
					visited.add(new_state);
					queue.add(new_state);
				}
			}
		}

		grid[start.x][start.y] = -1;
	}

}



class FastReader 
{ 
    BufferedReader br; 
    StringTokenizer st; 

    public FastReader() 
    { 
        br = new BufferedReader(new
                 InputStreamReader(System.in)); 
    } 

    String next() 
    { 
        while (st == null || !st.hasMoreElements()) 
        { 
            try
            { 
                st = new StringTokenizer(br.readLine()); 
            } 
            catch (IOException  e) 
            { 
                e.printStackTrace(); 
            } 
        } 
        return st.nextToken(); 
    } 

    int nextInt() 
    { 
        return Integer.parseInt(next()); 
    } 

    long nextLong() 
    { 
        return Long.parseLong(next()); 
    } 

    double nextDouble() 
    { 
        return Double.parseDouble(next()); 
    } 

    String nextLine() 
    { 
        String str = ""; 
        try
        { 
            str = br.readLine(); 
        } 
        catch (IOException e) 
        { 
            e.printStackTrace(); 
        } 
        return str; 
    } 
} 