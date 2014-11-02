/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * @see <a href="https://oj.leetcode.com/problems/reverse-integer/">Reverse Integer on LeetCode</a>
 */
public class ReverseInteger {
	public int reverse(int x) {
        if (x < 0) return 0-reverse(0-x);
        int rev = 0;
        while (x > 0) {
            int digit = x % 10;
            x /= 10;
            rev *= 10;
            rev += digit;
        }
        return rev;
    }
}
