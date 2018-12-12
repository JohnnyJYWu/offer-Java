package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T30_FindGreatestSumOfSubArray {
	//连续子数组的最大和（是挺忽悠人的）
	public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) return 0;
        
        int sum = 0;
        int result = Integer.MIN_VALUE;
        
        for(int val: array) {
        	if(sum < 0) {
        		sum = val;//关键在此，如果前面n个的和sum已经小于0了，别傻乎乎继续加，直接从新的val开始吧
        	} else {
        		sum += val;
        	}
        	
        	if(result < sum) {
        		result = sum;
        	}
        }
        
        return result;
    }
}
