package com.leetcode.code;

import com.leetcode.util.TreeNode;

import java.util.*;

public class lc107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return result;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> layResult = new ArrayList<>();
            while (size>0){
                TreeNode node = queue.poll();
                layResult.add(node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                size--;
            }
            result.add(layResult);
        }
        Collections.reverse(result);
        return result;
    }
}
