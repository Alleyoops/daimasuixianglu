package com.leetcode.code.kc;

import java.util.Scanner;

//本题要求找到不靠边的陆地面积，那么我们只要从周边找到陆地
//然后通过 dfs或者bfs 将周边靠陆地且相邻的陆地都变成海洋，
//然后再去重新遍历地图 统计此时还剩下的陆地就可以了。
public class kc101_dfs {
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
        //先遍历矩阵四周
        for (int i = 0; i < n; i++) {
            //第一行和最后一行
            if (i!=0&&i!=n-1) continue;
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1){
                    dfs(i,j,grid,n,m);
                }
            }
        }
        //再遍历第一列和最后一列
        for (int i = 0; i < m; i++) {
            if (i!=0&&i!=m-1) continue;
            for (int j = 1; j < n-1; j++) {
                if (grid[j][i]==1){
                    dfs(j,i,grid,n,m);
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
    public static void dfs(int x,int y,int[][] grid,int n,int m){//遍历x，y所有相邻节点（上下左右）
        grid[x][y] = 0;
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        for (int i = 0; i < 4; i++) {//四个方向
            int curX = x+dir[i][0];
            int curY = y+dir[i][1];
            if (curX>=0&&curX<n&&curY>=0&&curY<m&&grid[curX][curY]==1){
                dfs(curX,curY,grid,n,m);
            }
        }
    }
}
