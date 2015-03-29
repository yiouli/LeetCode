/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the 
 * same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * @see <a href="https://oj.leetcode.com/problems/sort-colors/">Sort Colors on LeetCode</a>
 */
public class SortColors {
	
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    public void sortColors(int[] A) {
        int i=0, r=0, b=A.length-1;
        while (i <= b) {
            switch(A[i]) {
                case 0: swap(A, i++, r++); break;
                case 1: i++; break;
                case 2: swap(A, i, b--); break;
            }
        }
    }
}
