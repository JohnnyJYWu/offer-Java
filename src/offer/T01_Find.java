package offer;

/**
 * @author JohnnyJYWu
 *
 */

public class T01_Find {
	//二维数组中的查找
	public boolean Find(int target, int[][] array) {
        if(array == null || array.length == 0 || array[0].length == 0) {
            return false;
        }
        
        int m = 0, n = array[0].length - 1;//从右上角开始找，array[0][n-1]
        
        while(m <= array.length - 1 && n >= 0) {
            if(target == array[m][n])
                return true;
            else if(target > array[m][n])
                m ++;
            else
                n --;
        }
        
        return false;
    }
}
