/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given an array of integers, every element appears three times except for one. Find that single one.
 * 
 * @see <a href="https://oj.leetcode.com/problems/single-number-ii/">Single Number II on LeetCode</a>
 */
public class SingleNumber2 {
    public int singleNumber(int[] A) {
    	//use two int to count the occurance for each bit
    	//00->01->10->00
        int ones = 0, twos = 0;
        for (int val : A) {
            twos ^= ones & val;
            ones ^= val;
            int reset = ones & twos;
            twos &= ~reset;
            ones &= ~reset;
        }
        return twos^ones;
    }
}
