/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Implement pow(x, n).
 * 
 * @see <a href="https://leetcode.com/problems/powx-n/">Pow(x,n) on LeetCode</a> 
 */
public class Pow {
    public double pow(double x, int n) {
        if (n < 0) return 1.0d / x / pow(x, -(n+1));
        double ret = 1.0d;
        while (n > 0) {
            if ((n&1) > 0) ret *= x;
            x*=x;
            n>>>=1;
        }
        return ret;
    }

    public double powRec(double x, int n) {
        if (n == 0) return 1.0d;
        if (n < 0) return 1.0d / x / powRec(x, -(n+1));
        double sqrt = powRec(x, n/2);
        return n % 2 > 0 ? sqrt * sqrt * x : sqrt * sqrt;
    }
}
