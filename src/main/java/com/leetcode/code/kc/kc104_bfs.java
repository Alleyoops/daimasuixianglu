package com.leetcode.code.kc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class kc104_bfs {
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
        int[][] visited1 = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                    if (grid[i][j]==0){
                        queue.add(new int[]{i,j});
                        int[][] visited0 = new int[n][m];
                        ans = Math.max(ans,bfs(queue,visited0,grid));
                    }
                    else if (visited1[i][j]==0) {
                        queue.add(new int[]{i,j});
                        visited1[i][j] = 1;
                        ans = Math.max(ans, bfs(queue, visited1, grid));
                    }
            }
        }
        System.out.println(ans);
    }
    public static int bfs(Queue<int[]> queue,int[][] visited,int[][] grid){
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int count = 1;
        while (!queue.isEmpty()){
            int curX = queue.peek()[0];
            int curY = queue.poll()[1];
            for (int i = 0; i < 4; i++) {
                int nextX = curX+dir[i][0];
                int nextY = curY+dir[i][1];
                if (nextX<0||nextY<0||nextX>= grid.length||nextY>=grid[0].length) continue;
                if (grid[nextX][nextY]==1&&visited[nextX][nextY]==0){
                    visited[nextX][nextY]=1;
                    queue.add(new int[]{nextX,nextY});
                    count++;
                }
            }
        }
        return count;
    }
}
