/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

import java.util.Arrays;

/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * 
 * @see <a href="https://leetcode.com/problems/add-binary/">Add Binary on LeetCode</a>
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        int n = a.length(), m = b.length();
        if (n < m) return addBinary(b, a);
        char[] zeroes = new char[n-m];
        Arrays.fill(zeroes, '0');
        b = new String(zeroes) + b;
        char[] res=new char[n];
        int carry=0;
        for (int i=n-1;i>=0;i--) {
            int x = a.charAt(i)-'0', y = b.charAt(i)-'0';
            int val = x + y + carry;
            res[i] = (char)('0' + (val%2));
            carry = val/2;
        }
        return carry == 1 ? '1' + new String(res) : new String(res);
    }
}
