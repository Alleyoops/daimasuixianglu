package com.leetcode.code.lc1_100;

public class lc63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0]==1) return 0;
        if (obstacleGrid.length==1||obstacleGrid[0].length==1) {
            for (int[] ints : obstacleGrid) {
                for (int anInt : ints) {
                    if (anInt==1) return 0;
                }
            }
        }
        int[][] paths = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < paths.length; i++) {
            if (obstacleGrid[i][0]==0) paths[i][0] = 1;
            else {
                for (int j = i; j < paths.length; j++) {
                    paths[i][0] = 0;
                }
                break;
            }
        }
        for (int i = 0; i < paths[0].length; i++) {
            if (obstacleGrid[0][i]==0) paths[0][i] = 1;
            else {
                for (int j = i; j < paths[0].length; j++) {
                    paths[0][i] = 0;
                }
                break;
            }
        }
        for (int i = 1; i < paths.length; i++) {
            for (int j = 1; j < paths[0].length; j++) {
                if (obstacleGrid[i][j]==0){
                    paths[i][j] = paths[i-1][j]+paths[i][j-1];
                }
                else paths[i][j] = 0;
            }
        }
        return paths[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}
