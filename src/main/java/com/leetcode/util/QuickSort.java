package com.leetcode.util;

/*
选基准（pivot）—— 随便挑一个元素。
分区（partition）—— 把数组切成两段：
≤ pivot 的放左边，≥ pivot 的放右边；pivot 落位“最终位置”。
递归 —— 对左右两段重复 1、2，直到区间长度 ≤ 1。
一句话：每次让基准就位，左边都比它小，右边都比它大，再递归两边，整体有序。
 */
public class QuickSort {
    public static void quickSort(int[] nums) {
        if (nums == null || nums.length <= 1) return;
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        if (left >= right) return;
//        int pIndex = partition_hoare(nums,left,right);
        int pIndex = partition_lomuto(nums, left, right);
        sort(nums, left, pIndex - 1);
        sort(nums, pIndex + 1, right);
    }

    //分区方法一
    private static int partition_hoare(int[] nums, int left, int right) {
        //每次选择最中间元素作为基准
        int pivot = nums[(left + right) / 2];
        int l = left;
        int r = right - 1;
        while (true) {
            while (l <= r && nums[l] < pivot) l++;
            while (l <= r && nums[r] > pivot) r--;
            if (l >= r) break;
            swap(l, r, nums);
            l++;
            r--;
        }
        swap(l, right, nums);
        return l;
    }

    //分区方法二
    private static int partition_lomuto(int[] nums, int left, int right) {
        //每次选择最中间元素作为基准
        int pivot = nums[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                i++;
                swap(i, j, nums);
            }
        }
        i++;
        swap(i, right, nums);
        return i;
    }

    private static void swap(int l, int r, int[] nums) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    // ----- 简单测试 -----
    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 8, 7, 2};
        quickSort(arr);
        System.out.println(java.util.Arrays.toString(arr));
        // 输出：[2, 3, 4, 5, 7, 8]
    }
}
