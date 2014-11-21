/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.hard;

/**
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 * 
 * @see <a href="https://oj.leetcode.com/problems/edit-distance/">Edit Distance on LeetCode</a>
 */
public class EditDistance {
	public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return -1;
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i=0;i<=m;i++) dp[i][0]=i;
        for (int j=0;j<=n;j++) dp[0][j]=j;
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                dp[i+1][j+1] = Math.min(dp[i][j+1], dp[i+1][j]) + 1;
                int dif = word1.charAt(i) == word2.charAt(j) ? 0 : 1;
                dp[i+1][j+1] = Math.min(dp[i+1][j+1], dp[i][j] + dif);
            }
        }
        return dp[m][n];
    }
}
