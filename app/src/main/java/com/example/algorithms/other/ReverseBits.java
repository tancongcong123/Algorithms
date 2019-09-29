package com.example.algorithms.other;

import android.annotation.SuppressLint;

/**
 * 颠倒给定的 32 位无符号整数的二进制位
 *
 * 输入: 00000010100101000001111010011100
 * 输出: 00111001011110000010100101000000
 * 解释: 输入的二进制串 00000010100101000001111010011100 表示无符号整数 43261596，
 *       因此返回 964176192，其二进制表示形式为 00111001011110000010100101000000
 */
public class ReverseBits {

    public static void main(String[] args){
        System.out.println(reverseBits(0b00000010100101000001111010011100));
        System.out.println("---------------------------------------");
        System.out.println(reverseBits2(0b00000010100101000001111010011100));
        System.out.println("---------------------------------------");
        System.out.println(reverseBits3(0b00000010100101000001111010011100));
    }

    public static String toBinaryString(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<32-binary.length();i++){
            stringBuilder.append("0");
        }
        stringBuilder.append(binary);
        return stringBuilder.toString();
    }

    /**
     * 那么依次将原数从左往右移动一位，取出移动的位判断是0还是1，然后加到反转的结果上，
     * 并且反转的结果是从右往左移动一位，循环控制的次数为32次，因为是32位整数
     * @param n
     * @return
     */
    public static int reverseBits(int n) {
        int result = 0;
        for (int i=0; i<32; i++) {
            result = (result << 1) | (n & 1);
            n >>= 1;
        }
        return result;
    }

    /***************************************************************/
    /**
     * 字符串反转在转乘数
     * @param n
     * @return
     */
    public static int reverseBits2(int n) {
        String inputBinary = decimalToBinary(n);
        String reversedInputBinary = new StringBuilder(inputBinary).reverse().toString();
        return binaryToDecimal(reversedInputBinary);
    }

    @SuppressLint("NewApi")
    private static String decimalToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while (Integer.compareUnsigned(n, 0) > 0) {
            sb.append(Integer.remainderUnsigned(n, 2));
            n = Integer.divideUnsigned(n, 2);
        }
        while (sb.length() < 32) {
            sb.append('0');
        }
        return sb.reverse().toString();
    }

    private static int binaryToDecimal(String str) {
        int res = 0;
        for (char c: str.toCharArray()) {
            res *= 2;
            res += c == '0' ? 0 : 1;
        }
        return res;
    }

    /***************************************************************/
    /**
     * 字符串反转在转乘数
     * @param n
     * @return
     */
    public static int reverseBits3(int n) {
        return Integer.reverse(n);
    }
}
