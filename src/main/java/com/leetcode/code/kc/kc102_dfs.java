package com.leetcode.code.kc;

import java.util.Scanner;

public class kc102_dfs {
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
        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (grid[i][0]==1&&visited[i][0]!=1) {
                visited[i][0] = 1;
                dfs(i,0,grid,visited);
            }
            if (grid[i][m-1]==1&&visited[i][m-1]!=1){
                visited[i][m-1] = 1;
                dfs(i,m-1,grid,visited);
            }
        }
        for (int i = 1; i < m-1; i++) {
            if (grid[0][i]==1&&visited[0][i]!=1){
                visited[0][i] = 1;
                dfs(0,i,grid,visited);
            }
            if (grid[n-1][i]==1&&visited[n-1][i]!=1){
                visited[n-1][i] = 1;
                dfs(n-1,i,grid,visited);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m-1; j++) {
                if (grid[i][j]==1&&visited[i][j]!=1) {
                    System.out.print(0+" ");
                }else System.out.print(grid[i][j]+" ");
            }
            System.out.println(grid[i][m-1]);
        }
    }
    public static void dfs(int x,int y,int[][] grid,int[][] visited){
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for (int i = 0; i < 4; i++) {
            int nextX = x+dir[i][0];
            int nextY = y+dir[i][1];
            if (nextX<0||nextY<0||nextX>= grid.length||nextY>=grid[0].length) continue;
            if (grid[nextX][nextY]==1&&visited[nextX][nextY]!=1){
                visited[nextX][nextY] = 1;
                dfs(nextX,nextY,grid,visited);
            }
        }
    }
}
