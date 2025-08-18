package com.leetcode.code.lc1_200;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class lc113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root==null) return result;
        List<Integer> paths = new ArrayList<>();
        getPath(root,result,targetSum,paths);
        return result;
    }
    public void getPath(TreeNode root,List<List<Integer>> result,int targetSum,List<Integer> paths){
        targetSum-=root.val;
        paths.add(root.val);
        //叶子节点
        if (root.right==null&&root.left==null){
            if (targetSum==0){ //找到一条路
                //错误示范：
                // result.add(paths);
                /*
                Java 中 List 是引用类型，你的 paths 是一个共享的变量，在递归过程中不断被修改。
                你将其直接加入 result 时，result 中保存的其实是对同一个 paths 的引用。
                当递归继续、回溯时，paths 被修改，result 中的数据也会跟着变，导致最终的 result 是错误的。
                 */
                //正确的是：
                result.add(new ArrayList<>(paths));
            }
        }
        //左子树
        if (root.left!=null){
            getPath(root.left,result,targetSum,paths);
            //回溯
            paths.removeLast();
        }
        //右子树
        if (root.right!=null){
            getPath(root.right,result,targetSum,paths);
            //回溯
            paths.removeLast();
        }
    }
}
