/**
 * @author Yiou Li
 */
package org.yiouli.leetcode;

import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, determine if 
 * s can be segmented into a space-separated sequence of one or 
 * more dictionary words.
 * For example, given 
 * 
 * 	s = "leetcode", 
 * 	dict = ["leet", "code"].
 * 
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * @see <a href="https://oj.leetcode.com/problems/word-break/">Word Break on LeetCode</a>
 */
public class WordBreak {
	public boolean wordBreak(String s, Set<String> dict) {
		int n = s.length();
		boolean[] dp = new boolean[n+1];
		dp[0] = true;
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				if (dp[j] && dict.contains(s.substring(j,i+1))) {
					dp[i+1] = true;
					break;
				}
			}
		}
		return dp[n];
	}
}
