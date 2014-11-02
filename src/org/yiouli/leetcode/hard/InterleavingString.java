/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.hard;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * For example, Given:
 * s1 = "aabcc",
 * s2 = "dbbca",
 * When s3 = "aadbbcbcac", return true.
 * When s3 = "aadbbbaccc", return false.
 * 
 * @see <a href="https://oj.leetcode.com/problems/interleaving-string/">Interleaving String on LeetCode</a>
 */
public class InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		int n = s1.length(), m = s2.length();
		if (s3.length() != n + m) return false;
		boolean[][] dp = new boolean[n+1][m+1];
		dp[0][0] = true;
		for (int i=0; i<n; i++) {
			dp[i+1][0] = dp[i][0] && s1.charAt(i) == s3.charAt(i);
		}
		for (int j=0; j<m; j++) {
			dp[0][j+1] = dp[0][j] && s2.charAt(j) == s3.charAt(j);
		}
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				dp[i+1][j+1] = (dp[i][j+1] && s1.charAt(i) == s3.charAt(i+j+1))
						|| (dp[i+1][j] && s2.charAt(j) == s3.charAt(i+j+1));
			}
		}
		return dp[n][m];
	}
}
