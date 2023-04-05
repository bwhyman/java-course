package com.example01.addtwonumbers;

/**
 * <a href="https://leetcode.cn/problems/add-two-numbers/">两数相加</a>
 */
public class Test {

    public static void main(String[] args) {
       /* ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);*/

        /*ListNode n1 = new ListNode(1, new ListNode(1));
        ListNode n2 = new ListNode(1);*/
        /*ListNode n1 = new ListNode(8, new ListNode(1));
        ListNode n2 = new ListNode(8);*/
        /*ListNode n1 = new ListNode(8, new ListNode(1, new ListNode(1)));
        ListNode n2 = new ListNode(8);*/

        /*ListNode n1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode n2 = new ListNode(9);*/

        /*ListNode n1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(1))));
        ListNode n2 = new ListNode(9, new ListNode(9));*/

        /*ListNode n1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode n2 = new ListNode(5, new ListNode(6, new ListNode(4)));*/

        ListNode n1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        ListNode n2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        long m1 = Runtime.getRuntime().freeMemory();
        System.out.println(addTwoNumbers(n1, n2));
        long m2 = Runtime.getRuntime().freeMemory();
        System.out.println("Memories: " + ((m1 - m2) / 1024.0));
    }


    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.2 MB, 在所有 Java 提交中击败了91.55%的用户
     * @param l1
     * @param l2
     * @return
     */
    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentN = null;
        int step = 0;
        boolean first = true;
        while (l1 != null || l2 != null || step > 0) {
            ListNode node = new ListNode();
            if (first) {
                result = node;
            } else {
                currentN.next = node;
            }
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + step;
            node.val = sum % 10;
            step = sum / 10;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
            currentN = node;
            first = false;
        }
        return result;
    }

    /**
     * 递归消耗内存
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：41.5 MB, 在所有 Java 提交中击败了53%的用户
     * @param l1
     * @param l1
     * @return
     */
    /*private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode();
        int x = l1 != null ? l1.val : 0;
        int y = l2 != null ? l2.val : 0;
        int sum = x + y;
        result.val = sum % 10;
        int step = sum / 10;
        if ((l1 != null && l1.next != null) || (l2 != null && l2.next != null) || step > 0) {
            ListNode l1Next = l1 != null ? l1.next : null;
            ListNode l2Next = l2 != null ? l2.next : null;
            ListNode node = l1Next != null ? l1Next : (l2Next != null ? l2Next : (l1Next = new ListNode()));
            node.val += step;
            result.next = addTwoNumbers(l1Next, l2Next);
        }
        return result;
    }*/

    private static class ListNode {
        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
