package com.leetcode.code;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc104 {
    public int maxDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null) return 0;
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()){
            int layNum = queue.size();
            depth++;
            while (layNum>0){
                TreeNode node = queue.poll();

                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                layNum--;
            }

        }
        return depth;
    }
    //递归！！
    public int maxDepth2(TreeNode root) {
        if(root == null)return 0;
        return Math.max(maxDepth2(root.left), maxDepth2(root.right) ) + 1;
    }
}
