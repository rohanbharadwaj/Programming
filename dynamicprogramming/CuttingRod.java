package dynamicprogramming;

import java.util.Arrays;

public class CuttingRod {

	private static int maxProfitRecursive(int[] p,int n) {
		if (n==0) return 0;
		int q = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			// p[i-1] because the index starts from 0
			//p[i-1] = price for i length cut;
			q = Math.max(q, p[i-1]+maxProfitRecursive(p,n-i));
		}
		return q;
	}
	
	private static int maxProfitBottomUp(int[] p,int n){ // DP
		int[] r = new int[n+1];
		r[0]=0;
		for(int j=1;j<=n;j++){
			int q = Integer.MIN_VALUE;
			for(int i=1;i<=j;i++){
				q=Math.max(q, p[i-1]+r[j-i]);
			}
			r[j]=q;
		}
		return r[n];
	}
	
	private static int maxProfitMemoized(int[] p,int n) {
		// TODO Auto-generated method stub
		int[] r = new int[n+1];
		Arrays.fill(r, Integer.MIN_VALUE);
		r[0]=0;
		return maxProfitMemoized(p,n,r);

	}
	
	private static int maxProfitMemoized(int[] p,int n,int[] r) {
		// TODO Auto-generated method stub
		if(r[n]!=Integer.MIN_VALUE) return r[n];
		int q = Integer.MIN_VALUE;
		for(int i=1;i<=n;i++){
			// p[i-1] because the index starts from 0
			//p[i-1] = price for i length cut;
			q = Math.max(q, p[i-1]+maxProfitRecursive(p,n-i));
		}
		r[n]=q;
		return r[n];
	}
	
	public static void main(String[] args) {
		int[] p = {1,5,8,9,10,17,17,20};
		System.out.println(maxProfitRecursive(p,8));
		System.out.println(maxProfitBottomUp(p,8));
		System.out.println(maxProfitMemoized(p, 8));
	}
}
