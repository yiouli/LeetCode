/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * A peak element is an element that is greater than its neighbors.
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * You may imagine that num[-1] = num[n] = -∞.
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 * 
 * @see <a href="https://leetcode.com/problems/find-peak-element/">Find Peak Element on LeetCode</a>
 */
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        int start = 0, end = num.length - 1;
        while (start != end) {
            int mid = (start+end)/2;
            if (num[mid] < num[mid+1]) start = mid+1;
            else end = mid;
        }
        return start;
    }
}
