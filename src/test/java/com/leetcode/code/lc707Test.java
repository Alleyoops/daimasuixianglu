package com.leetcode.code;

import com.leetcode.code.lc600above.lc707;
import com.leetcode.util.ListNode;
import org.junit.*;

/**
 * lc707 单元测试类
 * 测试方法:
 * 1. public int get(int index)
 * 2. public void addAtHead(int val)
 */
public class lc707Test {

    private lc707 linkedList;

    @Before
    public void setUp() {
        // 初始化空链表
        linkedList = new lc707();
    }

    /**
     * 辅助方法：构建指定值的链表
     * @param values 需要构建的节点值数组
     */
    private void buildLinkedList(int[] values) throws Exception {
        java.lang.reflect.Field headField = lc707.class.getDeclaredField("head");
        headField.setAccessible(true);
        ListNode headNode = (ListNode) headField.get(linkedList);

        ListNode current = headNode;
        for (int value : values) {
            current.next = new ListNode(value);
            current = current.next;
        }

        java.lang.reflect.Field sizeField = lc707.class.getDeclaredField("size");
        sizeField.setAccessible(true);
        sizeField.set(linkedList, values.length);
    }

    /**
     * 测试用例TC01：空链表获取任意索引
     * 预期结果：返回-1（非法索引）
     */
    @Test
    public void testGet_EmptyList() {
        int result = linkedList.get(0);
        Assert.assertEquals("空链表获取任意索引应返回-1", -1, result);
    }

    /**
     * 测试用例TC02：链表长度为3时获取索引0
     * 预期结果：返回10（第一个有效节点的值）
     */
    @Test
    public void testGet_FirstNode() throws Exception {
        buildLinkedList(new int[]{10, 20, 30});
        int result = linkedList.get(0);
        Assert.assertEquals("获取第一个节点值应为10", 10, result);
    }

    /**
     * 测试用例TC03：链表长度为3时获取索引1
     * 预期结果：返回20（中间节点的值）
     */
    @Test
    public void testGet_MiddleNode() throws Exception {
        buildLinkedList(new int[]{10, 20, 30});
        int result = linkedList.get(1);
        Assert.assertEquals("获取中间节点值应为20", 20, result);
    }

    /**
     * 测试用例TC04：链表长度为3时获取索引2
     * 预期结果：返回30（最后一个节点的值）
     */
    @Test
    public void testGet_LastNode() throws Exception {
        buildLinkedList(new int[]{10, 20, 30});
        int result = linkedList.get(2);
        Assert.assertEquals("获取最后一个节点值应为30", 30, result);
    }

    /**
     * 测试用例TC05：索引小于0的情况
     * 预期结果：返回-1（非法索引）
     */
    @Test
    public void testGet_NegativeIndex() throws Exception {
        buildLinkedList(new int[]{10, 20, 30});
        int result = linkedList.get(-1);
        Assert.assertEquals("负数索引应返回-1", -1, result);
    }

    /**
     * 测试用例TC06：索引等于size的情况
     * 预期结果：返回-1（非法索引）
     */
    @Test
    public void testGet_IndexEqualToSize() throws Exception {
        buildLinkedList(new int[]{10, 20, 30});
        int result = linkedList.get(3);  // size = 3，有效索引范围是0-2
        Assert.assertEquals("索引等于size时应返回-1", -1, result);
    }

    /**
     * 测试用例TC07：索引大于size的情况
     * 预期结果：返回-1（非法索引）
     */
    @Test
    public void testGet_IndexGreaterThanSize() throws Exception {
        buildLinkedList(new int[]{10, 20, 30});
        int result = linkedList.get(5);
        Assert.assertEquals("索引大于size时应返回-1", -1, result);
    }

    /**
     * 测试用例TC08：空链表添加头节点
     * 预期结果：新节点成为第一个节点，size变为1
     */
    @Test
    public void testAddAtHead_EmptyList() throws Exception {
        linkedList.addAtHead(5);

        java.lang.reflect.Field headField = lc707.class.getDeclaredField("head");
        headField.setAccessible(true);
        ListNode headNode = (ListNode) headField.get(linkedList);

        java.lang.reflect.Field sizeField = lc707.class.getDeclaredField("size");
        sizeField.setAccessible(true);
        int size = (int) sizeField.get(linkedList);

        Assert.assertEquals("size 应为1", 1, size);
        Assert.assertEquals("头节点的值应为5", 5, headNode.next.val);
    }

    /**
     * 测试用例TC09：非空链表添加头节点
     * 预期结果：新节点成为新的第一个节点，原第一个节点成为第二个节点
     */
    @Test
    public void testAddAtHead_NonEmptyList() throws Exception {
        buildLinkedList(new int[]{10, 20});

        linkedList.addAtHead(5);

        java.lang.reflect.Field headField = lc707.class.getDeclaredField("head");
        headField.setAccessible(true);
        ListNode headNode = (ListNode) headField.get(linkedList);

        Assert.assertEquals("新头节点的值应为5", 5, headNode.next.val);
        Assert.assertEquals("原头节点的值应为10", 10, headNode.next.next.val);
    }

    /**
     * 测试用例TC10：连续多次添加头节点
     * 预期结果：每次添加后size递增1，新节点成为当前第一个节点
     */
    @Test
    public void testAddAtHead_MultipleTimes() throws Exception {
        for (int i = 0; i < 3; i++) {
            linkedList.addAtHead(i);
        }

        java.lang.reflect.Field headField = lc707.class.getDeclaredField("head");
        headField.setAccessible(true);
        ListNode headNode = (ListNode) headField.get(linkedList);

        java.lang.reflect.Field sizeField = lc707.class.getDeclaredField("size");
        sizeField.setAccessible(true);
        int size = (int) sizeField.get(linkedList);

        Assert.assertEquals("size 应为3", 3, size);
        Assert.assertEquals("最新头节点的值应为2", 2, headNode.next.val);
        Assert.assertEquals("次新头节点的值应为1", 1, headNode.next.next.val);
        Assert.assertEquals("最后头节点的值应为0", 0, headNode.next.next.next.val);
    }
}
