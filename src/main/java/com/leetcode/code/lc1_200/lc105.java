package com.leetcode.code.lc1_200;

import com.leetcode.util.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class lc105 {
    public TreeNode buildTree(int[] pretorder,int[] inorder) {
        if (pretorder.length==0) return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);//保存中序数组的元素及其下标
        }
        AtomicInteger pre_index = new AtomicInteger(0);
        return findNode(pretorder,map,pre_index,0, inorder.length-1);
    }
    public TreeNode findNode(int[] preorder,Map<Integer,Integer> map,AtomicInteger pre_index,int in_left,int in_right){
        if (in_left>in_right) return null;
        int root_val = preorder[pre_index.get()];
        TreeNode root = new TreeNode(root_val);
        int index = map.get(root_val);
        pre_index.set(pre_index.get()+1);
        root.left = findNode(preorder,map,pre_index,in_left,index-1);
        root.right = findNode(preorder,map,pre_index,index+1,in_right);
        return root;
    }
}
