package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T08_JumpFloor {
	//跳台阶
	public int JumpFloor(int target) {
		if(target == 0) {
			return 0;
		}
		if(target == 1) {
			return 1;
		}
		if(target == 2) {
			return 2;
		}
		if(target > 2) {//递归求可能出现的情况总数（最后一次跳1或最后一次跳2，倒着往前推）
			return JumpFloor(target - 1) + JumpFloor(target - 2);
		}
		
		return 0;
    }
	
	//或者，其本质上是斐波那契数列的原理
	public int JumpFloor_1(int target) {
		if(target == 0) {
			return 0;
		}
		if(target == 1) {
			return 1;
		}

		int[] array = new int[target];
	    array[0] = 1;
	    array[1] = 2;
	    for (int i = 2; i < target; i++) {
	        array[i] = array[i - 1] + array[i - 2];
	    }
	    return array[target - 1];
	}
}
