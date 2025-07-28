package com.leetcode.code;

import java.util.LinkedList;
import java.util.Queue;

class Node_ {
    public int val;
    public Node_ left;
    public Node_ right;
    public Node_ next;

    public Node_() {}

    public Node_(int _val) {
        val = _val;
    }

    public Node_(int _val, Node_ _left, Node_ _right, Node_ _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
public class lc116 {
    public Node_ connect(Node_ root) {
        Queue<Node_> queue = new LinkedList<>();
        if (root==null) return root;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                Node_ node = queue.poll();

                if (queue.peek()!=null) {
                    node.next = queue.peek();
                    if (size==1) node.next = null;
                }
                else node.next = null;

                if (node.left!=null) queue.add(node.left);
                if (node.right!=null) queue.add(node.right);
                size--;
            }
        }
        return root;
    }
}
