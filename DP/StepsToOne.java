package DP;

/*
 * Problem : Minimum Steps to One
 * 
 * On a positive integer, you can perform any one of the following 3 steps. 1.) Subtract 1 from it. 
 * ( n = n - 1 )  , 2.) If its divisible by 2, divide by 2. ( if n % 2 == 0 , then n = n / 2  )  , 3.) 
 * If its divisible by 3, divide by 3. ( if n % 3 == 0 , then n = n / 3  ).
 *  Now the question is, given a positive integer n, find the minimum number of steps that takes n to 1
 *  
 */
import java.util.*;
class MinStepsMemo
{
	static int[] memo;
	static int n;
	MinStepsMemo(int num)
	{
		memo = new int[num+1];
		Arrays.fill(memo,-1);
	}
	public static int getMinStepsMemo(int n)
	{
		if(n==1) return 0;
		if(memo[n]!=-1) return memo[n];
		int r = 1 + getMinStepsMemo(n-1);
		if(n%2==0) r = Math.min(r,1+getMinStepsMemo(n/2));
		if(n%3==0) r =  Math.min(r,1+getMinStepsMemo(n/3));
		memo[n] = r;
		return r;
	}
}
class MinStepsDP
{
	
	public static int getMinStepsDP(int n)
	{
		int[] dp = new int[n+1];
		dp[1] = 0;
		for(int i=2;i<=n;i++)
		{
			dp[i] = 1 + dp[i-1];
			if(i%2==0) dp[i] = Math.min(dp[i],1+dp[i/2]);
			if(i%3==0) dp[i] = Math.min(dp[i],1+dp[i/3]);
		}
		return dp[n];

	}
}

public class StepsToOne
{
	public static void main(String args[])
	{
		System.out.println("Top Down - Memo Version "+MinStepsMemo.getMinStepsMemo(10));
		System.out.println("Bottom up - DP version "+MinStepsDP.getMinStepsDP(10));
	}	
}