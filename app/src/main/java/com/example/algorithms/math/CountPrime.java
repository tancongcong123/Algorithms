package com.example.algorithms.math;

import java.util.HashMap;

/**
 * 统计所有小于非负整数 n 的质数的数量
 *
 * 输入: 10
 * 输出: 4
 * 解释: 小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7
 */
public class CountPrime {

    private static HashMap<Integer, Boolean> list = new HashMap<>();

    public static void main(String[] args){
        System.out.println(countPrimes(10));
        System.out.println(isPrimes(499979));
        System.out.println(countPrimes(499979));
    }

    /**
     * smart
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        int result = 0;

        for (int i = 2; i < n; i++) {
            isPrime[i] = true; //先初始化为true
        }

        for (int i = 2; i * i < n; i++) { //这一次for循环找出所有不是素数的数（也就是说被筛掉了）
            if (!isPrime[i]) {
                //既然已经被筛掉了就不用管了
                continue;
            }
            else {
                for (int j = i * i; j < n; j += i) {
                    //由于i现在是一个质数, 那么i的平方一定不是质数，i^2 + i; i^2 + 2i也一定不是素数
                    isPrime[j] = false;
                }
            }
        } //所有不是质数的数已经全部筛掉

        //计算剩余的质数个数
        for (int i = 2; i < n; i++) {
            if (isPrime[i] == true) {
                result++;
            }
        }
        return result;
    }

    public static int countPrimes2(int n) {
        int[] res = new int[n];
        res[2] = 1;
        res[3] = 2;
        res[4] = 2;
        res[5] = 3;
        for (int i=6; i<n;i++){
            res[i] = res[i-1]+(isPrimes(i)?1:0);
        }
        return res[n-1];
    }

    public static boolean isPrimes(int p){
        if (list.containsKey(p))
            return list.get(p);
        for (int i=2; i<p;i++){
            if (p%i==0){
                list.put(p, false);
                return false;
            }
        }
        list.put(p, true);
        return true;
    }
}
