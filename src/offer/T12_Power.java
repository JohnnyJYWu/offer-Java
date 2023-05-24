package offer;

/**
 * @author JohnnyJYWu
 */

public class T12_Power {
    //数值的整数次方
    public double Power(double base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        boolean isPositive = true;//正负次方以此判断
        if (exponent < 0) {
            exponent = -exponent;
            isPositive = false;
        }

        double pow = Power(base * base, exponent / 2);//递归，每次递归n减小一半，即 (x*x)^(n/2)
        if (exponent % 2 != 0) pow *= base;//奇次幂的话，/2会少算一次，在这补回来

        return isPositive ? pow : (1 / pow);//三元表达式，正次幂为pow，负次幂为1/pow
    }
}
