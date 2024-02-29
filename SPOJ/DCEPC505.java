// Problem: Bazinga!
// Contest: SPOJ - Classical
// URL: https://www.spoj.com/problems/DCEPC505/
// Memory Limit: 1536 MB
// Time Limit: 1000 ms
// Edited By - Satish Kumar Patra
// 
// Powered by CP Editor (https://cpeditor.org)
// status - accepted, linear sieve

import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    
    static final int N = 10527450 + 1;
    // static final int N = 40 + 1;
    //class  Declaration
	
	
	void solve() throws Exception {
		int t = ni();
		int[] ni = na(t);
		int[] lp = new int[N];
		Arrays.fill(lp, 0);
		int nbcount = 0;
		int[] ans = new int[N];
		// ArrayList<Integer> pr = new ArrayList<>();
		int[] dpr = new int[2000000 + 1];
		int ds = 0;
		
		
		for(int i=2;i<N;i++){
			boolean isItPrime = false;
			if(lp[i] == 0){
				// pr.add(i);
				dpr[ds++] = i;
				lp[i] = i;
				isItPrime = true;
			}
			// for(int j=0; j<pr.size() && pr.get(j)*i<N; j++){
			for(int j=0; j<ds && dpr[j]*i<N; j++){
				lp[i*dpr[j]] = dpr[j];
				if(isItPrime && dpr[j]!=i){
					ans[nbcount++] = i*dpr[j];
				}
				if(dpr[j] == lp[i]){
					break;
				}
			}
		}
		
		Arrays.sort(ans, 0, nbcount);
		
		for(int i=0;i<t;i++){
			pn(ans[ni[i]-1]);
		}
		
		
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