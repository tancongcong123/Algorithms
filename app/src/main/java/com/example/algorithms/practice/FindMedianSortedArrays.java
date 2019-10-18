package com.example.algorithms.practice;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))
 */
public class FindMedianSortedArrays {

    public static void main(String[] args){
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, null));
        System.out.println(findMedianSortedArrays(null, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lenght1 = nums1==null?0:nums1.length;
        int lenght2 = nums2==null?0:nums2.length;
        int index1 = 0;
        int index2 = 0;
        int[] newSort = new int[lenght1+lenght2];
        int currentIndex = 0;
        while (index1<lenght1 || index2<lenght2){
            if (index1>=lenght1){
                newSort[currentIndex] = nums2[index2];
                index2++;
            }else if (index2>=lenght2){
                newSort[currentIndex] = nums1[index1];
                index1++;
            }else {
                if (nums1[index1]<=nums2[index2]){
                    newSort[currentIndex] = nums1[index1];
                    index1++;
                }else {
                    newSort[currentIndex] = nums2[index2];
                    index2++;
                }
            }
            currentIndex++;
        }
        if (newSort.length%2==0){
            int left = (newSort.length-1)/2;
            int right = (newSort.length-1)/2+1;
            return (newSort[left]+newSort[right])/2.0;
        }else {
            return newSort[(newSort.length-1)/2];
        }
    }
}
