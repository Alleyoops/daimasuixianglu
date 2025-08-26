package com.leetcode.code.lc1_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc51 {
    List<List<String>> result = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chessboard = new char[n][n];
        //初始化棋盘
        for (char[] c : chessboard) {
            Arrays.fill(c,'.');
        }
        backTrack(n,0,chessboard);
        return result;

    }
    private void backTrack(int n,int row,char[][] chessboard) {
        //终止条件
        if (row==n){
            result.add(Arrays2List(chessboard));
            return;
        }
        //处理逻辑
        for (int col = 0; col < n; col++) {
            if (isValid(row,col,n,chessboard)){
                chessboard[row][col] = 'Q';
                backTrack(n,row+1,chessboard);
                chessboard[row][col] = '.';
            }
        }
    }
    private List<String> Arrays2List(char[][] chessboard){
        List<String> list = new ArrayList<>();
        for (char[] c : chessboard) {
            list.add(String.copyValueOf(c));
        }
        return list;
    }
    private boolean isValid(int row, int col, int n, char[][] chessboard){
        //不同列
        for (int i = 0; i < row; i++) {
            if (chessboard[i][col]=='Q'){
                return false;
            }
        }
        //45度斜线
        for (int i = row-1,j = col-1; i >=0&&j>=0 ; i--,j--) {
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }
        //135度斜线
        for (int i = row-1,j=col+1; i >= 0&&j<n ; i--,j++) {
            if (chessboard[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
}
