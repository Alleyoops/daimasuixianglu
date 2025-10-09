package com.leetcode.code.kc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kc104_dfs {
    public static void main(String[] args) {
        //输入
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        int[][] visited1 = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    int[][] visited0 = new int[n][m];
                    ans = Math.max(ans, dfs(i, j, visited0, grid,1));
                } else if (visited1[i][j] == 0) {
                    visited1[i][j] = 1;
                    ans = Math.max(ans, dfs(i, j, visited1, grid,1));
                }
            }
        }
        System.out.println(ans);
    }

    public static int dfs(int x, int y, int[][] visited, int[][] grid,int count) {
        int[][] dir = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < 4; i++) {
            int nextX = x + dir[i][0];
            int nextY = y + dir[i][1];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length) continue;
            if (grid[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                visited[nextX][nextY] = 1;
                count++;
                count=dfs(nextX,nextY,visited,grid,count);
            }
        }
        return count;
    }
}
