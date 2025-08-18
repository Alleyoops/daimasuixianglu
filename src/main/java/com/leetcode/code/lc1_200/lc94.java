package com.leetcode.code.lc1_200;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
二叉树的中序遍历：左中右
递归
 */
public class lc94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root,result);
        return result;
    }
    //递归函数
    public void inorder(TreeNode root, List<Integer> result){
        if (root==null) return;
        inorder(root.left,result);//前
        result.add(root.val);//中
        inorder(root.right,result);//后
    }
    //迭代法，与前序遍历、后续遍历的逻辑完全不同
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.right;
            }
        }
        return result;
    }
}
