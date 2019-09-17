package com.example.algorithms.dynamicProgramming;

/**
 * 买卖股票的最佳时机
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润
 * 注意你不能在买入股票前卖出股票
 */
public class MaxProfit {

    public static void main(String[] args){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }

    public static int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i=0; i< prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }else if(prices[i] - min > max){
                max = prices[i] -min;
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int profit = 0;
        if (prices==null || prices.length<2)
            return profit;
        for(int i=0;i<prices.length;i++){
            for(int j=i+1;j<prices.length;j++){
                int currentProfit = prices[j]-prices[i];
                profit = currentProfit>profit?currentProfit:profit;
            }
        }
        return profit;
    }
}
