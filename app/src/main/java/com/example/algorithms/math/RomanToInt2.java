package com.example.algorithms.math;

import java.util.HashMap;

/**
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900
 */
public class RomanToInt2 {

    private static HashMap<String, Integer> romanUnit = new HashMap<>();
    private static HashMap<String, Integer> romanUnitSpecial = new HashMap<>();

    public static void main(String[] args){
        initMap();
        System.out.println("III=="+romanToInt("III"));
        System.out.println("IV=="+romanToInt("IV"));
        System.out.println("IX=="+romanToInt("IX"));
        System.out.println("LVIII=="+romanToInt("LVIII"));
        System.out.println("MCMXCIV=="+romanToInt("MCMXCIV"));
    }

    private static void initMap(){
        romanUnit.put("I", 1);
        romanUnit.put("V", 5);
        romanUnit.put("X", 10);
        romanUnit.put("L", 50);
        romanUnit.put("C", 100);
        romanUnit.put("D", 500);
        romanUnit.put("M", 1000);

        romanUnitSpecial.put("IV", 4);
        romanUnitSpecial.put("IX", 9);
        romanUnitSpecial.put("XL", 40);
        romanUnitSpecial.put("XC", 90);
        romanUnitSpecial.put("CD", 400);
        romanUnitSpecial.put("CM", 900);
    }

    public static int romanToInt(String s) {
        if (s==null || s.equals(""))
            return 0;
        int res = 0;
        int index = 0;
        while (index<s.length()){
            int current = 0;
            if (s.length()-index>=2){
                current = romanUnitSpecial.containsKey(s.substring(index, index+2))?romanUnitSpecial.get(s.substring(index, index+2)):0;
            }
            if (current==0){
                res += romanUnit.get(s.substring(index, index+1));
                index++;
            }else {
                res += current;
                index+=2;
            }
        }
        return res;
    }
}
