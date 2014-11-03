/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given an array of integers, every element appears twice except for one. 
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement
 * it without using extra memory?
 *  
 * @see <a href="https://oj.leetcode.com/problems/single-number/">Single Number on LeetCode</a>
 */
public class SingleNumber {
    public int singleNumber(int[] A) {
        int ret = 0;
        for (int i=0;i<A.length;i++) {
            ret^=A[i];
        }
        return ret;
    }
}
