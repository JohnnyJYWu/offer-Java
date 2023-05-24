package offer;

/**
 * @author JohnnyJYWu
 */

public class T11_NumberOf1 {
    //二进制中 1 的个数
    public int NumberOf1(int n) {//（？？？）
        return Integer.bitCount(n);
    }

    public int NumberOf1_1(int n) {//正常算法
        int sum = 0;

        while (n != 0) {
            sum++;
            n = n & (n - 1);//&按位与
        }

        return sum;
    }
}
