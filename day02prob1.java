//sum of primes program
import java.io.*;
import java.util.*;
import java.math.BigInteger;
 
class TestClass {
    public static void main(String args[] ) throws Exception {
        
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        int T = in.nextInt();
        int[] arr = new int[1000001];
        for(int i=2;i*i<=1000000;i++){
            if(arr[i]==0){
                for(int j=i*i;j<=1000000;j+=i){
                    if(arr[j]==0){
                        arr[j]=1;
                    }
                }
            }
        }
        long[] pre = new long[1000001];
        for(int i=2;i<=1000000;i++){
            pre[i]=pre[i-1];
            if(arr[i]==0){
                pre[i]+=i;
            }
        }
        arr[1]=1;
        arr[0]=1;
        while(T!=0){
            int l = in.nextInt();
            int r = in.nextInt();
            int count=0;
            w.println(pre[r]-pre[l-1]);
           
            T--;
        }
        w.close();
    }
    static class InputReader {
 
    private final InputStream stream;
    private final byte[] buf = new byte[8192];
    private int curChar, snumChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream) {
      this.stream = stream;
    }
 
    public int snext() {
      if (snumChars == -1)
      throw new InputMismatchException();
      if (curChar >= snumChars) {
        curChar = 0;
        try {
          snumChars = stream.read(buf);
        } catch (IOException e) {
          throw new InputMismatchException();
        }
        if (snumChars <= 0)
        return -1;
      }
      return buf[curChar++];
    }
 
    public int nextInt() {
      int c = snext();
      while (isSpaceChar(c)) {
        c = snext();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = snext();
      }
      int res = 0;
      do {
        if (c < '0' || c > '9')
        throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = snext();
      } while (!isSpaceChar(c));
      return res * sgn;
    }
 
    public long nextLong() {
      int c = snext();
      while (isSpaceChar(c)) {
        c = snext();
      }
      int sgn = 1;
      if (c == '-') {
        sgn = -1;
        c = snext();
      }
      long res = 0;
      do {
        if (c < '0' || c > '9')
        throw new InputMismatchException();
        res *= 10;
        res += c - '0';
        c = snext();
      } while (!isSpaceChar(c));
      return res * sgn;
    }
 
    public int[] nextIntArray(int n) {
      int a[] = new int[n];
      for (int i = 0; i < n; i++) {
        a[i] = nextInt();
      }
      return a;
    }
 
    public String readString() {
      int c = snext();
      while (isSpaceChar(c)) {
        c = snext();
      }
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = snext();
      } while (!isSpaceChar(c));
      return res.toString();
    }
 
    public String nextLine() {
      int c = snext();
      while (isSpaceChar(c))
      c = snext();
      StringBuilder res = new StringBuilder();
      do {
        res.appendCodePoint(c);
        c = snext();
      } while (!isEndOfLine(c));
      return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
      if (filter != null)
      return filter.isSpaceChar(c);
      return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    private boolean isEndOfLine(int c) {
      return c == '\n' || c == '\r' || c == -1;
    }
 
    public interface SpaceCharFilter {
      public boolean isSpaceChar(int ch);
    }
  }
}