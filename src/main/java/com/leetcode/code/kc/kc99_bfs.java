package com.leetcode.code.kc;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class kc99_bfs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        //bfs
        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && visited[i][j] != 1) {
                    ans++;
                    queue.add(new int[]{i,j});
                    visited[i][j] = 1;
                    bfs(i, j, grid, queue,visited);//广度搜索所有i，j节点陆地可到的所有陆地并标记
                }
            }
        }
        System.out.println(ans);
    }

    public static void bfs(int x, int y, int[][] grid, Queue<int[]> queue,int[][] visited) {
        int[][] dir = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};//方向
        while (!queue.isEmpty()) {
            int[] axis = queue.poll();
            int curX = axis[0];
            int curY = axis[1];
            //把四周加入队列
            for (int i = 0; i < 4; i++) {
                int nextX = curX + dir[i][0];
                int nextY = curY + dir[i][1];
                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid[0].length && grid[nextX][nextY]==1&&visited[nextX][nextY] != 1) {
                    int[] next = new int[]{nextX, nextY};
                    queue.add(next);
                    visited[nextX][nextY] = 1;
                }
            }
        }
    }
}
