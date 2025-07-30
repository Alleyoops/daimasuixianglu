package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

class _Node_ {
    public int val;
    public List<_Node_> children;

    public _Node_() {}

    public _Node_(int _val) {
        val = _val;
    }

    public _Node_(int _val, List<_Node_> _children) {
        val = _val;
        children = _children;
    }
};
public class lc589 {
    //N叉树前序遍历
    List<Integer> result = new ArrayList<>();
    public List<Integer> preorder(_Node_ root) {

        if (root==null) return result;
        result.add(root.val);
        for (_Node_ child : root.children) {
            result = preorder(child);
        }
        return result;
    }
}
