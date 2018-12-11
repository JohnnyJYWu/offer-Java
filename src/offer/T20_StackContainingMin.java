package offer;

import java.util.Stack;

/**
 * @author JohnnyJYWu
 * 
 */

public class T20_StackContainingMin {
	//包含 min 函数的栈
	private Stack<Integer> stack = new Stack<>();
	private int min = Integer.MAX_VALUE;
	//minStack用于存储任一元素入栈时，当前栈内的最小值，与stack是同步入栈出栈的，即两个栈内元素数目相同
	private Stack<Integer> minStack = new Stack<>();
	
	public void push(int node) {
        stack.push(node);
        if(min > node) {
        	min = node;
        }
    	minStack.push(min);
    }
    
    public void pop() {
        stack.pop();
        minStack.pop();
        min = minStack.peek();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min;
    }
}
