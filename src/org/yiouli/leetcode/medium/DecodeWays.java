/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * For example,
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * The number of ways decoding "12" is 2.
 * 
 * @see <a href="https://leetcode.com/problems/decode-ways/">Decode Ways on LeetCode</a>
 */
public class DecodeWays {
	public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0]=dp[1]=1;
        for (int i=2;i<dp.length;i++) {
            char c = s.charAt(i-1), prev = s.charAt(i-2);
            if (c > '9' || c < '0') return 0;
            if (c == '0' && (prev != '1' && prev != '2')) return 0;
            if (c == '0' && (prev == '1' || prev == '2')) dp[i] = dp[i-2];
            else if (prev == '1' || (c <= '6' && prev == '2')) dp[i] = dp[i-1] + dp[i-2];
            else dp[i] = dp[i-1];
        }
        return dp[s.length()];
    }
}
