package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T06_minNumberInRotateArray {
	//旋转数组的最小数字
	public int minNumberInRotateArray(int[] array) {
	    if(array.length == 0) {
	    	return 0;
	    }
	    
	    //二分查找
	    int low = 0, high = array.length - 1;
	    while (array[low] >= array[high]) {
	        if(high - low == 1) {
	        	return array[high];
	        }
	        int mid = low + (high - low) / 2;//取中
	        if(array[mid] >= array[low]) {//此时mid在前半区大的数里
	        	low = mid;
	        } else {//此时mid在后半区小的数里
	        	high = mid;
	        }
	    }
		return array[low];
    }
}
