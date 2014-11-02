/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

/**
 * Implement atoi to convert a string to an integer.
 * 
 * Requirements for atoi:
 * 
 * The function first discards as many whitespace characters as necessary 
 * until the first non-whitespace character is found. Then, starting from 
 * this character, takes an optional initial plus or minus sign followed 
 * by as many numerical digits as possible, and interprets them as a 
 * numerical value.
 * 
 * The string can contain additional characters after those that form the 
 * integral number, which are ignored and have no effect on the behavior 
 * of this function.
 * 
 * If the first sequence of non-whitespace characters in str is not a valid 
 * integral number, or if no such sequence exists because either str is empty 
 * or it contains only whitespace characters, no conversion is performed.
 * 
 * If no valid conversion could be performed, a zero value is returned. If the 
 * correct value is out of the range of representable values, INT_MAX (2147483647) 
 * or INT_MIN (-2147483648) is returned.
 * 
 * @see <a href="https://oj.leetcode.com/problems/string-to-integer-atoi/">String to Integer on LeetCode</a>
 */
public class StringToInteger {
	//return negative if not 0-9
	private int ctoi(char c) {
		int digit = c - '0';
		if (digit > 9) return -1;
		return digit;
	}

	private int atoiN(char[] chars, int startIdx) {
		int val = 0;
		for (int i = startIdx; i < chars.length; i++) {
			int digit = ctoi(chars[i]);
			if (digit < 0) break;
			if (val < (Integer.MIN_VALUE + digit) / 10) return Integer.MIN_VALUE;
			val = val * 10 - digit;
		}
		return val;
	}

	private int atoi(char[] chars, int startIdx) {
		int val = 0;
		for (int i = startIdx; i < chars.length; i++) {
			int digit = ctoi(chars[i]);
			if (digit < 0) break;
			if (val > (Integer.MAX_VALUE - digit) / 10) return Integer.MAX_VALUE;
			val = val * 10 + digit;
		}
		return val;
	}

	public int atoi(String str) {
		str = str.trim();
        if (str.length() == 0) return 0;
		char[] chars = str.toCharArray();
		char fc = chars[0];
		if (fc == '+') return atoi(chars, 1);
		else if (fc == '-') return atoiN(chars, 1);
		else if (ctoi(fc) >= 0) return atoi(chars, 0);
		else return 0;
	}
}
