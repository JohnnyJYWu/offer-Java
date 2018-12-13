package offer;

import java.util.ArrayList;

/**
 * @author JohnnyJYWu
 * 
 */

public class T41_FindContinuousSequence {
	//和为S的连续正数序列
	public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {//算法，夹逼
		ArrayList<ArrayList<Integer>> result = new ArrayList<>(); 
		if(sum <= 1) return result;
		
		int small = 1;
		int big = 2;
		
		while(small < (sum + 1) / 2) {//要求最少是两个数字，所以small最大为（s+1）/2
			int curSum = 0;//求small到big的和
			for(int i = small; i <= big; i ++) {
				curSum += i;
			}
			
			//夹逼思想，小则big后移，大则small后移
			if(curSum < sum) {
				big ++;
			} else if(curSum > sum) {
				small ++;
			} else {
				ArrayList<Integer> list = new ArrayList<>();
				for(int i = small; i <= big; i ++) {
					list.add(i);
				}
				result.add(list);
				small ++;
			}
		}
		
		return result;
    }
	
	public ArrayList<ArrayList<Integer>> FindContinuousSequence_1(int sum) {//公式
		ArrayList<ArrayList<Integer>> result = new ArrayList<>(); 
		if(sum < 3) return result;
		
		for(int i = 1; i <= sum / 2; i ++) {
			int value = 1 + 4 * i * i - 4 * i + 8 * sum;
			int valueSqrt = (int) Math.sqrt(value);
			if(value >= 25 && valueSqrt * valueSqrt == value) {
				ArrayList<Integer> list = new ArrayList<Integer>();
				for(int j = i; j <= (valueSqrt - 1) >> 1; j ++) {
					list.add(j);
				}
				result.add(list);
			}
		}
		return result;
    }
}
