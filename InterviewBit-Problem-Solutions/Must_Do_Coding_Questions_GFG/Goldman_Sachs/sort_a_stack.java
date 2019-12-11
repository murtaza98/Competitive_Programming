/*
Given a stack, the task is to sort it such that the top of the stack has the greatest 
element.
*/
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}

/*This is a function problem.You only need to complete the function given below*/
/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		int n = s.size();
		Stack<Integer> tmp_stk = new Stack<>();
		while(n>0){
		    int min = getMin(s, n, tmp_stk);
		    
		    insertMin(min, s);
		    
		    insertBackFromTmp(s, tmp_stk, min);

		    n--;
		}
		
		return s;
	}
	
	static void insertBackFromTmp(Stack<Integer> stk, Stack<Integer> tmp, int min){
	    boolean found = false;
	    while(!tmp.isEmpty()){
	        int curr = tmp.pop();
	        if(found || curr!=min){
	            stk.push(curr);
	        }else{
	            found=true;
	        }
	    }
	}
	
	static void insertMin(int min, Stack<Integer> s){
	    Stack<Integer> tmp = new Stack<>();
	    
	    while(!s.isEmpty() && s.peek() > min){
	        tmp.push(s.pop());
	    }
	    
	    s.push(min);
	    
	    while(!tmp.isEmpty()){
	        s.push(tmp.pop());
	    }
	}
	
	static int getMin(Stack<Integer> s, int max_pop, Stack<Integer> tmp_stk){
	    int min = Integer.MAX_VALUE;
	    while(max_pop > 0){
	        int tmp = s.pop();
	        tmp_stk.push(tmp);
	        
	        min = Math.min(tmp, min);
	        
	        max_pop--;
	    }
	    return min;
	}
}