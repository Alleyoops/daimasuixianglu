package com.leetcode.code.kc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kc103_dfs {
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
        int[][][] visited = new int[n][m][2];
        //第一组边界
        for (int i = 0; i < n; i++) {
            //矩阵左边界
            if (visited[i][0][0]==0){
                visited[i][0][0] = 1;
                dfs(i,0,grid,visited,0);
            }
        }
        for (int i = 1; i < m; i++) {
            //矩阵上边界
            if (visited[0][i][0]==0){
                visited[0][i][0] = 1;
                dfs(0,i,grid,visited,0);
            }
        }
        //第二组边界
        for (int i = 0; i < n; i++) {
            //矩阵右边界
            if (visited[i][m-1][1]==0){
                visited[i][m-1][1] = 1;
                dfs(i,m-1,grid,visited,1);
            }
        }
        for (int i = 0; i < m-1; i++) {
            //矩阵下边界
            if (visited[n-1][i][1]==0){
                visited[n-1][i][1] = 1;
                dfs(n-1,i,grid,visited,1);
            }
        }

        //打印输出
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j][0]==1&&visited[i][j][1]==1){
                    System.out.println(i+" "+j);
                }
            }
        }
    }
    public static void dfs(int x,int y,int[][] grid,int[][][] visited,int side){
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};//逆时针旋转
        for (int i = 0; i < 4; i++) {
            int nextX = x+dir[i][0];
            int nextY = y+dir[i][1];
            if (nextX<0||nextY<0||nextX>= grid.length||nextY>=grid[0].length) continue;
            if (grid[nextX][nextY]>=grid[x][y]&&visited[nextX][nextY][side]==0){
                visited[nextX][nextY][side]=1;
                dfs(nextX,nextY,grid,visited,side);
            }
        }
    }
}
