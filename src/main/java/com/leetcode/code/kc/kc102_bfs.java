package com.leetcode.code.kc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kc102_bfs {
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
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (grid[i][0]==1&&visited[i][0]!=1) {
                queue.add(new int[]{i,0});
                visited[i][0] = 1;
                bfs(grid,visited,queue);
            }
            if (grid[i][m-1]==1&&visited[i][m-1]!=1){
                queue.add(new int[]{i,m-1});
                visited[i][m-1] = 1;
                bfs(grid,visited,queue);
            }
        }
        for (int i = 1; i < m-1; i++) {
            if (grid[0][i]==1&&visited[0][i]!=1){
                queue.add(new int[]{0,i});
                visited[0][i] = 1;
                bfs(grid,visited,queue);
            }
            if (grid[n-1][i]==1&&visited[n-1][i]!=1){
                queue.add(new int[]{n-1,i});
                visited[n-1][i] = 1;
                bfs(grid,visited,queue);
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
    public static void bfs(int[][] grid,int[][] visited,Queue<int[]> queue){
        int[][] dir = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
        while (!queue.isEmpty()){
            int curX = queue.peek()[0];
            int curY = queue.poll()[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX+dir[i][0];
                int nextY = curY+dir[i][1];
                if (nextX<0||nextY<0||nextX>= grid.length||nextY>=grid[0].length) continue;
                if (grid[nextX][nextY]==1&&visited[nextX][nextY]!=1){
                    visited[nextX][nextY] = 1;
                    queue.add(new int[]{nextX,nextY});
                }
            }
        }

    }
}
