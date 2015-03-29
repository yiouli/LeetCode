package org.yiouli.leetcode.easy;

import java.util.Arrays;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @see <a href="https://leetcode.com/problems/plus-one/">Plus One on LeetCode</a>
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] ret = new int[n+1];
        boolean carry = true;
        for (int i=0;i<n;i++) {
            if (!carry) ret[n-i] = digits[n-i-1];
            else {
                ret[n-i] = (digits[n-i-1]+1)%10;
                carry = (ret[n-i] == 0);
            }
        }
        if (carry) ret[0] = 1;
        else ret = Arrays.copyOfRange(ret, 1, n+1);
        return ret;
    }
}
