package com.leetcode.code.lc1_100;

import java.util.*;

/*
给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。

你可以按 任何顺序 返回答案。
 */
public class lc77 {
    public static void main(String[] args) {
        List<List<Integer>> result = combine2(4,3);
        System.out.println(result);
    }
//    public static List<List<Integer>> result = new ArrayList<>();
//    public static List<List<Integer>> combine(int n, int k) {
//        result = backTracking(n,k);
//        return result;
//    }
//    private static List<List<Integer>> backTracking(int n, int k){
//        //终止条件
//        if (n==k){
//            List<List<Integer>> outList = new ArrayList<>();
//            List<Integer> inList = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                inList.add(i+1);
//            }
//            outList.add(inList);
//            return outList;
//        }
//        if (k==1){
//            List<List<Integer>> outList = new ArrayList<>();
//            for (int i = 0; i < n; i++) {
//                List<Integer> inList = new ArrayList<>();
//                inList.add(i+1);
//                outList.add(inList);
//            }
//            return outList;
//        }
//        //处理逻辑
//        List<List<Integer>> result = new ArrayList<>();
//        for (int i = 0; i < n-1; i++) {
//
//            List<List<Integer>> rec = backTracking(n-1-i,k-1);
//            for (List<Integer> integerList : rec) {
//                integerList.addFirst(n-i);
//            }
//            result.addAll(rec);
//        }
//        return result;
//    }



    /*
     递归回溯标准做法
     */
    public static List<List<Integer>> result2 = new ArrayList<>();
    public static List<Integer> res = new ArrayList<>();//路径缓存
    public static List<List<Integer>> combine2(int n, int k) {
        backTracking2(n,k,1);
        return result2;
    }
    public static void backTracking2(int n,int k,int startIndex){
        //终止条件：路径存满，得到一种组合，添加进result
        if (res.size()==k){
            result2.add(new ArrayList<>(res));
            return;
        }
        //处理逻辑（寻找符合条件的组合）
        for (int i = startIndex; i <= n; i++) {
            //添加当前节点
            res.add(i);

            //添加后面的节点
            backTracking2(n,k,i+1);

            //已经寻找完包含当前节点的所有组合
            //在剩下元素中寻找剩余组合，所以要移除当前节点
            res.removeLast();

            //进入下个循环，继续寻找
        }
        /*
           剪枝优化：
           如果for循环选择的起始位置之后的元素个数 已经不足 我们需要的元素个数了，那么就没有必要搜索了。
           接下来看一下优化过程如下：
                已经选择的元素个数：path.size();
                还需要的元素个数为: k - path.size();
                在集合n中至多要从该起始位置 : n - (k - path.size()) + 1，开始遍历

        for (int i = startIndex; i <= n - (k - path.size()) + 1; i++){
            path.add(i);
            combineHelper(n, k, i + 1);
            path.removeLast();
        }
         */


    }
}
