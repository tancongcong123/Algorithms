package com.example.algorithms.sort;

/**
 * 第一个错误的版本
 *
 * 给定 n = 5，并且 version = 4 是第一个错误的版本。
 *
 * 调用 isBadVersion(3) -> false
 * 调用 isBadVersion(5) -> true
 * 调用 isBadVersion(4) -> true
 *
 * 所以，4 是第一个错误的版本
 */
public class FirstBadVersion {

    public static boolean isBadVersion(int version){
        return version>=2?true:false;
    }

    public static void main(String[] args){
        System.out.println(firstBadVersion(2));
        System.out.println(firstBadVersion2(2));
    }

    public static int firstBadVersion(int n) {
        if (isBadVersion(1)){
            return 1;
        }else {
            return findFirstBadVersion(1, n);
        }
    }

    public static int findFirstBadVersion(int start, int end) {
        if (start>end)
            return -1;
        if (end-start==0 || end-start==1)
            return end;
        int middle = (end-start)/2+start;
        if (isBadVersion(middle)){
            return findFirstBadVersion(start, middle);
        }else {
            return findFirstBadVersion(middle, end);
        }
    }

    private static int firstBadVersion2(int n){
        int l=1;
        int h=n;
        while (l<h){
            int m = l+(n-h)/2;
            if (isBadVersion(m)){
                h = m;
            }else {
                l = m+1;
            }
        }
        return h;
    }
}
