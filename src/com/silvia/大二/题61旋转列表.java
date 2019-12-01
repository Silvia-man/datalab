package com.silvia.大二;

/**
 * @Author: Silvia
 * @Date: 2019/12/1  15:24
 */

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 */
/*
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {val = x; }
}

 */

class 题61旋转列表 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode current = head;
        int length = 0;

        while (current!=null) {
            length++;
            current = current.next;
        }

        k = k%length;
        if (k == 0) {
            return head;
        }

        current = head;
        for (int i = 0; i < length-k-1; i++) {
            current = current.next;
        }

        ListNode temp = head;
        head = current.next;
        current.next = null;
        current = head;
        while (current.next!=null) {
            current = current.next;
        }

        current.next = temp;
        return head;
    }
}