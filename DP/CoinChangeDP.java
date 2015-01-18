package DP;

//Time complexity : Time Complexity: O(mn)
//Dynamic Programming, Top Down using memoization 
public class CoinChangeDP
{
	public static int getChange(int n,int[] S)
	{
		int x,y;
		int m = S.length;
		int[][] table = new int[n+1][m];
		
			for (int i=0; i<m; i++)
	        table[0][i] = 1;
 		
    	// Fill rest of the table enteries in bottom up manner  
	    for (int i = 1; i < n+1; i++)
	    {
	        for (int j = 0; j < m; j++)
	        {
	            // Count of solutions including S[j]
	            x = (i-S[j] >= 0)? table[i - S[j]][j]: 0;
	 
	            // Count of solutions excluding S[j]
	            y = (j >= 1)? table[i][j-1]: 0;
	 
	            // total count
	            table[i][j] = x + y;
	        }
	    }
	    return table[n][m-1];

	}


	public static void main(String args[])
	{
		int[] s = {1,5,10,25,50};
		int n = 6;
		int res = getChange(n,s);
		System.out.println(res);

	}
}