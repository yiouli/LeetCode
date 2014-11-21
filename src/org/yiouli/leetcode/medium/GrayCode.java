/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of 
 * gray code. A gray code sequence must begin with 0.
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 00 - 0
 * 01 - 1
 * 11 - 3
 * 10 - 2
 * 
 * @see <a href="https://oj.leetcode.com/problems/gray-code/">Gray Code on LeetCode</a>
 */
public class GrayCode {
	public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(0);
        if (n<1) return ret;
        int plus = 1;
        while (plus>>n == 0) {
            for (int i = ret.size()-1; i>=0; i--) {
                ret.add(plus + ret.get(i));
            }
            plus<<=1;
        }
        return ret;
    }
}
