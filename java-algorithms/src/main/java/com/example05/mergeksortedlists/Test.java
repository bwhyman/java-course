package com.example05.mergeksortedlists;

/**
 * <a href="https://leetcode.cn/problems/merge-k-sorted-lists/description/">合并 K 个升序链表</a>
 */
public class Test {
    public static void main(String[] args) {
        ListNode a3 = new ListNode(5);
        ListNode a2 = new ListNode(4, a3);
        ListNode a1 = new ListNode(1, a2);

        ListNode b3 = new ListNode(4);
        ListNode b2 = new ListNode(3, b3);
        ListNode b1 = new ListNode(1, b2);

        ListNode c2 = new ListNode(6);
        ListNode c1 = new ListNode(2, c2);

        ListNode[] list = {a1, b1, c1};

        ListNode listNode = mergeKLists(list);
        System.out.println(listNode);
    }

    private static ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        //int[] arr = new int[len];
        ListNode node = new ListNode();

        for (int i = 0; i < len; i++) {
            node = lists[i];
        }

        return node;
    }


    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                   "val=" + val +
                   ", next=" + next +
                   '}';
        }
    }
}
