package com.leetcode.code.lc1_200;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

//最小深度是从根节点到 最近叶子节点 的最短路径上的节点数量。
public class lc111 {

    //递归
    public int minDepth(TreeNode root) {
        if (root==null) return 0;
        if (root.right==null&&root.left!=null) return minDepth(root.left)+1;
        if (root.left==null&&root.right!=null) return minDepth(root.right)+1;
        return Math.min(minDepth(root.left),minDepth(root.right))+1;
    }
    //迭代
    public int minDepth2(TreeNode root) {
        if (root==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int min = 0;
        while (!queue.isEmpty()){
            int layNum = queue.size();
            min++;
            while (layNum>0){
                TreeNode node = queue.poll();
                if (node.right==null&&node.left==null){
                    return min;
                }
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                layNum--;
            }
        }
        return min;
    }
}
