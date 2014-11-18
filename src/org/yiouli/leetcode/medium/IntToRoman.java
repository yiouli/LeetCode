/**
 * @author Yiou Li
 */
package org.yiouli.leetcode.medium;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * @see <a href="https://oj.leetcode.com/problems/integer-to-roman/">Integer To Roman on LeetCode</a>
 */
public class IntToRoman {
	public String intToRoman(int num) {
        StringBuilder buf = new StringBuilder();
        String romans = "MDCLXVI";
        int[] vals = new int[] {1000,500,100,50,10,5,1};
        for(int i=0;i<vals.length;i++) {
            for (int j= num/vals[i];j>0;j--) buf.append(romans.charAt(i));
            num %= vals[i];
            if (i < 6 && num >= vals[i]-vals[i/2*2+2]) {
                buf.append(romans.charAt(i/2*2+2));
                buf.append(romans.charAt(i));
                num -= vals[i]-vals[i/2*2+2];
            }
        }
        return buf.toString();
    }
}
