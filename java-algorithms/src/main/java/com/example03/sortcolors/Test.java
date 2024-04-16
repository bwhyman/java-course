package com.example03.sortcolors;

/**
 * <a href="https://leetcode.cn/problems/sort-colors/description/">颜色分类</a>
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        //int[] nums = {2, 0, 1};
        // int[] nums = {1};
        //int[] nums = {1, 0};
        //int[] nums = {2, 2, 0};
        //int[] nums = {2, 1, 2};
        sortColors(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：40.73 MB, 在所有 Java 提交中击败了95.24%的用户
     *
     * @param nums
     */
    public static void sortColors(int[] nums) {
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                nums[i] = nums[p1];
                nums[p1] = 1;
                p1++;
            } else if (nums[i] == 0) {
                nums[i] = nums[p0];
                nums[p0] = 0;
                if (p0 < p1) {
                    nums[i] = nums[p1];
                    nums[p1] = 1;
                }
                p0++;
                p1++;
            }
        }
    }
}
