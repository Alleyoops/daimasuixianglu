package com.leetcode.code;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int layNum = queue.size();
            int count = queue.size();
            Double sum = 0.0;
            while (layNum>0){
                TreeNode node = queue.poll();
                sum+=node.val;
                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                layNum--;
            }
            result.add(sum/count);
        }
        return result;
    }
}
