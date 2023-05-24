package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author JohnnyJYWu
 */

public class T40_FindNumsAppearOnce {
    //数组中只出现一次的数字

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {//暴力解法
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(array);

        int length = array.length;

        for (int i = 0; i < length; i++) {
            if (i == length - 1 && array[i] != array[i - 1]) {
                list.add(array[i]);
            } else if (i == 0 && array[i] != array[i + 1]) {
                list.add(array[i]);
            } else {
                if (i != 0 && i != length - 1 && array[i] != array[i - 1] && array[i] != array[i + 1]) {
                    list.add(array[i]);
                }
            }
        }

        num1[0] = list.get(0);
        num2[0] = list.get(1);
    }

    public void FindNumsAppearOnce_1(int[] array, int[] num1, int[] num2) {//位运算
        int different = 0;
        for (int num : array) {//最终得到两个只出现一次的数相异的的结果
            different ^= num;
        }
        //得到最右边的1
        different &= -different;
        for (int num : array) {
            //由于different是那两个数像异的结果，那么这个取得的最右边的1，可将两个只出现一次的数区分开
            //然后再进行一遍异运算即可
            if ((num & different) == 0) {
                num1[0] ^= num;
            } else {
                num2[0] ^= num;
            }
        }
    }

    public void FindNumsAppearOnce_2(int[] array, int[] num1, int[] num2) {//HashSet
        Set<Integer> set = new HashSet<>();

        for (int num : array) {
            if (set.contains(num)) {
                set.remove(num);
            } else {
                set.add(num);
            }
        }

        Iterator<Integer> it = set.iterator();
        num1[0] = it.next();
        num2[0] = it.next();
    }
}
