// Problem: Primal Fear
// Contest: SPOJ - Classical
// URL: https://www.spoj.com/problems/VECTAR8/
// Memory Limit: 1536 MB
// Time Limit: 300 ms
// Edited By - Satish Kumar Patra
// 
// Powered by CP Editor (https://cpeditor.org)
// status - accepted

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    
    static final int N = (int)1e6;
    //class  Declaration
	
	
	void solve() throws Exception {
		
		int t = ni();
		int[] in = na(t);
		LinkedList<Integer> q = new LinkedList<>();
		
		int[] f = new int[N+1];
		
		boolean[] isNotPrime = new boolean[N];
		isNotPrime[0] = isNotPrime[1] = true;
		for(int i=3;i*i<N;i+=2){
			if(isNotPrime[i])continue;
			for(int j=i*i;j<N;j+=2*i){
				isNotPrime[j] = true;
			}
		} 	
	
		
		for(int i=2;i<=9;i++){
			if(!isNotPrime[i]){
				if(i!= 2 && i%2==0){
					continue;
				}
				q.push(i);
				f[i]++;
			}
		}
		
		while(!q.isEmpty()){
			int front = q.pop();
			if(isNotPrime[front]){
				continue;
			}
			if((front%2)==0 && front!=2){
				continue;
			}
			for(int i=1;i<=9;i++){
				int newNum = appendDigitInFront(front, i);
				if(newNum % 2 == 0)continue;
				if(newNum < N && !isNotPrime[newNum]){
					q.push(newNum);
					if(f[newNum] == 0)f[newNum]++;
				}
			}
		}
		
		for(int i=1;i<N;i++){
			f[i] += f[i-1];
		}
	
		for(int i=0;i<t;i++){
			int position = f[in[i]];
			pn(position);
		}
	}
	
	int appendDigitInFront(int num, int digit){
		int tempNumber = num;
        int numDigits = 0;
        while (tempNumber > 0) {
            tempNumber /= 10;
            numDigits++;
        }
		int placeValue = (int) Math.pow(10, numDigits);
		return digit*placeValue+num;
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