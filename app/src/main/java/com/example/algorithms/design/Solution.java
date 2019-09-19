package com.example.algorithms.design;

import java.util.Random;

public class Solution {

    private int[] original;
    private Random rng = new Random();
    private int[] copy;
    private int num;
    public Solution(int[] nums) {
        original = nums;
        copy=original.clone();
        num=original.length;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array.
     *  swap position to shuffle an array
     **/
    public int[] shuffle() {
        int n = num;
        while(n>1) {
            n--;
            int k = rng.nextInt(n + 1);
            int value = copy[k];
            copy[k] = copy[n];
            copy[n] = value;
        }
        return copy;
    }
}
