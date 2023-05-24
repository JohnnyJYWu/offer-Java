package offer;

/**
 * @author JohnnyJYWu
 */

public class T15_ReverseList {
    //反转链表
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = null;

        while (head != null) {
            ListNode tmp = head.next;//tmp记录【下一个结点】
            head.next = newHead;//【当前结点】的next指向【前一个结点】，反转链表顺序
            newHead = head;//newHead记录【当前结点】，即【下一个结点】的【前一个结点】
            head = tmp;//将【当前结点】更改为【下一个结点】，进入下一次循环迭代
        }
        //当head为null时跳出了循环，此时它的前一个结点newHead即为原链表的最后一个结点，链表顺序已反转
        return newHead;
    }
}
