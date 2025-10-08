package com.leetcode.code.kc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kc103_bfs {
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
        int[][] visited = new int[n][m];
        int[][] ans = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j]!=1){
                    visited[i][j] = 1;
                    queue.add(new int[]{i,j});
                    boolean[] sides = new boolean[2];//到达第一组边界和第二组边界
                    bfs(grid,sides,ans,queue);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ans[i][j]==1){
                    System.out.println(i+" "+j);
                }
            }
        }
    }
    public static void bfs(int[][] grid,boolean[] sides,int[][] ans,Queue<int[]> queue){
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        while (!queue.isEmpty()){
            int x = queue.peek()[0];
            int y = queue.poll()[1];
            check(x,y,sides,grid);
            if (sides[0]&&sides[1]){
                ans[x][y] = 1;
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nextX = x+dir[i][0];
                int nextY = y+dir[i][1];
                if (nextY<0||nextX<0||nextX>= grid.length||nextY>=grid[0].length) continue;
                if (grid[nextX][nextY]<=grid[x][y]){
                    queue.add(new int[]{nextX,nextY});
                }
            }
        }

    }
    public static void check(int nextX,int nextY,boolean[] sides,int[][] grid){
        if (nextY==0||nextX==0) sides[0] = true;
        if (nextY==grid[0].length-1||nextX== grid.length-1) sides[1] = true;
    }
}
