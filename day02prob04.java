import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
import static java.lang.Math.*;
 
public class Check2 implements Runnable
{
	static class InputReader
	{
		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;
		
		public InputReader(InputStream stream)
		{
			this.stream = stream;
		}
		
		public int read()
		{
			if (numChars==-1) 
				throw new InputMismatchException();
			
			if (curChar >= numChars)
			{
				curChar = 0;
				try 
				{
					numChars = stream.read(buf);
				}
				catch (IOException e)
				{
					throw new InputMismatchException();
				}
				
				if(numChars <= 0)				
					return -1;
			}
			return buf[curChar++];
		}
	 
		public String nextLine()
		{
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
		}
		public int nextInt()
		{
			int c = read();
			
			while(isSpaceChar(c)) 
				c = read();
			
			int sgn = 1;
			
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			
			int res = 0;
			do 
			{
				if(c<'0'||c>'9') 
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c)); 
			
			return res * sgn;
		}
		
		public long nextLong() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			long res = 0;
			
			do 
			{
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			while (!isSpaceChar(c));
				return res * sgn;
		}
		
		public double nextDouble() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-') 
			{
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') 
			{
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, nextInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') 
			{
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) 
				{
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, nextInt());
					if (c < '0' || c > '9')
						throw new InputMismatchException();
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}
		
		public String readString() 
		{
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do 
			{
				res.appendCodePoint(c);
				c = read();
			} 
			while (!isSpaceChar(c));
			
			return res.toString();
		}
	 
		public boolean isSpaceChar(int c) 
		{
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
	 
		public String next() 
		{
			return readString();
		}
		
		public interface SpaceCharFilter 
		{
			public boolean isSpaceChar(int ch);
		}
	}
 
	static class Pair implements Comparable<Pair>
	{
		int a;
		int b;
 
		public Pair(int a,int b)
		{
			this.a=a;
			this.b=b;
		}
 		
		public int compareTo(Pair pair)
		{
			if(Integer.compare(b,pair.b)==0)
				return Integer.compare(a,pair.a);
 
			return -1*Integer.compare(b,pair.b);
		}
	}
 	
	public static void main(String args[]) throws Exception
	{
		new Thread(null, new Check2(),"CHECK2",1<<26).start();
	}
 	
 	static int[] sieve(int n)
 	{
 		int arr[]=new int[n+1];
 		for(int i=2;i<=sqrt(n);i++)
 		{
 			if(arr[i]==0)
 			{
 				for(int j=2*i;j<=n;j+=i)
 					arr[j]++;
 			}
 		}
 		arr[1]++;
 		return arr;
 	}
 
 	
	public void run() 
	{
		InputReader sc=new InputReader(System.in);
		PrintWriter w=new PrintWriter(System.out);
 
		int t=sc.nextInt();
		 long max=0;
		while(t-- >0)
		{
			try
			{
			   
 
			    long ip=sc.nextLong();
 
			    max=0;
			    while(ip%2==0)
			    {
			    	max=max(max,2L);
			    	ip/=2;
			    }
 
			    for(long i=3;i<=sqrt(ip);i++)
			    {
			    	while(ip%i==0)
			    	{
			    		max=max(max,i);
			    		ip/=i;
			    	}
			    }
 
			    max=max(max,ip);
			    w.println(max);
			}
			catch(Exception e)
			{
				w.println(max);
			}
 
		}
		
		w.close();
	}
}