package com.leetcode.code.kc;

import java.util.Scanner;

public class kc100_dfs {
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
        //dfs
        int ans = 0;
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1&&visited[i][j]!=1){
                    visited[i][j] = 1;
                    int count = 1;
                    ans = Math.max(ans,dfs(count,i,j,grid,visited));
                }
            }
        }
        System.out.println(ans);
    }
    public static int dfs(int count,int x,int y,int[][] grid,int[][] visited){
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        //遍历标记所有相邻陆地节点
        for (int i = 0; i < 4; i++) {
            int nextX = x+dir[i][0];
            int nextY = y+dir[i][1];
            if (nextX<0||nextX>= grid.length||nextY<0||nextY>=grid[0].length) continue;
            if (grid[nextX][nextY]==1&&visited[nextX][nextY]!=1){
                visited[nextX][nextY] = 1;
                count++;
                count = dfs(count,nextX,nextY,grid,visited);
            }
        }
        return count;
    }
}
