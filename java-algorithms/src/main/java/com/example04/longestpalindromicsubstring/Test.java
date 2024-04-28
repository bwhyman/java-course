package com.example04.longestpalindromicsubstring;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-substring/">最长回文子串</a>
 */
public class Test {
    public static void main(String[] args) {
        // ccc
        //String str = "ccc";
        // ccc
        //String str = "bccc";
        // a
        //String str = "ac";
        // adada
        //String str = "babadada";
        // aca
        //String str = "aacabdkacaa";
        // cbcbc
        //String str = "eaccbcbc";
        // bcb
        //String str = "eabcb";
        // bb
        //String str = "cbbd";
        // bb
        //String str = "bb";
        //String str = "aaaa";
        // bab, aba
        //String str = "babad";
        // bb
        //String str = "abb";
        // tattarrattat
        String str = "tattarrattat";
        //System.out.println(longestPalindrome(str));
        System.out.println(longestPalindrome2(str));
    }

    /**
     * 6ms，98.31%；41.32MB，84.70%
     * @param s
     * @return
     */
    private static String longestPalindrome2(String s) {
        int len = s.length();
        char[] chars = s.toCharArray();
        if (len <= 1) {
            return s;
        }
        int l, r;
        int offset = 0;
        int count = 1;
        for (int i = 0; i < len - 1; i++) {
            l = i - 1;
            r = i + 1;
            if (i + 1 <= len - 1 && chars[i] == chars[i + 1]) {
                int k = i;
                int temp = 0;
                while (k + 1 < len && chars[k] == chars[k + 1]) {
                    temp++;
                    if (temp >= count) {
                        offset = i;
                        count++;
                    }
                    k++;
                    r++;
                    if (k == len -1) {
                        break;
                    }
                }
            }
            while (l >= 0 && r < len && chars[l] == chars[r]) {
                int temp = r - l + 1;
                if (temp > count) {
                    offset = l;
                    count = temp;
                }
                l--;
                r++;
            }
        }
        return String.valueOf(chars, offset, count);
    }

    /**
     * 57ms，60.15%; 41.8MB，91.2%
     *
     * @param s
     * @return
     */
    private static String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        char[] chars = s.toCharArray();
        int offset = 0;
        int count = 1;
        for (int i = 0; i < chars.length - 1; i++) {
            if (count > chars.length - i) {
                break;
            }
            lop2:
            for (int j = chars.length - 1; j > i; j--) {
                int temp = j - i + 1;
                if (count > temp) {
                    break;
                }
                if (chars[i] == chars[j]) {
                    int k = (j - i) / 2;
                    for (int x = 1; x <= k; x++) {
                        if (chars[i + x] != chars[j - x]) {
                            continue lop2;
                        }
                    }
                    if (count < temp) {
                        count = temp;
                        offset = i;
                        break;
                    }
                }
            }
        }
        return String.valueOf(chars, offset, count);
    }
}
