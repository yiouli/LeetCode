/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.easy;

import java.util.HashMap;

/**
 * Given an array of integers, find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target
 * , where index1 must be less than index2. Please note that your returned answers (both index1 and
 * index2) are not zero-based.
 * You may assume that each input would have exactly one solution.
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * 
 * @see <a href="https://oj.leetcode.com/problems/two-sum/">Two Sum on LeetCode</a>
 */
public class TwoSum {
	public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for (int i=0;i<numbers.length;i++) {
            int val = numbers[i];
            if (map.containsKey(val)) return new int[]{map.get(val)+1,i+1};
            map.put(target-val, i);
        }
        return null;
    }
}
