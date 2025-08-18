package com.leetcode.code.lc400_600;

import com.leetcode.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class lc404 {
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = 0;
        //遍历左子树
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                TreeNode node = queue.poll();
                if (node.left!=null){
                    queue.add(node.left);
                    if (node.left.left==null&&node.left.right==null) sum+=node.left.val;
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
                size--;
            }
        }
        return sum;
    }
}
