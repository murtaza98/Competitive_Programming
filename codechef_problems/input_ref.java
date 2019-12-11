import java.util.*;
import java.io.*;
class Zombies{
	static void initializeDiffArray(int A[], int D[]){
		int n = A.length;
		D[0] = A[0];
		D[n] = 0;
		for (int i = 1; i < n; i++)
			D[i] = A[i] - A[i - 1]; 
	}
	static void update(int D[], int l, int r, int x){
		D[l] += x; 
		D[r + 1] -= x; 
	}
	static int printArray(int A[], int D[]) {
		for (int i = 0; i < A.length; i++){
			if (i == 0) 
				A[i] = D[i]; 
			else
				A[i] = D[i] + A[i - 1];
		}
		return 0; 
	} 
	public static void main(String[] args)throws IOException{
		//Scanner in=new Scanner(System.in);
		Reader in=new Reader();
		int t=in.nextInt();
		while(t-->0){
			int n=in.nextInt();
			int[] a=new int[n];int[] b=new int[n];int[] r=new int[n];
			for(int i=0;i<n;i++)a[i]=in.nextInt();
			for(int i=0;i<n;i++)b[i]=in.nextInt();
			int D[] = new int[n + 1]; 
			initializeDiffArray(r, D);
			for(int i=0;i<n;i++){
				int l=(i-a[i]>=0)?i-a[i]:0;
				int r1=(i+a[i]<=n-1)?i+a[i]:n-1;
				update(D,l,r1,1);
			}
			printArray(r,D);
			//for(int i=0;i<n;i++)System.out.print(r[i]+" ");
			//System.out.println();
			Arrays.sort(r);
			Arrays.sort(b);
			boolean ch=true;
			for(int i=0;i<n;i++){
				if(r[i]!=b[i]){ch=false;break;}
			}
			if(ch==false)System.out.println("NO");
			else System.out.println("YES");
		} 
	} 
}
class Reader { 
    final private int BUFFER_SIZE = 1 << 16; 
    private DataInputStream din; 
    private byte[] buffer; 
    private int bufferPointer, bytesRead; 

    public Reader() { 
        din = new DataInputStream(System.in); 
        buffer = new byte[BUFFER_SIZE]; 
        bufferPointer = bytesRead = 0; 
    } 
    public Reader(String file_name) throws IOException { 
        din = new DataInputStream(new FileInputStream(file_name)); 
        buffer = new byte[BUFFER_SIZE]; 
        bufferPointer = bytesRead = 0; 
    } 

    public String readLine() throws IOException { 
        byte[] buf = new byte[64]; // line length 
        int cnt = 0, c; 
        while ((c = read()) != -1) 
        { 
            if (c == '\n') 
                break; 
            buf[cnt++] = (byte) c; 
        } 
        return new String(buf, 0, cnt); 
    } 

    public int nextInt() throws IOException { 
        int ret = 0; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 
        do{ 
            ret = ret * 10 + c - '0'; 
        }while ((c = read()) >= '0' && c <= '9'); 

        if (neg) 
            return -ret; 
        return ret; 
    } 

    public long nextLong() throws IOException{ 
        long ret = 0; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 
        do { 
            ret = ret * 10 + c - '0'; 
        } 
        while ((c = read()) >= '0' && c <= '9'); 
        if (neg) 
            return -ret; 
        return ret; 
    } 

    public double nextDouble() throws IOException{ 
        double ret = 0, div = 1; 
        byte c = read(); 
        while (c <= ' ') 
            c = read(); 
        boolean neg = (c == '-'); 
        if (neg) 
            c = read(); 

        do { 
            ret = ret * 10 + c - '0'; 
        } 
        while ((c = read()) >= '0' && c <= '9'); 

        if (c == '.'){ 
            while ((c = read()) >= '0' && c <= '9'){ 
                ret += (c - '0') / (div *= 10); 
            } 
        } 

        if (neg) 
            return -ret; 
        return ret; 
    } 

    private void fillBuffer() throws IOException { 
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE); 
        if (bytesRead == -1) 
            buffer[0] = -1; 
    } 

    private byte read() throws IOException{ 
        if (bufferPointer == bytesRead) 
            fillBuffer(); 
        return buffer[bufferPointer++]; 
    } 

    public void close() throws IOException{ 
        if (din == null) 
            return; 
        din.close(); 
    }
}