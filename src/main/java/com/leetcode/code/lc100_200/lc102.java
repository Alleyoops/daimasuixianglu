package com.leetcode.code.lc100_200;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//层序遍历
public class lc102 {
    List<List<Integer>> result  = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root!=null) queue.add(root);
        check1(queue,result);
        return result;
    }
    //队列。递归或改成while循环
    public static void check1(Queue<TreeNode> queue, List<List<Integer>> result){
        List<Integer> layResult = new ArrayList<>();
        int n = queue.size();
        if (!queue.isEmpty()){
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                if (node!=null) {
                    layResult.add(node.val);
                    if (node.left!=null) queue.add(node.left);
                    if (node.right!=null) queue.add(node.right);
                }
            }
        } else return;
        result.add(layResult);
        check1(queue,result);
    }
    //递归
    public void check2(TreeNode node, Integer deep) {
        if (node == null) return;
        deep++;

        if (result.size() < deep) {
            //当层级增加时，list的Item也增加，利用list的索引值进行层级界定
            List<Integer> item = new ArrayList<Integer>();
            result.add(item);
        }
        result.get(deep - 1).add(node.val);

        check2(node.left, deep);
        check2(node.right, deep);
    }
}
