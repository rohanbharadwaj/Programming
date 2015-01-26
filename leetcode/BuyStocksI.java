package leetcode;

/*
 * Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction 
 (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Array 
 Dynamic Programming
 * 
 */
public class BuyStocksI {

	public int maxProfit(int[] prices) {
		if (prices.length <= 1)
			return 0;

		int profit = 0;
		int min = prices[0];
		for (int i = 0; i < prices.length; i++) {
			min = Math.min(min, prices[i]); // update min of the elements
			profit = Math.max(profit, prices[i] - min); // DP step update profit with prev and cura
		}
		return profit;

	}
}