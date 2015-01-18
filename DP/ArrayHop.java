package DP;

import java.util.*;
public class ArrayHop{
	public static int getHops(int arr[])
	{
		int n = arr.length;
		int[] hop = new int[n];
		if(n==0 || arr[0]==0) return Integer.MAX_VALUE;
		Arrays.fill(hop,Integer.MAX_VALUE);
		hop[0]=0;
		for(int i=1;i<n;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(i<=j+arr[j] && hop[j]!=Integer.MAX_VALUE)
				{
					hop[i] = Math.min(hop[i],hop[j]+1);
					break;
				}
			}

		}
		return hop[n-1];

	}
	public static void main(String args[])
	{
		int arr[] = {1, 3, 6, 1, 0, 9};
		System.out.println(getHops(arr));
	}
}