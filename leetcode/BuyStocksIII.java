package leetcode;

/*Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 */

public class BuyStocksIII {

	private int maxProfit(int[] prices) {
	  	if(prices.length<=1) return 0;
			int k =2;
			int[][] table = new int[k+1][prices.length];
			for(int i=1;i<=k;i++){
				int tmpMax = table[i-1][0]-prices[0];
				for(int j=1;j<prices.length;j++){
					table[i][j]=Math.max(table[i][j-1], prices[j]+ tmpMax);
					tmpMax = Math.max(tmpMax, table[i-1][j]-prices[j]);
				}
			}
			return table[k][prices.length-1];		
	}
	
}
