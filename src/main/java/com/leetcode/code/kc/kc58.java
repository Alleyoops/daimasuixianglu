package com.leetcode.code.kc;/*
第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，表示数组的元素。
随后的输入为需要计算总和的区间下标：a，b （b > = a），直至文件结束。
acm模式：注意提交时把类名改为Main，需要有主函数main作为程序执行入口
com.leetcode.code.kc.kc58：卡码网KamaCoder第58题
 */

import java.util.Scanner;

public class kc58 {//提交时注意改成Main类
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] num = new int[n];
        int[] sum = new int[n];//用前缀和法 求区间和
        int p = 0;
        for (int i = 0; i < n; i++) {
            num[i] = scanner.nextInt();
            p+=num[i];
            sum[i] = p;
        }
        while (scanner.hasNextInt()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();

            int result;
            if (a == 0) {
                result = sum[b];
            } else {
                result = sum[b] - sum[a - 1];
            }
            System.out.println(result);
        }
        scanner.close();
    }
}
