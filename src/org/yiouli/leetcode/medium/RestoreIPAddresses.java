package org.yiouli.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * 
 * @see <a href="https://oj.leetcode.com/problems/restore-ip-addresses/">Restore IP Addresses on LeetCode</a>
 */
public class RestoreIPAddresses {
    
    private void findAll(String s, int startIdx, int prefixCount, int[] prefix, List<String> result) {
        if (prefixCount == 4 && startIdx == s.length()) {
            StringBuffer buf = new StringBuffer();
            for (int i=0;i<prefix.length;i++) {
                if (i!=0) buf.append('.');
                buf.append(prefix[i]);
            }
            result.add(buf.toString());
        }
        else if (startIdx < s.length() && prefixCount < 4) {
            int val = 0;
            while (startIdx < s.length()) {
                val*=10;
                val+=s.charAt(startIdx)-'0';
                if (val>255) break;
                prefix[prefixCount] = val;
                findAll(s, ++startIdx, prefixCount+1, prefix, result);
                //special case, no leading 0
                if (val==0) break;
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> ret = new ArrayList<String>();
        if (s != null) findAll(s, 0, 0, new int[4], ret);
        return ret;
    }
}
