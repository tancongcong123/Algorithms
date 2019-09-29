package com.example.algorithms.other;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合
 * 左括号必须以正确的顺序闭合
 */
public class IsValidBracket {

    private static ArrayList<Character> list = new ArrayList();
    private static HashMap<Character, Character> map = new HashMap<>();

    public static void main(String[] args){
        initMap();
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("([]){([])}()"));
        System.out.println(isValid("([]){(])}()"));
        System.out.println(isValid("()][{}"));
    }

    private static void initMap(){
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
    }

    public static boolean isValid(String s) {
        if (s==null || s.length()==0)
            return false;
        if (s.length()%2==1)
            return false;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length;i++){
            if (list.size()>0){
                char end = list.get(list.size()-1);
                if (map.containsKey(end)&&map.get(end)==chars[i]){
                    list.remove(list.size()-1);
                }else {
                    list.add(chars[i]);
                }
            }else {
                list.add(chars[i]);
            }
        }
        return list.size()==0;
    }
}
