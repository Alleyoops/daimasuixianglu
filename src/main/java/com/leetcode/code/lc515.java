package com.leetcode.code;

import com.leetcode.util.TreeNode;

import java.util.*;

public class lc515 {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root==null)return res;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            int count = queue.size();
            int max = queue.peek().val;
//            List<Integer> layList = new ArrayList<>();
            while (size>0){
                TreeNode node = queue.poll();
//                layList.add(node.val);
                max = Math.max(max,node.val);
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                size--;
            }
//            res.add(Collections.max(layList));
            res.add(max);
        }
        return res;
    }
}
