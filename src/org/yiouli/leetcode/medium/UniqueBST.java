/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 *   
 * @see <a href="https://leetcode.com/problems/unique-binary-search-trees/">Unique BST on LeetCode</a>
 */
public class UniqueBST {
	public int numTrees(int n) {
        //chose i as root, the number of bst is num of left bst * num of right bst
        //f(n) = SUM(f(i-1)*f(n-i)) for i = 1 to n
        //f(0) = 1, f(1) = 1
        if(n<2) return 1;
        int[] f = new int[n+1];
        f[0]=f[1]=1;
        for (int i=2;i<=n;i++) {
            for(int j=1;j<=i;j++) {
                f[i]+=f[j-1]*f[i-j];
            }
        }
        return f[n];
    }
}
