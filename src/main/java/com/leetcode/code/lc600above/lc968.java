package com.leetcode.code.lc600above;

import com.leetcode.util.TreeNode;
/**
 节点的状态值：
 0 表示无覆盖
 1 表示 有摄像头
 2 表示有覆盖
 后序遍历，根据左右节点的情况,来判读 自己的状态
 */
public class lc968 {
    int res = 0;
    public int minCameraCover(TreeNode root) {
        //后序遍历，状态转移
        if (postOrder(root)==0) res++;
        return res;
    }
    private int postOrder(TreeNode root){
        if (root==null){
            //空节点默认为有覆盖状态
            return 2;
        }
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        if (left==2&&right==2) return 0;
        else if (left==0||right==0) {
            res++;
            return 1;
        }else return 2;
    }
}
