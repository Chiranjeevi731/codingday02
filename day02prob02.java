import java.io.DataInputStream;
import java.io.IOException;
 
public class SumOfPrime {
    private static final int size = (int) 1e6;
    public static void main(String[] args) throws IOException {
        initializeReader();
        boolean[] sieve = new boolean[size + 1];
        long[] pre = new long[size + 1];
        sieve[0] = sieve[1] = true;
        pre[0] = pre[1] = 0;
        for (int i = 2; i <= size; i++) {
            if (!sieve[i]) {
                pre[i] = pre[i - 1] + i;
                for (int j = 2 * i; j <= size; j += i) {
                    sieve[j] = true;
                }
            }
            if (sieve[i])
                pre[i] = pre[i - 1];
        }
        int t = nextInt();
        StringBuffer sb = new StringBuffer();
        while (t-- > 0) {
            int l = nextInt(), r = nextInt();
            long sum = pre[r];
            if (l > 0)
                sum -= pre[l - 1];
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
    final private static int BUFFER_SIZE = 1 << 16;
    private static byte[] buffer;
    private static DataInputStream din;
    private static int bufferPointer, bytesRead;
 
    private static void initializeReader(){
        buffer = new byte[BUFFER_SIZE];
        din = new DataInputStream(System.in);
        bufferPointer = bytesRead = 0;
    }
 
    private static String nextLine() throws IOException{
        StringBuilder sb = new StringBuilder();
        byte c;
        while((c = read()) != -1 && c != '\n'){
            sb.appendCodePoint(c);
        }
        return sb.toString();
    }
 
    private static int nextInt() throws IOException{
        int ret = 0;
        byte c = read();
        while(c <= ' '){
            c = read();
        }
        boolean neg = c == '-';
        if(neg){
            c = read();
        }
        while(c >= '0' && c <= '9'){
            ret = ret * 10 + c - '0';
            c = read();
        }
        return (neg) ? -ret : ret;
    }
 
    private static long nextLong() throws IOException{
        long ret = 0;
        byte c = read();
        while(c <= ' '){
            c = read();
        }
        boolean neg = c == '-';
        if(neg){
            c = read();
        }
        while(c >= '0' && c <= '9'){
            ret = ret * 10 + c - '0';
            c = read();
        }
        return (neg) ? -ret : ret;
    }
 
    private static double nextDouble() throws IOException{
        double ret = 0, div = 1;
        byte c = read();
        while(c <= ' '){
            c = read();
        }
        boolean neg = c == '-';
        if(neg){
            c = read();
        }
        while(c >= '0' && c <= '9'){
            ret = ret * 10 + (c - '0');
            c = read();
        }
        if(c == '.'){
            while((c = read()) >= '0' && c <= '9'){
                ret += (c - '0') / (div *= 10);
            }
        }
        return (neg) ? -ret : ret;
    }
 
    private static void fillBuffer() throws IOException {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if(bytesRead == -1){
            buffer[0] = -1;
        }
    }
 
    private static byte read() throws IOException{
        if(bufferPointer == bytesRead){
            fillBuffer();
        }
        return buffer[bufferPointer++];
    }
 
    private static void close() throws IOException{
        if(din != null){
            din.close();
        }
    }
}