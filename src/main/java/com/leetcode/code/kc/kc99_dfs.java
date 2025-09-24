package com.leetcode.code.kc;

import java.util.Scanner;

public class kc99_dfs {
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
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1&&visited[i][j]!=1){
                    //是陆地但没被访问，就+1；
                    ans++;
                    //更新被访问数组
                    visited[i][j]=1;
                    //遍历该陆地所有相邻陆地并标记访问
                    dfs(i,j,grid,visited,n,m);
                }
            }
        }
        System.out.println(ans);
    }
    public static void dfs(int x,int y,int[][] grid,int[][] visited,int n,int m){//遍历x，y所有相邻节点（上下左右）
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for (int i = 0; i < 4; i++) {//四个方向
            int curX = x+dir[i][0];
            int curY = y+dir[i][1];
            if (curX>=0&&curX<n&&curY>=0&&curY<m&&grid[curX][curY]==1&&visited[curX][curY]!=1){
                visited[curX][curY]=1;
                dfs(curX,curY,grid,visited,n,m);
            }
        }
    }
}
