package com.example.algorithms.sort;

import com.example.algorithms.PrintUtils;

import java.util.Arrays;

/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组
 * ps:
 *  初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *  你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素
 */
public class SortAndMerge {

    private static int[] number1 = {1,2,5,6,0,0};
    private static int m = 4;
    private static int[] number2 = {3,4};
    private static int n = 2;

    public static void main(String[] args){
        merge2(number1, m, number2, n);
        System.out.println(PrintUtils.toString(number1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m;
        int index2 = 0;
        while (index<(m+n)){
            nums1[index] = nums2[index2];
            index++;
            index2++;
        }
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0&&j>=0){
            if(nums1[i]>=nums2[j]){
                nums1[k--]=nums1[i--];
            }else{
                nums1[k--]=nums2[j--];
            }
        }

        while(j>=0){
            nums1[k--]=nums2[j--];
        }
    }
}
