package offer;

import java.util.Stack;

/**
 * @author JohnnyJYWu
 * 
 */

public class T05_StackToLinkedList {
	//用两个栈实现队列
	Stack<Integer> stack1 = new Stack<Integer>();//stack1入栈时使用
    Stack<Integer> stack2 = new Stack<Integer>();//stack2出栈时使用，直接出栈即可
    
    public void push(int node) {
        while(!stack2.isEmpty()) {//先将stack2中所有元素压入stack1
        	stack1.push(stack2.pop());
        }
        stack1.push(node);//然后将当前要进入队列元素压入stack1
        while(!stack1.isEmpty()) {//最后将stack1所有元素压入stack2
        	stack2.push(stack1.pop());//此时stack2中出栈顺序即为队列出栈顺序，相当于先入先出
        }
    }
    
    public int pop() {
    	return stack2.pop();
    }
}
