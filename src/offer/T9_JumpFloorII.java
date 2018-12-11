package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T9_JumpFloorII {
	//变态跳台阶
	public int JumpFloorII(int target) {
		if(target == 0 || target == 1) {
			return 1;
		}
		if(target == 2) {
			return 2;
		}
		
		int sum = 0;
		for(int i = 0; i < target; i ++) {//本次跳0次到跳target-1次
			sum += JumpFloorII(i);//对于本次的跳跃又有多少种跳法？递归获取结果
		}
		
		return sum;
    }
}
