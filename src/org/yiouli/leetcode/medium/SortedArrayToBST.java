/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * @see <a href="https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/">Sorted Array to BST on LeetCode</a>
 */
public class SortedArrayToBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
    private TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid-1);
        root.right = sortedArrayToBST(num, mid+1, end);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] num) {
        return sortedArrayToBST(num, 0, num.length-1);
    }
}
