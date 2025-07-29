package com.leetcode.code;

import java.util.*;

class _Node {
    public int val;
    public List<_Node> children;

    public _Node() {}

    public _Node(int _val) {
        val = _val;
    }

    public _Node(int _val, List<_Node> _children) {
        val = _val;
        children = _children;
    }
};
public class lc559 {
    public int maxDepth(_Node root) {
        //递归法
        if(root==null) return 0;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (_Node child : root.children) {
            list.add(maxDepth(child)+1);
        }
        return Collections.max(list);
    }
    //迭代法
    public int maxDepth2(_Node root) {
        //递归法
        if (root==null) return 0;
        int max = 1;
        Queue<_Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size>0){
                _Node node = queue.poll();

                for (_Node child : node.children) {
                    if (child!=null) {
                        queue.add(child);
                    }
                }
                size--;
            }
            max++;
        }
        return max;
    }
}
