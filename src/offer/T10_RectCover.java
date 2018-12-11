package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T10_RectCover {
	//矩阵覆盖
	public int RectCover(int target) {//原理同T8，详见图片
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
