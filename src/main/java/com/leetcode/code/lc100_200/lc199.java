package com.leetcode.code.lc100_200;

import com.leetcode.util.TreeNode;

import java.util.*;

public class lc199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.add(root);

        while (!queue.isEmpty()){
            int size = queue.size();

            while (size>0){
                TreeNode node = queue.poll();
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                if (size==1) result.add(node.val);
                size--;
            }

        }
        return result;
    }
}
