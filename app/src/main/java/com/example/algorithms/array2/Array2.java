package com.example.algorithms.array2;

import com.example.algorithms.PrintUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个数组，编写一个函数来计算它们的交集
 * [4,9,5]
 * [9,4,9,8,4]
 */
public class Array2 {

    private static int[] nums = {4,4,5};
    private static int[] nums2 = {9,4,9,8,4};

    public static void main(String[] args){
        System.out.println("intersect=="+ PrintUtils.toString(intersect(nums, nums2)));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1==null || nums2==null || nums1.length<1 || nums2.length<1)
            return new int[0];
        int len1=nums1.length;
        int len2=nums2.length;
        boolean[] bl=new boolean[len2];
        ArrayList<Integer> al=new ArrayList<>();
        for(int i=0;i<len1;i++) {
            for(int j=0;j<len2;j++) {
                if(nums1[i]==nums2[j] && bl[j]==false) {
                    al.add(nums1[i]);
                    bl[j]=true;
                    break;
                }
            }
        }
        int[] in = new int[al.size()];
        int e=0;
        for(int i:al)
            in[e++] = i;
        return in;
    }

    // best
    public int[] intersect2(int[] nums1, int[] nums2) {
        if(nums1==null || nums2==null) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] arr = new int[l1>l2?l2:l1];

        int i=0;
        int j=0;
        int k = 0;
        while(i<l1 && j<l2){
            if(nums1[i] < nums2[j]){
                i++;
            } else if(nums1[i] > nums2[j]){
                j++;
            } else {
                arr[k] = nums1[i];
                k++;
                i++;
                j++;
            }
        }

        int[] temp = new int[k];
        for(int q=0;q<k;q++){
            temp[q] = arr[q];
        }

        return temp;
    }

    //better
    public int[] intersect3(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums1.length;i++) {
            Integer val=map.get(nums1[i]);
            map.put(nums1[i], (val==null)?1:++val);
        }
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0,val;i<nums2.length;i++) {
            if(map.containsKey(nums2[i]) && (val=map.get(nums2[i]))>0) {
                al.add(nums2[i]);
                map.put(nums2[i], --val);
            }
        }

        int[] in = new int[al.size()];
        int e=0;
        for(int i:al)
            in[e++] = i;
        return in;

    }
}
