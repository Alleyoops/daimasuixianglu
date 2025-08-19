package com.leetcode.code.lc100_200;

import com.leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
二叉树的后序遍历：左右中
递归
 */
public class lc145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root,result);
        return result;
    }
    //递归函数
    public void postorder(TreeNode root, List<Integer> result){
        if (root==null) return;
        postorder(root.left,result);//前
        postorder(root.right,result);//后
        result.add(root.val);//中
    }
    /*
    迭代法后序遍历:
    先序遍历是中左右，后序遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，
    就变成中右左的遍历顺序，然后在反转result数组，输出的结果顺序就是左右中了
     */
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root==null) return result;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode currentRoot = stack.pop();
            result.add(currentRoot.val);
            if (currentRoot.left!=null) stack.push(currentRoot.left);
            if (currentRoot.right!=null) stack.push(currentRoot.right);
        }
        //翻转数组(list)
        int right = result.size()-1;
        for (int left = 0; left < result.size()/2; left++) {
            int temp = result.get(right);
            result.set(right,result.get(left));
            result.set(left,temp);
            right--;
        }
        //或者
//        Collections.reverse(result);
        return result;
    }
}
