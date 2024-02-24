// Problem: primes triangle (I)
// Contest: SPOJ - Classical
// URL: https://www.spoj.com/problems/PTRI/
// Memory Limit: 1536 MB
// Time Limit: 200 ms
// Edited By - Satish Kumar Patra
// 
// Powered by CP Editor (https://cpeditor.org)

// status - TLE, Java

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    
    static final int N = (int)1e8 + 1;
    //class  Declaration
	
	
	void solve() throws Exception {
		int t = ni();
		int[] ax = na(t);
		boolean[] isNotPrime = new boolean[N];
		isNotPrime[0] = isNotPrime[1] = true;
		int[] position = new int[N];
		position[2] = 1;
		int pos = 1;
		int i=3;
		for(;i*i<N;i+=2){
			if(isNotPrime[i])continue;
			position[i] = ++pos;
			for(int j=i*i;j<N;j+=2*i){
				isNotPrime[j] = true;
			}
		}
		for(;i<N;i++){
			if(isNotPrime[i])continue;
			if(i%2==0 && i!=2)continue;
			position[i] = ++pos;
		}		
		
		for(int x: ax){
			if(position[x] == 0)pn(-1);
			else magic(position[x]);
		}
	}
	
	void magic(int i){
		double rowD = (Math.sqrt(8*i+1) - 1D)/2;
		int row = (int)Math.ceil(rowD);
		int col = i - ((row-1)* (row)/2);
		p(row);
		p(" ");
		pn(col);
	}
	
	void run() throws Exception {
	        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
	        out = new PrintWriter(System.out);
	 
	        long s = System.currentTimeMillis();
	        solve();
	        out.flush();
	        System.err.println(System.currentTimeMillis() - s + "ms");
	}
	public static void main(String[] args) throws Exception {
	    boolean memory = false ;
	    if(memory) new Thread(null, new Runnable() {public void run(){try{new Main().run();}catch(Exception e){e.printStackTrace();System.exit(1);}}}, "1", 1 << 28).start();
	    else new Main().run();
	    
	}
	 
	//output methods
	private void dbg(Object... o){ System.err.println(Arrays.deepToString(o));}
	void p(Object... o){for(Object oo:o)out.print(oo);}
	void pn(Object... o){for(int i = 0; i< o.length; i++)out.print(o[i]+(i+1 < o.length?" ":"\n"));}
	void pni(Object... o){for(Object oo:o)out.print(oo+" ");out.println();out.flush();}
	 
	//input methods
	
	private byte[] inbuf = new byte[1024];
	public int lenbuf = 0, ptrbuf = 0;
	 
	 
	private int readByte() {
	    if (lenbuf == -1) throw new InputMismatchException();
	    if (ptrbuf >= lenbuf) {
	        ptrbuf = 0;
	        try {
	            lenbuf = is.read(inbuf);
	        } catch (IOException e) {
	            throw new InputMismatchException();
	        }
	        if (lenbuf <= 0) return -1;
	    }
	    return inbuf[ptrbuf++];
	}
	private boolean isSpaceChar(int c) {
	    return !(c >= 33 && c <= 126);
	}
	private int skip() {
	    int b;
	    while ((b = readByte()) != -1 && isSpaceChar(b));
	    return b;
	}
	 
	private int[] na(int n) {
	    int[] a = new int[n];
	    for (int i = 0; i < n; i++) a[i] = ni();
	    return a;
	}
	 
	private int ni() {
	    int num = 0, b;
	    boolean minus = false;
	    while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
	    if (b == '-') {
	        minus = true;
	        b = readByte();
	    }
	 
	    while (true) {
	        if (b >= '0' && b <= '9') {
	            num = num * 10 + (b - '0');
	        } else {
	            return minus ? -num : num;
	        }
	        b = readByte();
	    }
	}
	
	private long nl() {
	    long num = 0;
	    int b;
	    boolean minus = false;
	    while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));
	    if (b == '-') {
	        minus = true;
	        b = readByte();
	    }
	 
	    while (true) {
	        if (b >= '0' && b <= '9') {
	            num = num * 10 + (b - '0');
	        } else {
	            return minus ? -num : num;
	        }
	        b = readByte();
	    }
	}
}