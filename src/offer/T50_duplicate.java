package offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author JohnnyJYWu
 * 
 */

public class T50_duplicate {
	//数组中重复的数字
	
    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int[] numbers, int length, int[] duplication) {//算法，交换思想
    	int index = 0;
    	
    	while(index < length) {
    		if(numbers[index] == index) {
    			index ++;
    		} else {
    			int num = numbers[index];
    			if(numbers[num] == num) {//存在重复
    				duplication[0] = num;
    				return true;
    			} else {//不重复则将num交换到numbers[num]上
    				int tmp = numbers[num];
    				numbers[num] = num;
    				numbers[index] = tmp;
    			}
    		}
    	}
    	
    	return false;
    }

    public boolean duplicate_1(int[] numbers, int length, int[] duplication) {//排序，找重复
    	if(numbers == null || numbers.length == 0) {
    		return false;
    	}
    	
    	Arrays.sort(numbers);
    	
    	for(int i = 0; i < length - 1; i ++) {
    		if(numbers[i + 1] == numbers[i]) {
				duplication[0] = numbers[i];
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    public boolean duplicate_2(int[] numbers, int length, int[] duplication) {//哈希表，找重复
    	if(numbers == null || numbers.length == 0) {
    		return false;
    	}
    	
    	Set<Integer> set = new HashSet<>();
    	
    	for(int val: numbers) {
    		if(set.contains(val)) {
				duplication[0] = val;
    			return true;
    		} else {
    			set.add(val);
    		}
    	}
    	
    	return false;
    }
}
