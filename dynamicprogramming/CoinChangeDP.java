package dynamicprogramming;
// Problem : 
//Find all combinations of coins when given some dollar value
//Time complexity : Time Complexity: O(mn)
//Dynamic Programming, Bottom up DP.
//Ref : http://stackoverflow.com/questions/1106929/find-all-combinations-of-coins-when-given-some-dollar-value

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
//	    for(int i=0;i<table.length;i++)
//	    {
//	    	for(int j=0;j<table[0].length;j++)
//	    		System.out.print(table[i][j]+" ");
//	    	System.out.println("\n");
//	    }
	    return table[n][m-1];

	}


	public static void main(String args[])
	{
		int[] s = {1,5,10,25};
		int n = 78;
		int res = getChange(n,s);
		System.out.println(res);

	}
}