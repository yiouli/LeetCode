/**
 * @author Yiou Li
 */
package org.yiouli.leetcode;

/**
 * Determine whether an integer is palindromic. Do this without extra space.
 * 
 * @see <a href="http://en.wikipedia.org/wiki/Palindromic_number">Wikipedia for Palindromic number</a>
 * @see <a href="https://oj.leetcode.com/problems/palindrome-number/">Palindrome number on LeetCode</a>
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int power = (int) Math.log10(x);
        while (power > 0) {
            int pow10 = (int)Math.pow(10, power) ;
            if (x / pow10 != x % 10) return false;
            x = (x % pow10) / 10;
            power -= 2;
        }
        return true;
    }
}
