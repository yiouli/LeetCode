/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.hard;

/**
 * Say you have an array for which the ith element is the price of a 
 * given stock on day i.Design an algorithm to find the maximum profit. 
 * You may complete at most two transactions.
 * Note:
 * You may not engage in multiple transactions at the same time (ie, 
 * you must sell the stock before you buy again).
 * 
 * @see <a href="https://oj.leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/">Max Profit III on LeetCode</a>
 */
public class MaxProfit3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int n = prices.length;
        int[] sellBefore = new int[n];
        int[] buyAfter = new int[n];
        int min = prices[0];
        for(int i=1;i<n;i++) {
            sellBefore[i] = Math.max(sellBefore[i-1], prices[i]-min);
            min = Math.min(min, prices[i]);
        }
        int max = prices[n-1];
        for(int i=n-2;i>=0;i--) {
            buyAfter[i] = Math.max(buyAfter[i+1], max-prices[i]);
            max = Math.max(max, prices[i]);
        }
        int profit=0;
        for(int i=0;i<n;i++) {
            int currentProfit = sellBefore[i] + buyAfter[i];
            if (currentProfit > profit) profit = currentProfit;
        }
        return profit;
    }
}
