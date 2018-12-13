package offer;

import java.util.Arrays;

/**
 * @author JohnnyJYWu
 * 
 */

public class T45_isContinuous {
	//扑克牌顺子
	public boolean isContinuous(int[] numbers) {
		if(numbers == null || numbers.length < 5) return false;
		
		Arrays.sort(numbers);
		int sum0 = 0;//大小王数量
		for(int i = 0; i < numbers.length; i ++) {
			if(numbers[i] == 0) {
				sum0 ++;
			}
		}
		
		for(int i = sum0; i < numbers.length - 1; i ++) {
			if(numbers[i + 1] == numbers[i]) return false;//有相等的牌不可能为顺子
			
			int interval = numbers[i + 1] - numbers[i] - 1;//这两个数之间差了几张牌，需要用大小王代替
			if(interval > sum0) return false;//相差太大，大小王不够
			
			sum0 -= interval;
		}
		
		return true;
    }
}
