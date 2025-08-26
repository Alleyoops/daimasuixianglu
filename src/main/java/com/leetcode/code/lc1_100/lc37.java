package com.leetcode.code.lc1_100;

public class lc37 {
    public static void main(String[] args) {
        char[][] board= new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        solveSudoku(board);
        //打印board
        for (char[] chars : board) {
            for (char c : chars) {
                System.out.print(c+" ");
            }
        }
    }
    public static void solveSudoku(char[][] board) {
        backTrack(board);
    }
    private static boolean backTrack(char[][] board){
        //终止条件
        //无
        //逻辑处理
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                System.out.println(board[row][col]);
                if (board[row][col]!='.') continue;
                for (int k = 1; k < 10; k++) {
                    if (isValid(k,row,col,board)){
                        board[row][col] = (char)(k+'0');
                        if (backTrack(board)) return true;
                        board[row][col] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(int n, int row,int col,char[][] board){
        char k = (char)(n+'0');
        //同一行不能重复
        for (char c : board[row]) {
            if (c==k) return false;
        }
        //同一列不能重复
        for (int i = 0; i < 9; i++) {
            char c = board[i][col];
            if (c==k) return false;
        }
        //所处3x3宫格内不能重复
        int delta_row = (row)/3;
        int delta_col = (col)/3;
        for (int subRow = delta_row*3; subRow < (delta_row+1)*3; subRow++) {
            for (int subCol = delta_col*3; subCol < (delta_col+1)*3; subCol++) {
                char c = board[subRow][subCol];
                if (c==k) return false;
            }
        }
        return true;
    }
}
