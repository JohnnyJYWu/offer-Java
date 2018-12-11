package offer;

import java.util.ArrayList;

/**
 * @author JohnnyJYWu
 * 
 */

public class T13_reOrderArray {
	//调整数组顺序使奇数位于偶数前面
	public void reOrderArray(int[] array) {
	    int oddNum = 0;
	    for(int value: array) {
	    	if(value % 2 == 1) {
	    		oddNum++;
	    	}
	    }
	    
	    int[] copyArray = array.clone();//克隆数组，对原数组赋值
	    int i = 0, j = oddNum;//j为偶数开始存储的位置
	    
	    for(int num : copyArray) {
	        if(num % 2 == 1) {
	        	array[i] = num;
	        	i ++;
	        } else {
	        	array[j++] = num;
	        	j ++;
	        }
	    }
	}
	
	public void reOrderArray_1(int[] array) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();
        
        for(int i = 0; i < array.length; i ++) {
        	if(array[i] % 2 == 0) {
        		even.add(array[i]);
        	} else {
        		odd.add(array[i]);
        	}
        }
        odd.addAll(even);

        for(int i = 0; i < array.length; i ++) {
        	array[i] = odd.get(i);
        }
    }
}
