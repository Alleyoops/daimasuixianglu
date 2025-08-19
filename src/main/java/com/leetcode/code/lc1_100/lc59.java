package com.leetcode.code.lc1_100;

/*
给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，
且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
 */
public class lc59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 1) {
            result[0][0] = 1;
        } else if (n > 1) {
            int num = 1;//元素值
            int time = 0; //while循环次数-1
            while (true) {
                //左到右(循环不变原则，左闭右开)
                for (int i = time; i < n - 1 - time; i++) {
                    result[time][i] = num;
                    num++;
                }
                //从上到下
                for (int i = time; i < n - 1 - time; i++) {
                    result[i][n - 1 - time] = num;
                    num++;
                }
                //从右到左
                for (int i = n - 1 - time; i > time; i--) {
                    result[n - 1 - time][i] = num;
                    num++;
                }
                //从下到上
                for (int i = n - 1 - time; i > time; i--) {
                    result[i][time] = num;
                    num++;
                }
                time++;
                if (num == Math.pow(n, 2) ) {
                    result[n / 2][n / 2] = (int) Math.pow(n, 2);
                    break;
                } else if (num >= Math.pow(n, 2)+1) {
                    break;
                }
            }

        }
        return result;
    }
}
