package com.leetcode.code.kc;

import java.util.Scanner;

/*
在一个城市区域内，被划分成了n * m个连续的区块，每个区块都拥有不同的权值，代表着其土地价值。
目前，有两家开发公司，A 公司和 B 公司，希望购买这个城市区域的土地。
现在，需要将这个城市区域的所有区块分配给 A 公司和 B 公司。
然而，由于城市规划的限制，只允许将区域按横向或纵向划分成两个子区域，而且每个子区域都必须包含一个或多个区块。
为了确保公平竞争，你需要找到一种分配方式，使得 A 公司和 B 公司各自的子区域内的土地总价值之差最小。
注意：区块不可再分。
输入描述
第一行输入两个正整数，代表 n 和 m。
接下来的 n 行，每行输出 m 个正整数。
输出描述
请输出一个整数，代表两个子区域内土地总价值之间的最小差距。
 */


public class kc44 {//提交时注意改成Main类
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] array = new int[n][m];
        //前缀行和
        int[][] row = new int[n][m];
        //前缀列和
        int[][] column = new int[m][n];
        //数组赋值的同时求前缀行和
        for (int i = 0; i < n; i++) {
            //中间值p
            int p = 0;
            for (int j = 0; j < m; j++) {
                array[i][j] = scanner.nextInt();
                p+= array[i][j];
                row[i][j]=p;
            }
        }

        //求前缀列和
        for (int i = 0; i < m; i++) {
            int p = 0;
            for (int j = 0; j < n; j++) {
                p+=array[j][i];
                column[i][j] = p;
            }
        }

        //计算数组元素总和
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=row[i][m-1];
        }
        //初始化差值
        int diff = sum;

        //按行分割
        int sum_up = 0;
        int sum_down;
        for (int i = 0; i < n-1; i++) {
            sum_up+=row[i][m-1];
            sum_down = sum - sum_up;
            diff = Math.min(Math.abs(sum_up - sum_down), diff);
        }

        //按列分割
        int sum_left = 0;
        int sum_right = 0;
        for (int j = 0; j < m - 1; j++) {
            sum_left+=column[j][n-1];
            sum_right = sum - sum_left;
            diff = Math.min(Math.abs(sum_left - sum_right), diff);
        }

        System.out.println(diff);
    }
}
