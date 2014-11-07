/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given a string S, find the longest palindromic substring in S. You may assume that 
 * the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * 
 * @see <a href="https://oj.leetcode.com/problems/longest-palindromic-substring/">Longest Palindromic Substring on LeetCode</a>
 */
public class LongestPalindrome {
	public String longestPalindrome(String s) {
		if (s == null) return null;
		if (s.length() == 0) return s;
		int n = s.length();
		//_a_b_c_
		char[] cs = new char[2*n+1];
		for (int i=0;i<n;i++) {
			cs[2*i+1] = s.charAt(i);
		}
		int[] len = new int[2*n+1];
		//idx of center of palindrome with right-most edge, idx of center of longest palindrome
		int c = 0, max = 0;
		for (int i=1;i<2*n+1;i++) {
			//idx of right-mode edge, idx of mirrored palindrome
			int r = c + len[c], mir = 2 * c - i;
			//current center larger than palindrome with right most edge
			if (mir < 0) {
				c = i;
				int l = i-1;
				r = i+1;
				while (l >= 0 && r < cs.length && cs[l--] == cs[r++]) {
					len[i]++;
				}
			}
			//left edge of mirrored palindrome inside palindrome with right-most edge
			else if (i + len[mir] < r) {
				len[i] = len[mir];
			}
			//left edge of mirrored palindrome on or over left edge of palindrome with right-most edge
			else {
				c = i;
				len[i] = r - i;
				r = r + 1;
				int l = 2 * i - r;
				while (l >= 0 && r < cs.length && cs[l--] == cs[r++]) {
					len[i]++;
				}
			}
			if (len[i] > len[max]) max = i;
		}
		return s.substring((max-len[max])/2, (max+len[max])/2);
	}
}
