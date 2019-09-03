package com.example.algorithms.string2;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]
 *
 * output:
 *      42
 *      -2147483648
 *      2147483647
 *      2147483647
 *      147483
 *      0
 *      1
 *      0
 */
public class String4 {

    public static void main(String[] args){
        System.out.println(myAtoi2("   -42"));
        System.out.println(myAtoi2("-91283472332"));
        System.out.println(myAtoi2("+91283472332"));
        System.out.println(myAtoi2("+2147483649"));
        System.out.println(myAtoi2("147483"));
        System.out.println(myAtoi2("words and 987"));
        System.out.println(myAtoi2("+1"));
        System.out.println(myAtoi2("+-+-+++1"));
    }

    /**
     * 1 获取数字字符串
     * 2 转换成数字 输出
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        if (str==null || str.length()==0)
            return 0;
        str = str.trim();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c:str.toCharArray()){
            if (isMark(c)||isNumber(c)){
                if (stringBuilder.length()>0){
                    if (!isNumber(c))
                        break;
                }
                stringBuilder.append(c);
            }else {
                break;
            }
        }
        if (stringBuilder.length()<1){
            return 0;
        }else if(stringBuilder.length()==1 && isMark(stringBuilder.charAt(0))){
            return 0;
        }
        try {
            int result = Integer.valueOf(stringBuilder.toString());
            return result;
        }catch (NumberFormatException e){
            return (isNumber(stringBuilder.charAt(0)) || stringBuilder.charAt(0)=='+')?Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
    }

    private static boolean isMark(char c){
        return c=='-'||c=='+';
    }

    private static boolean isNumber(char c){
        return c<=57 && c>=48;
    }

    public static int myAtoi2(String str) {
        if (str==null || str.trim().length()==0)
            return 0;
        str = str.trim();
        int mark = 1;
        int first = 0;
        int sum = 0;
        if (str.startsWith("+")){
            mark=1;
            first++;
        }else if (str.startsWith("-")){
            mark=-1;
            first++;
        }
        for (int i=first;i<str.length();i++){
            if (!isNumber(str.charAt(i))){
                return sum*mark;
            }
            int current = str.charAt(i)-'0';
            if (sum>Integer.MAX_VALUE/10 || (sum==Integer.MAX_VALUE/10&&current>=Integer.MAX_VALUE%10)){
                return mark==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            sum = sum*10+current;
        }
        return sum;
    }
}
