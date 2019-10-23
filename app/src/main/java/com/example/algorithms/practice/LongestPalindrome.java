package com.example.algorithms.practice;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000
 */
public class LongestPalindrome {

    public static void main(String[] args){
//        System.out.println(longestPalindrome("babaddtattarrattatddetartrateedredividerb"));
        System.out.println(longestPalindrome("cbbd"));
//        System.out.println(longestPalindrome("cbd"));
    }

    public static String longestPalindrome(String s) {
        // 改造字符串，每个字符间添加#。添加头^尾$两个不同的字符用于消除边界判断
        StringBuilder sb = new StringBuilder("^");
        for (int i = 0, len = s.length(); i < len; i++)
            sb.append("#").append(s.charAt(i));
        sb.append("#$");
        int c = 0, r = 0, len = sb.length(), centerIndex = 0, maxLen = 0;
        int[] p = new int[len];

        for (int i = 1; i < len - 1; i++) {
            int iMirror = 2 * c - i; // 相当于 c - (i - c)

            p[i] = r > i ? Math.min(r - i, p[iMirror]) : 0;

            // 基于当前点为中心扩展寻找回文
            while (sb.charAt(i - 1 - p[i]) == sb.charAt(i + 1 + p[i]))
                p[i]++;

            // 如果扩展后的右边界值大于当前右边界值则更新
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }

            // 寻找最大值与中心点
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int beginIndex = (centerIndex - 1 - maxLen) / 2;

        return s.substring(beginIndex, beginIndex + maxLen);
    }

    public static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
//         保存起始位置，测试了用数组似乎能比全局变量稍快一点
        int[] range = new int[2];
        char[] str = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
//             把回文看成中间的部分全是同一字符，左右部分相对称
//             找到下一个与当前字符不同的字符
            i = findLongest(str, i, range);
        }
        return s.substring(range[0], range[1] + 1);
    }

    public static int findLongest(char[] str, int low, int[] range) {
//         查找中间部分
        int high = low;
        while (high < str.length - 1 && str[high + 1] == str[low]) {
            high++;
        }
//         定位中间部分的最后一个字符
        int ans = high;
//         从中间向左右扩散
        while (low > 0 && high < str.length - 1 && str[low - 1] == str[high + 1]) {
            low--;
            high++;
        }
//         记录最大长度
        if (high - low > range[1] - range[0]) {
            range[0] = low;
            range[1] = high;
        }
        return ans;
    }

}
