import java.util.*;
import java.lang.*;
import java.io.*;

class minimum_queens {
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


	public static void main (String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().trim().split("\\s+");

		String[] tmp = input[0].split(",");
		int n = Integer.parseInt(tmp[0]);
		int m = Integer.parseInt(tmp[1]);

		ArrayList<Point> queens = new ArrayList<>();

		for(int i=1;i<input.length;i++){
			tmp = input[i].split(",");

			int q_x = Integer.parseInt(tmp[0]);
			int q_y = Integer.parseInt(tmp[1]);

			queens.add(new Point(q_x, q_y));
		}

		int q_s = queens.size();

		boolean[][] queen_attack = new boolean[q_s][q_s];

		LinkedList[] attack = new LinkedList[q_s];

		for(int i=0;i<q_s;i++){
			for(int j=i;j<q_s;j++){
				if(i==j){
					continue;
				}
				if(under_attack(queens.get(i), queens.get(j))){
					attack[i].add(queens.get(j));
				}
			}
		}

		for(int i=0;i<q_s;i++){
			Point start = queue.get(i);

			HashSet<Point> visited = new HashSet<>();
			visited.add(start);

			for()
		}


		HashSet<Point> visited = new HashSet<>();
		Queue<Point> queue = new LinkedList<>();
		queue.add()












		System.out.println(min_attack);	

	}

	static boolean under_attack(Point q1, Point q2){
		if(q1.x==q2.x || q1.y==q2.y){
			// horizontal or vertical
			return true;
		}
		if(Math.abs(q1.x-q2.x) == Math.abs(q1.y-q2.y)){
			// diagonal attack
			return true;
		}

		return false;
	}
}
