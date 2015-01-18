package DP;

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