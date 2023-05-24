package offer;

/**
 * @author JohnnyJYWu
 */

public class T28_MoreThanHalfNum_Solution {
    //数组中出现次数超过一半的数字
    public int MoreThanHalfNum_Solution(int[] array) {//多数投票问题
        int num = array[0];
        int count = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i] == num) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                num = array[i];
                count = 1;
            }
        }

        count = 0;
        for (int val : array) {
            if (val == num) {
                count++;
            }
        }

        return count > array.length / 2 ? num : 0;//三元
    }
}
