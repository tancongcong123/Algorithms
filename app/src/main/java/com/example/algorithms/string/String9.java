package com.example.algorithms.string;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转
 * 则其数值范围为 [−2^31,  2^31 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0
 */
public class String9 {

    private static long number2 = 9646324351L;
    private static int number = -123;

    public static void main(String[] args){
        System.out.println(reverse(number));
        System.out.println(reverse2(number));
    }

    public static int reverse(int x) {
        long a = 0;
        int b;
        if(x>=0){
            b=(x+"").length();//正数
        }else{
            b=(x+"").length()-1;//负数有一个负号
        }
        for(int i=0;i<b;i++){
            int a1 = x%10;//当前最后一位数字 ，负数则显示的是负数-25%10 等于 -5
            x=(x-a1)/10;//把最后一位数字剔除掉的新数字
            a += (int) (a1*Math.pow(10,b-i-1));  //相当于将每次的最后一位乘以当前位在十进制中的权重。234 = 2*10^2+3*10^1+4*10^0
        }
        if((a>Math.pow(2,31)-1)||(a<(-1)*Math.pow(2,31))){  //超过范围的返回0
            return 0;
        }
        return (int) a;
    }

    public static int reverse2(int x) {
        int rev=0;
        int pop;
        while(x!=0){
            pop= x % 10;
            x=x/10;
            if(rev>Integer.MAX_VALUE/10){
                return 0;
            }
            if(rev<Integer.MIN_VALUE/10){
                return 0;
            }
            rev=rev*10+pop;
        }
        return rev;
    }
}
