/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 *     (-1,  0, 0, 1)
 *     (-2, -1, 1, 2)
 *     (-2,  0, 0, 2)
 *     
 * @see <a href="https://leetcode.com/problems/4sum/">4Sum on LeetCode</a>
 */
public class FourSum {
    
    private int skipSameToRight(int[] num, int current, int right) {
        int left = num[current];
        while (++current < right && left == num[current]);
        return current;
    }
    
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(num);
        for (int i=0;i<num.length-3;) {
            for (int j=i+1;j<num.length-2;) {
                int a=j+1, b=num.length-1;
                while (a<b) {
                    int sum = num[i]+num[j]+num[a]+num[b];
                    if (sum == target) ret.add(Arrays.asList(num[i], num[j], num[a], num[b]));
                    if (sum <= target) a = skipSameToRight(num, a, b);
                    if (sum >= target) {
                        int right = num[b];
                        while (--b > a && num[b] == right);
                    }
                }
                j = skipSameToRight(num, j, num.length-2);
            }
            i = skipSameToRight(num, i, num.length-3);
        }
        return ret;
    }

}
