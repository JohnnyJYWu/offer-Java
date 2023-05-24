package offer;

import java.util.ArrayList;

/**
 * @author JohnnyJYWu
 */

public class T42_FindNumbersWithSum {
    //和为S的两个数字
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        //夹逼思想，且和相等时，差越大乘积越小
        ArrayList<Integer> result = new ArrayList<>();

        int small = 0;//数组下标，从前往后移
        int big = array.length - 1;//数组下标，从后往前移

        while (small <= big) {
            int curSum = array[small] + array[big];
            if (curSum < sum) {
                small++;
            } else if (curSum > sum) {
                big--;
            } else {
                result.add(array[small]);
                result.add(array[big]);
                return result;
            }
        }

        return result;
    }
}
