package org.yiouli.leetcode.medium;

public class Sqrt {
    public int sqrt(int x) {
        if (x <= 0) return 0;
        int start = 1, end = x;
        while (start < end) {
            int mid = start+(end-start+1)/2;
            if (mid == x/mid) return mid;
            else if (mid < x/mid) start = mid;
            else end = mid-1;
        }
        return start;
    }
}
