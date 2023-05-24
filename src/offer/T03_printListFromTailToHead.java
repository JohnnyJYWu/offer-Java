package offer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author JohnnyJYWu
 */

public class T03_printListFromTailToHead {
    //从尾到头打印链表
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        //使用栈实现，先入后出
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stack.isEmpty()) {
            arrayList.add(stack.pop());
        }

        return arrayList;
    }

    public ArrayList<Integer> printListFromTailToHead_1(ListNode listNode) {
        //使用递归实现，先加入链表后面的结点，再加入当前结点
        ArrayList<Integer> arrayList = new ArrayList<>();

        if (listNode != null) {
            arrayList.addAll(printListFromTailToHead_1(listNode.next));//先递归
            arrayList.add(listNode.val);//再加入当前
        }

        return arrayList;
    }
}
