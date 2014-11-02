/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one
 *  share of the stock), design an algorithm to find the maximum profit.
 *  
 *  @see <a href="https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-/">Max Profit on LeetCode</a>
 */
public class MaxProfit {
	public int maxProfit(int[] prices) {
		if (prices == null || prices.length < 2) return 0;
		int profit = 0, min = prices[0];
		for (int i=1;i<prices.length;i++) {
			profit = Math.max(prices[i]-min, profit);
			min = Math.min(prices[i], min);
		}
		return profit;
	}
}
