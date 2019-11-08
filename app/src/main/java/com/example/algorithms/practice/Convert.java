package com.example.algorithms.practice;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN
 */
public class Convert {

    public static void main(String[] args){
        System.out.println(convert2("PAYPALISHIRING", 2));
    }

    public static String convert(String s, int numRows) {
        if (s==null || s.length()<=numRows || numRows==1)
            return s;
        int left = (s.length()%(numRows*2-2));
        if (left<=numRows && left>0){
            left = 1;
        }else if (left>numRows){
            left = left-numRows+1;
        }
        int clos = (s.length()/(numRows*2-2))*(numRows-1)+left;
        String[][] a = new String[clos][];
        int currentColumn = 0;
        int currentIndex = 0;
        while (currentColumn<clos){
            String[] current = new String[numRows];
            if (currentColumn%(numRows-1)==0){
                for (int i=0;i<numRows;i++){
                    if (currentIndex<s.length()){
                        current[i] = s.substring(currentIndex, currentIndex+1);
                        currentIndex++;
                    }else {
                        current[i] = "";
                    }
                }
            }else {
                for (int i=0;i<numRows;i++){
                    if (i==(numRows-(currentColumn%(numRows-1))-1)){
                        current[i] = s.substring(currentIndex, currentIndex+1);
                        currentIndex++;
                    }else {
                        current[i] = "";
                    }
                }
            }
            a[currentColumn] = current;
            currentColumn++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i=0;i<numRows;i++){
            for (int j=0;j<clos;j++){
                stringBuilder.append(a[j][i]);
            }
        }
        return stringBuilder.toString();
    }

    public static String convert2(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int step = (numRows - 1) << 1;
        int len = s.length();
        char[] ans = new char[len];
        char[] chars = s.toCharArray();
        int index = -1;
        for (int i = 0; i < numRows; i++) {
            for (int j = i; j < len; j += step) {
                ans[++index] = chars[j];
                if (i != 0 && i != numRows - 1 && step - (i << 1) + j < len) {
                    ans[++index] = chars[step - (i << 1) + j];
                }
            }
        }
        return new String(ans);
    }
}
