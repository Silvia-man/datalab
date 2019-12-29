package com.silvia.大二;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: Silvia
 * @Date: 2019/12/15  19:36
 */
/*
给定一个链表（链表结点包含一个整型值）的头结点 head。
同时给定列表 G，该列表是上述链表中整型值的一个子集。
返回列表 G 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 G 中）构成的集合。
 */

public class 题817链表组件 {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public int numComponents(ListNode head, int[] G) {
        Set<Integer> set = new HashSet();
        for (int x: G) {
            set.add(x);
        }

        ListNode cur = head;
        int ans = 0;
        //因此如果当前的节点在列表 G 中，并且下一个节点不在列表 G 中
        //我们就找到了一个组件的尾节点，可以将答案加 1。
        while (cur != null) {
            if (set.contains(cur.val) &&
                    (cur.next == null || !set.contains(cur.next.val)))
                ans++;
            cur = cur.next;
        }

        return ans;
    }
}
