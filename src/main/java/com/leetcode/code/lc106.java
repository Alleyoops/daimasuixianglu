package com.leetcode.code;

import com.leetcode.util.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class lc106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder.length==0) return null;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);//保存中序数组的元素及其下标
        }
        AtomicInteger post_index = new AtomicInteger(postorder.length-1);
        return findNode(postorder,map,post_index,0, postorder.length-1);
    }
    public TreeNode findNode(int[] postorder,Map<Integer,Integer> map,AtomicInteger post_index,int in_left,int in_right){
        if (in_left>in_right) return null;
        int root_val = postorder[post_index.get()];
        TreeNode root = new TreeNode(root_val);
        int index = map.get(root_val);
        post_index.set(post_index.get()-1);
        root.right = findNode(postorder,map,post_index,index+1,in_right);
        root.left = findNode(postorder,map,post_index,in_left,index-1);
        return root;
    }
}
