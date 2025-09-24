package com.leetcode.code.kc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kc100_bfs {
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
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j]==1&&visited[i][j]!=1){
                    queue.add(new int[]{i,j});
                    visited[i][j]=1;
                    int count = 1;
                    ans = Math.max(bfs(count,grid,visited,queue),ans);
                }
            }
        }
        System.out.println(ans);
    }
    public static int bfs(int count,int[][] grid,int[][] visited,Queue<int[]> queue){
        int[][] dir = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = cur[0]+dir[i][0];
                int nextY = cur[1]+dir[i][1];
                if (nextX<0||nextX>= grid.length||nextY<0||nextY>=grid[0].length) continue;
                if (grid[nextX][nextY]==1&&visited[nextX][nextY]!=1){
                    queue.add(new int[]{nextX,nextY});
                    visited[nextX][nextY] = 1;
                    count++;
                }
            }
        }
        return count;
    }
}
