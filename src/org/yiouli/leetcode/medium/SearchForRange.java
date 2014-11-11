/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @see <a href="https://oj.leetcode.com/problems/search-for-a-range/">Search For Range on LeetCode</a>
 */
public class SearchForRange {
    
    //idx of first elem that A[idx]>=target, start if all>target, end+1 if all<target
    private int searchLeft(int[] A, int target, int start, int end) {
        if (end < start) return start;
        int mid = (start+end)/2;
        if (A[mid]>=target) return searchLeft(A, target, start, mid-1);
        else return searchLeft(A, target, mid+1, end);
    }
    
    //idx of last elem that A[idx]<=target, start-1 if all>target, end if all<target
    private int searchRight(int[] A, int target, int start, int end) {
        if (end < start) return start-1;
        int mid = (start+end)/2;
        if (A[mid]>target) return searchRight(A, target, start, mid-1);
        else return searchRight(A, target, mid+1, end);
    } 
    
    public int[] searchRange(int[] A, int target) {
        if (A == null || A.length == 0) return new int[]{-1,-1};
        int left = searchLeft(A, target, 0, A.length-1);
        int right = searchRight(A, target, 0, A.length-1);
        if (left > right) return new int[]{-1,-1};
        return new int[]{left, right};
    }
}
