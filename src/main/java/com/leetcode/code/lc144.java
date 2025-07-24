package com.leetcode.code;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
二叉树的前序遍历：中左右
递归
 */
public class lc144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root,result);
        return result;
    }
    //递归函数
    public void preorder(TreeNode root,List<Integer> result){
        if (root==null) return;
        result.add(root.val);//中
        preorder(root.left,result);//前
        preorder(root.right,result);//后
    }

/*
迭代法：前序遍历顺序：中左右，但是入栈顺序是中-右-左
 */
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode currentRoot = stack.pop();
            //中，实际上是最先弹出的
            result.add(currentRoot.val);
            //先入右子节点，保证右节点比左子节点后弹出
            if (currentRoot.right!=null) stack.push(currentRoot.right);
            if (currentRoot.left!=null) stack.push(currentRoot.left);
        }
        return result;
    }
}
