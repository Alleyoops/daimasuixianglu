package com.leetcode.code.kc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kc101_bfs {
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
        //先遍历矩阵四周
        for (int i = 0; i < n; i++) {
            //第一行和最后一行
            if (i!=0&&i!=n-1) continue;
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1&&visited[i][j]!=1){
                    queue.add(new int[]{i,j});
                    visited[i][j]=1;
                    bfs(i,j,grid,queue,visited);
                }
            }
        }
        //再遍历第一列和最后一列
        for (int i = 0; i < m; i++) {
            if (i!=0&&i!=m-1) continue;
            for (int j = 1; j < n-1; j++) {
                if (grid[j][i]==1&&visited[j][i]!=1){
                    queue.add(new int[]{j,i});
                    visited[j][i] = 1;
                    bfs(j,i,grid,queue,visited);
                }
            }
        }
        //遍历整个矩阵，求出结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1) ans++;
            }
        }
        System.out.println(ans);
    }
    public static void bfs(int x,int y,int[][] grid,Queue<int[]> queue,int[][] visited){
        grid[x][y] = 0;
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0]+dir[i][0];
                int nextY = cur[1]+dir[i][1];
                if (nextX<0||nextX>= grid.length||nextY<0||nextY>=grid[0].length) continue;
                if (grid[nextX][nextY]==1&&visited[nextX][nextY]!=1) {
                    queue.add(new int[]{nextX, nextY});
                    visited[nextX][nextY]=1;
                    grid[nextX][nextY] = 0;
                }
            }
        }
    }
}
