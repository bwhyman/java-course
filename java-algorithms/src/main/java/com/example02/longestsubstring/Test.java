package com.example02.longestsubstring;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/">无重复字符的最长子串</a>
 */
public class Test {
    public static void main(String[] args) {
        // 3
        // String test = "ababcbb";
        // 3
        //String test = "abcabcbb";
        //String test = "bbbbbbbb";
        // 3
        //String test = "pwwkew";
        // 10
        // String test = "asdfghjklz";
        // 11
        //String test = "abcatyuioplk";
        // 5
        // String test = "asdaasqwea";
        // 6
        String test = "abcdecfgh";
        System.out.println(lengthOfLongestSubstring(test));
    }

    /**
     * 从字符串参数中获取chars[]，比charAt()快
     * 维护了一个相同的数组记录对应位置字符，便于获取重复字符索引移动减少次数，但较占内存
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了72%的用户
     * @param s
     * @return
     */
    private static int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        char[] results = new char[s.length()];
        int len = 0;
        int x = 0;
        int y = 0;
        while (y < s.length()) {
            for (int i = x; i < results.length; i++) {
                if (results[i] == '\u0000') {
                    break;
                }
                if (results[i] == chars[y]) {
                    x = i + 1;
                    break;
                }
            }
            len = Math.max(len, y - x + 1);
            results[y] = chars[y];
            y++;
        }
        return len;
    }

    /**
     * 基于滑动窗体实现。用集合算作弊不
     * 出现后相邻相同字符时，有进一步优化空间。
     * @param s
     */
    /*private static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new LinkedHashSet<>();
        int x = 0;
        int y = 0;
        while (y < s.length()) {
            char c = s.charAt(y);
            if (!set.contains(c)) {
                set.add(c);
                y++;
            } else {
                set.remove(c);
                x++;
            }
        }
        set.forEach(System.out::println);
        return set.size();
    }*/
}

