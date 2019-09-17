package com.example.algorithms.dynamicProgramming;

/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数
 *
 * output：
 * 3
 * 5
 * 8
 * 13
 * -------------
 * start time: 1568683163693
 * 1134903170
 * end time: 1568683165726
 * -------------
 * start time: 1568683165726
 * 1134903170
 * end time: 1568683165726
 * -------------
 * start time: 1568683165727
 * 1134903170
 * end time: 1568683165727
 *
 * 当n=44时
 * 方法一使用递归耗时33ms
 * 方法二和方法三使用循环耗时0ms
 */
public class ClimbStairs {

    public static void main(String[] args){
        System.out.println(climbStairs2(3));
        System.out.println(climbStairs2(4));
        System.out.println(climbStairs2(5));
        System.out.println(climbStairs2(6));
        System.out.println("-------------");
        System.out.println("start time: "+System.currentTimeMillis());
        System.out.println(climbStairs(44));
        System.out.println("end time: "+System.currentTimeMillis());
        System.out.println("-------------");
        System.out.println("start time: "+System.currentTimeMillis());
        System.out.println(climbStairs2(44));
        System.out.println("end time: "+System.currentTimeMillis());
        System.out.println("-------------");
        System.out.println("start time: "+System.currentTimeMillis());
        System.out.println(climbStairs3(44));
        System.out.println("end time: "+System.currentTimeMillis());
    }

    /**
     * 耗时
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n==1){
            return 1;
        }else if (n==2){
            return 2;
        }else {
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }

    /**
     * 利用数组把数据缓存起来
     * @param n
     * @return
     */
    public static int climbStairs2(int n) {
        if (n==1){
            return 1;
        }else if (n==2){
            return 2;
        }else {
            int[] sum = new int[n+1];
            sum[0] = 0;
            sum[1] = 1;
            sum[2] = 2;
            for (int i=3;i<=n;i++){
                sum[i] = sum[i-1]+sum[i-2];
            }
            return sum[n];
        }
    }

    /**
     * 缓存n前面两个数据 更节省空间
     * @param n
     * @return
     */
    public static int climbStairs3(int n) {
        int f0 = 0, f1 = 1;
        int f = 0;
        while (n-- > 0) {
            f = f0 + f1;
            f0 = f1;
            f1 = f;
        }
        return f;

    }
}
