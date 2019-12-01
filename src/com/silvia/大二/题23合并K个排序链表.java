package com.silvia.大二;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

/* 学长的
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listNodes = new ArrayList<>(Arrays.asList(lists));
        for (int i = 0; i < listNodes.size(); i++) {
            if (listNodes.get(i) == null) {
                listNodes.remove(i);
                i --;
            }
        }
        if (listNodes.size() == 0) {
            return null;
        }
        if (listNodes.size() == 1) {
            return listNodes.get(0);
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        for (int i = 0; i < listNodes.size(); i ++) {
            if (min > listNodes.get(i).val) {
                min = listNodes.get(i).val;
                count = i;
            }
            if (i == listNodes.size() - 1) {
                temp.next = new ListNode(listNodes.get(count).val);
                temp = temp.next;
                ListNode node = listNodes.get(count).next;
                listNodes.remove(count);
                if (node != null) {
                    listNodes.add(count, node);
                }
                if (listNodes.size() == 0) {
                    break;
                }
                i = 0;
                min = listNodes.get(0).val;
                count = 0;
            }
        }
        temp.next = listNodes.get(0);
        return result.next;
    }
}

 */



/**
 * 创建一个大小为k的最小堆，堆中元素为k个链表中的每个链表的第一个元素
 * 重复下列步骤
 * 每次从堆中取出最小元素（堆顶元素），并将其存入输出数组中
 * 用堆顶元素所在链表元素的下一元素将堆顶元素替换掉，
 * 初始化最小堆的时间复杂度O（k），总共有kn次循环，每次循环调整最小堆的时间复杂度是O（logk）
 * ，所以总的时间复杂度是O（knlogk）
 * */
public class 题23合并K个排序链表 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(2);
        a1.next.next = new ListNode(3);
        a1.next.next.next = new ListNode(100);

        ListNode b1 = new ListNode(1);
        b1.next = new ListNode(2);
        b1.next.next = new ListNode(3);

        ListNode c1 = new ListNode(2);
        c1.next = new ListNode(3);
        c1.next.next= new ListNode(5);

        ListNode[] arr = {a1, b1, c1};
/*
        ListNode res = mergeKLists(arr);
        while (res!= null) {
            System.out.print(res.val + " ");
            res = res.next;
        }

 */
    }

}

class Solution3 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}


class Solution5 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });


        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) queue.add(p.next);
        }
        return dummy.next;
    }
}
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution6 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> listNodes = new ArrayList<>( Arrays.asList(lists));
        for (int i = 0; i < listNodes.size(); i++) {
            if (listNodes.get(i) == null) {
                listNodes.remove(i);
                i --;
            }
        }
        if (listNodes.size() == 0) {
            return null;
        }
        if (listNodes.size() == 1) {
            return listNodes.get(0);
        }
        int min = Integer.MAX_VALUE;
        int count = 0;
        ListNode result = new ListNode(0);
        ListNode temp = result;
        for (int i = 0; i < listNodes.size(); i ++) {
            if (min > listNodes.get(i).val) {
                min = listNodes.get(i).val;
                count = i;
            }
            if (i == listNodes.size() - 1) {
                temp.next = new ListNode(listNodes.get(count).val);
                temp = temp.next;
                ListNode node = listNodes.get(count).next;
                listNodes.remove(count);
                if (node != null) {
                    listNodes.add(count, node);
                }
                if (listNodes.size() == 0) {
                    break;
                }
                i = 0;
                min = listNodes.get(0).val;
                count = 0;
            }
        }
        temp.next = listNodes.get(0);
        return result.next;
    }
}

