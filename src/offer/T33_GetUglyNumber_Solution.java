package offer;

/**
 * @author JohnnyJYWu
 */

public class T33_GetUglyNumber_Solution {
    //丑数
    public int GetUglyNumber_Solution(int index) {
        if (index <= 6) return index;//1~6即为前6个丑数

        int index2 = 0, index3 = 0, index5 = 0;

        int[] uglys = new int[index];//存前n个丑数
        uglys[0] = 1;//初始化第一个值为1
        int n = 1;//开始计算第二个丑数

        while (n < index) {
            //找出下一个小的丑数,此步重要需理解，分别用2,3,5在丑数数组里对应的上一个丑数乘2,3,5找出最小的丑数
            int ugly2 = uglys[index2] * 2;
            int ugly3 = uglys[index3] * 3;
            int ugly5 = uglys[index5] * 5;
            int min = Math.min(ugly2, Math.min(ugly3, ugly5));

            uglys[n] = min;
            n++;

            //将2,3,5对应的上一个丑数后移
            if (min == ugly2) index2++;
            if (min == ugly3) index3++;
            if (min == ugly5) index5++;
        }

        return uglys[index - 1];
    }
}
