package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

/**
 * @author JohnnyJYWu
 * 
 */

public class T64_maxInWindows {
	//滑动窗口的最大值
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
    	ArrayList<Integer> result = new ArrayList<>();
    	
    	if(num == null || num.length == 0 || size == 0 || size > num.length) {
    		return result;
    	}
    	
    	//双端队列，可从两端弹出，模拟窗口，用于存当前窗口最大值在num数组下标
    	Deque<Integer> deque = new ArrayDeque<>();
    	
    	for(int i = 0; i < num.length; i ++) {
    		if(!deque.isEmpty() && (i - deque.peekFirst()) >= size) {//当队列头已超出窗口范围时移除队列头
    			deque.pollFirst();
    		}
    		while(!deque.isEmpty() && num[i] >= num[deque.peekLast()]) {//如果，要进队列的新的数比队列尾部大，移除队尾，直到队列中只剩最大的一个数
    			deque.pollLast();
    		}
    		deque.offer(i);
    		if(i >= (size - 1)) {//过滤前几个，当遍历到第一个窗口大小时开始存结果
    			result.add(num[deque.peekFirst()]);
    		}
    	}
    	
    	return result;
    }
}
