package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T37_GetNumberOfK {
	//数字在排序数组中出现的次数
	public int GetNumberOfK(int[] array , int k) {//顺序查找
		int sum = 0;
		
		for(int val: array) {
			if(val == k) {
				sum ++;
			}
		}
		
		return sum;
    }
	
	public int GetNumberOfK1(int[] array , int k) {//二分查找，找到第一次和最后一次k出现的位置
		int first = getFirstK(array, k);
		int last = getLastK(array, k);
		
		if(first == -1) return 0;
		if(last == -1) return 0;
		
		return last - first + 1;
    }
	
	private int getFirstK(int[] array , int k) {
		int low = 0, high = array.length - 1;
		
	    while (low <= high) {
	        int mid = (high + low) / 2;
	        if(array[mid] >= k) {
	        	high = mid - 1;
	        } else {
	        	low = mid + 1;
	        }
	    }
	    
	    if(low > array.length - 1 || array[low] != k) 
	    	return -1;
	    
	    return low;
	}
	
	private int getLastK(int[] array , int k) {
		int low = 0, high = array.length - 1;
		
	    while (low <= high) {
	        int mid = (high + low) / 2;
	        if(array[mid] > k) {
	        	high = mid - 1;
	        } else {
	        	low = mid + 1;
	        }
	    }
	    
	    if(high < 0 || array[high] != k) 
	    	return -1;
	    
	    return high;
	}
}
