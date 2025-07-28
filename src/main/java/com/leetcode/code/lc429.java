package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
public class lc429 {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        //递归。用depth作为每个节点的标签
        //每次递归需要考虑深度是否加一，以及遍历子节点
        //递归结束的条件为节点为null
        check(root,result,0);
        return result;
    }
    public void check(Node root, List<List<Integer>> result, int depth){
        if (root!=null){
            depth++;
        }else return;
        if (result.size()<depth) {
            List<Integer> newLay = new ArrayList<>();
            result.add(newLay);
        }
        result.get(depth-1).add(root.val);
        for (Node child : root.children) {
            check(child,result,depth);
        }
    }

}
