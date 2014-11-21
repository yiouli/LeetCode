/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 * 
 * @see <a href="https://oj.leetcode.com/problems/find-minimum-in-rotated-sorted-array/">Find Minimum in Rotated Sorted Array on LeetCode</a>
 */
public class MinimumInRotatedSortedArray {
	private int findMin(int[] num, int start, int end) {
        if (start==end || num[start] < num[end]) return num[start];
        int mid = (start+end)/2;
        if (num[mid]>num[end]) return findMin(num, mid+1, end);
        //impossible to go in here if mid = start (end = start+1)
        else return findMin(num, start, mid);
    }
    
    public int findMin(int[] num) {
        if (num.length == 0) return Integer.MIN_VALUE;
        return findMin(num, 0, num.length-1);
    }
}
