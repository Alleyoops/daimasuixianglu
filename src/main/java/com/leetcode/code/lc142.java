package com.leetcode.code;

import com.leetcode.util.ListNode;

public class lc142 {
    //快慢指针法，分别定义 fast 和 slow 指针，从头结点出发，
    //fast指针每次移动两个节点，slow指针每次移动一个节点，
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return null;//没有节点或只有1个节点
        //如果 fast 和 slow指针在途中相遇 ，说明这个链表有环。
        ListNode fast = head;
        ListNode slow = head;
        //判断链表是否环
        while (slow.next != null && fast.next!=null &&fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            /*
            假设从头结点到环形入口节点 的节点数为x。
            环形入口节点到 fast指针与slow指针相遇节点 节点数为y。
            从相遇节点 再到环形入口节点节点数为 z
            则有：x = (n - 1) (y + z) + z
             */
            if (slow == fast) {//相遇
                ListNode startX = head;
                ListNode startZ = slow;
                while (startX != startZ) {
                    startX = startX.next;
                    startZ = startZ.next;
                }
                return startX;
            }
        }
        return null;
        

//        优化写法：
//        ListNode slow = head;
//        ListNode fast = head;
//        while (fast != null && fast.next != null) {
//            slow = slow.next;
//            fast = fast.next.next;
//            if (slow == fast) {// 有环
//                ListNode index1 = fast;
//                ListNode index2 = head;
//                // 两个指针，从头结点和相遇结点，各走一步，直到相遇，相遇点即为环入口
//                while (index1 != index2) {
//                    index1 = index1.next;
//                    index2 = index2.next;
//                }
//                return index1;
//            }
//        }
//        return null;


    }
}
