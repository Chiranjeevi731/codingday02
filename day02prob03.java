//prime Factorization
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.*;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
 
class Tester 
{	
	private static String ans = "";
	public static void main(String[] args) 
	{
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int t = in.nextInt();
		while(t-->0)
		{
			int n = in.nextInt();
			ans = "";
			primeFactorization(n);
			out.println(ans);
		}	
		out.close();
	}
	
	public static void primeFactorization(int number)
	{
		int n = number;
		int count = 0;
		while(n%2==0)
		{
			n = n/2;
			count++;
		}
		ans += "2^"+count;
		count = 0;
		for(int i=3;i*i<=n;i+=2)
		{
			count = 0;
			int flag = 0;
			while(n%i==0)
			{
				flag = 1;
				n = n/i;
				count++;
			}
			if(flag == 1)
				ans += "*"+i+"^"+count;
		}
		if(n>2 && n!=number)
			ans += "*"+n+"^"+1;
	}
}
class InputReader {
	 
	private InputStream stream;
	private byte[] buf = new byte[8192];
	private int curChar;
	private int snumChars;
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
		while (isSpaceChar(c))
			c = snext();
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
		while (isSpaceChar(c))
			c = snext();
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
	
	public String readString() {
		int c = snext();
		while (isSpaceChar(c))
			c = snext();
		StringBuilder res = new StringBuilder();
		do {
			res.appendCodePoint(c);
			c = snext();
		} while (!isSpaceChar(c));
		return res.toString();
	}
 
	public boolean isSpaceChar(int c) {
		if (filter != null)
			return filter.isSpaceChar(c);
		return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
	}
 
	public interface SpaceCharFilter {
		public boolean isSpaceChar(int ch);
	}
}
class OutputWriter
{
        private final PrintWriter writer;
 
        public OutputWriter(OutputStream outputStream)
        {
            writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
        }
 
        public OutputWriter(Writer writer)
        {
            this.writer = new PrintWriter(writer);
        }
 
        public void print(Object... objects)
        {
            for (int i = 0; i < objects.length; i++)
            {
                if (i != 0)
                    writer.print(' ');
                writer.print(objects[i]);
            }
        }
 
        public void println(Object... objects)
        {
            print(objects);
            writer.println();
        }
 
        public void close()
        {
            writer.close();
        }
 
        public void flush()
        {
            writer.flush();
        }
}