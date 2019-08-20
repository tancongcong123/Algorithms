package com.example.algorithms.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票
 */

public class Array8 {

    private static int[] numbers = {1,2,3,4,5,6};
    private static int[] numbers1 = {6,5,4,3,2,1};

    public static void main(String[] args){
        System.out.println(maxProfit2(numbers1));
    }

    public static int maxProfit(int[] prices) {
        if (prices==null || prices.length<1)
            return 0;
        int profit = 0;
        int boughtPrice = 0;
        int index = 0;
        boolean bought = false;
        int prePrice = prices[0];
        while (index<prices.length){
            if (bought){
                if (prices[index]<prePrice){
                    bought = false;
                    profit = profit+(prePrice-boughtPrice);
                }else {
                    if(index == prices.length-1){
                        profit = profit+(prices[index]-boughtPrice);
                    }
                }
            }else {
                if (prices[index]>prePrice){
                    bought = true;
                    boughtPrice = prePrice;
                }
                if(bought && index == prices.length-1){
                    profit = profit+(prices[index]-boughtPrice);
                }
            }
            prePrice = prices[index];
            index++;
            System.out.println(profit);
        }
        return profit;
    }

    public static int maxProfit2(int[] prices) {
        if (prices==null || prices.length<1)
            return 0;
        int profit = 0;
        int boughtPrice = prices[0];
        int prePrice = prices[0];
        for(int i=0;i<prices.length-1;i++){
            if (prePrice>=prices[i+1]){
                profit = profit+(prices[i]-boughtPrice);
                boughtPrice = prices[i+1];
            }
            prePrice = prices[i+1];
        }
        profit = profit+(prices[prices.length-1]-boughtPrice);
        return profit;
    }
}
