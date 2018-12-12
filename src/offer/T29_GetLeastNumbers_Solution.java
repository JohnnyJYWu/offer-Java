package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author JohnnyJYWu
 * 
 */

public class T29_GetLeastNumbers_Solution {
	//最小的K个数
	
	//非算法，java就是好用
	public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
        
        if(k > input.length || k <= 0) return list;
		
		Arrays.sort(input);
		for(int i = 0; i < k; i ++) {
			list.add(input[i]);
		}
		
		return list;
    }
	
	//算法，快速选择法，由快排演变而来
	public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
		ArrayList<Integer> list = new ArrayList<>();
        
        if(k > input.length || k <= 0) return list;
		
        int smallestK = findSmallestK(input, k - 1);
        
        for(int val: input) {
        	if(val <= smallestK && list.size() < k) {
        		list.add(val);
        	}
        }
		return list;
    }
	
	private int findSmallestK(int[] input, int k) {
	    int low = 0;
	    int high = input.length - 1;
	    while(low < high) {
	        int j = partition(input, low, high);
	        if(j < k) {
	            low = j + 1;
	        } else if(j > k) {
	            high = j - 1;
	        } else {
	            break;
	        }
	    }
	    return input[k];
	}
	
	private int partition(int[] nums, int low, int high) {
	    int i = low;
	    int j = high + 1;
	    while(true) {
	        while(i < high && nums[++ i] < nums[low]) ;
	        while(j > low && nums[low] < nums[-- j]) ;
	        if(i >= j) {
	            break;
	        }
	        swap(nums, i, j);
	    }
	    swap(nums, low, j);
	    return j;
	}
	
	private void swap(int[] nums, int i, int j) {
	    int tmp = nums[i];
	    nums[i] = nums[j];
	    nums[j] = tmp;
	}
}
