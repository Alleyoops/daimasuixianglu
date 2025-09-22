package com.leetcode.code.lc600above;

import java.util.ArrayList;
import java.util.List;

public class lc797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, result, path, 0, graph.length - 1);
        return result;
    }

    private void dfs(int[][] graph, List<List<Integer>> result, List<Integer> path, int start, int end) {
        //遍历从下标start到end的路径
        //终止条件
        if (start == end) {
            result.add(new ArrayList<>(path));
            return;
        }
        //处理逻辑
        for (int j = 0; j < graph[start].length; j++) {//遍历可达的下一节点
            if (graph[start][j] != 0) {
                path.add(graph[start][j]);
                System.out.println(path);
                dfs(graph, result, path, graph[start][j], end);
                path.removeLast();
            }
        }
    }
}
