import java.io.*;
import java.util.*;
import java.math.*;
public class Main {
    InputStream is;
    PrintWriter out;
    String INPUT = "";
    
    static final int N = 100000000 + 1;
    //class  Declaration
    
    boolean[] isPrimeSieve(){
    	boolean[] isPrime = new boolean[N];
    	Arrays.fill(isPrime, true);
    	for(int i=3;i*i<N;i+=2){
    		if(!isPrime[i])continue;
    		for(int j=i*i;j<N;j+=2*i){
    			isPrime[j] = false;
    		}
    	}
    	return isPrime;
    }
    
    void isPrimeSegmentedSieve(int limit){
    	Map<Integer, Integer> map = new LinkedHashMap<>();
    	ArrayList<Integer> primes = new ArrayList<>();
    	int sqN = (int)Math.sqrt(N);
    	boolean[] isPrime = new boolean[sqN+1];
    	Arrays.fill(isPrime, true);
    	map.put(2, 1);
    	primes.add(2);
    	for(int i=3;i*i<=sqN;i+=2){
    		if(!isPrime[i])continue;
    		if(!onlyEven(i)){
    			map.put(i, 1);
    			primes.add(i);	
    		}
    		for(int j=i*i;j<=sqN;j+=2*i){
    			isPrime[j] = false;
    		}
    	}
    	
    	boolean[] isSegmentedPrime = new boolean[limit];
    	for(int low = sqN+1; low<N; low+=limit){
    		int high = Math.min(low + limit, N);
    		// dbg(low + " " + high);
    		Arrays.fill(isSegmentedPrime, true);
    		for(int p: primes){
    			int start = (low / p) * p;
    			if(start < low) start+=p;
    			
    			for(int j=start; j<high; j+=p){
    				isSegmentedPrime[j-low] = false;
    			}
    		}
    		
    		for(int i=low;i<high;i++){
    			if(isSegmentedPrime[i-low]){
    				primes.add(i);
    				map.put(i, 1);
    			}
    		}
    	}
    	
    	int prefixSum = 0;
    	for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            prefixSum += entry.getValue();
            entry.setValue(prefixSum);
        }    	
        int t = ni();
        int[] in = na(t);
        for(int i: in){
        	magic(map.getOrDefault(i, -1));
        }
    }
    
    boolean onlyEven(int i){
    	if(i%2!=0){
    		return false;
    	}
    	if(i%2==0 && i!=2){
    		return true;
    	}
    	return false;
    }
    
    void magic(int i) {
    	if(i==-1){
    		pn(-1);
    		return;
    	}
    	double rowD = (Math.sqrt(8*i+1) - 1D)/2;
		int row = (int)Math.ceil(rowD);
		int col = i - ((row-1)* (row)/2);
		p(row);
		p(" ");
		pn(col);
    }
	
	void solve() throws Exception {
		isPrimeSegmentedSieve(1000000);
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