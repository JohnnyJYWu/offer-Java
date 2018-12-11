package offer;

import java.util.Stack;

/**
 * @author JohnnyJYWu
 * 
 */

public class T21_IsPopOrder {
	//栈的压入、弹出序列
	public boolean IsPopOrder(int[] pushA, int[] popA) {//pushA和popA长度相同
		//建个栈，模拟入栈出栈操作即可
		Stack<Integer> stack = new Stack<>();
		int popIndex = 0;
		
		for(int pushIndex = 0; pushIndex < pushA.length; pushIndex ++) {
			stack.push(pushA[pushIndex]);//按pushA顺序入栈
	    	  
			while(popIndex < popA.length && popA[popIndex] == stack.peek()) {//相同说明可出栈，即模拟popA顺序进行出栈操作
				stack.pop();
				popIndex ++;
			}
		}

		//若栈空，说明pushA入栈能按popA顺序出栈
		return stack.isEmpty();
    }
}
