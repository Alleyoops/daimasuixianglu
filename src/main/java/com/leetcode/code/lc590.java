package com.leetcode.code;

import java.util.ArrayList;
import java.util.List;

public class lc590 {
    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(_Node_ root) {
        if (root==null) return result;
        for (_Node_ child : root.children) {
            result = postorder(child);
        }
        result.add(root.val);
        return result;
    }
}
