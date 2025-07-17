package com.leetcode.code;

public class lc27 {
    /*
    给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。
    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组
    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组
    不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组

    示例 1: 给定 nums = [3,2,2,3], val = 3, 函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。 你不需要考虑数组中超出新长度后面的元素。
     */
    public int removeElement(int[] nums, int val) {
        int n = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i]!=val){
                n++;
            }else {
                for (int j = i;j< size-1;j++)
                {
                        nums[j]=nums[j+1];
                }
                size--;
                i--;
            }
        }
        return n;
    }
    //快慢指针法（只需要一个循环）
    /*
    快指针：寻找新数组的元素 ，新数组就是不含有目标元素的数组
    慢指针：指向更新 新数组下标的位置
     */
    public int removeElement2(int[] nums, int val) {
        int n = 0;
        int slowIndex = 0;
        int size = nums.length;
        //理解：可以把带有慢指针slowIndex的nums当做一个新数组来看待，因为下标更新慢，且被赋值的是慢指针数组，所以给新数组(慢指针)赋值不会影响到原数组快指针后面的元素
        for (int fastIndex = 0; fastIndex < size; fastIndex++) {
            //只关注需要的元素，将其赋值给慢指针数组即可
            if (nums[fastIndex]!=val){
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
        }
        return slowIndex;
    }

}
