package com.leetcode.code.kc;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class kc98 {
    static List<List<Integer>> result = new ArrayList<>();
    static List<Integer> path = new ArrayList<>();//当前路径

    public static void main(String[] args) {
        /*
        input：
        第一行包含两个整数 N，M，表示图中拥有 N 个节点，M 条边
        后续 M 行，每行包含两个整数 s 和 t，表示图中的 s 节点与 t 节点中有一条路径
         */
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[][] graph = new int[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            graph[scanner.nextInt()][scanner.nextInt()] = 1;
        }
        //solution：
        path.add(1);
        dfs(graph,1,N);
        //output：
        if (result.isEmpty()) System.out.println(-1);
        for (List<Integer> pa : result) {
            for (int i = 0; i < pa.size() - 1; i++) {
                System.out.print(pa.get(i) + " ");
            }
            System.out.println(pa.get(pa.size() - 1));
        }
    }

    private static void dfs(int[][] graph, int x, int N) {//当前遍历的节点x到达节点n
        //终止条件
        if (x == N){
            //找到符合条件的一条路径
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = 1; i < N+1; i++) {//遍历节点x连接的所有节点
            if (graph[x][i] == 1){
                path.add(i);
                dfs(graph,i,N);
                path.remove(path.size()-1);
            }
        }
    }
}
