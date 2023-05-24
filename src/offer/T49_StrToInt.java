package offer;

/**
 * @author JohnnyJYWu
 */

public class T49_StrToInt {
    //把字符串转换成整数(实现Integer.valueOf(string)的功能，但是string不符合数字要求时返回0)
    public int StrToInt(String str) {
        if (str.length() == 0) return 0;

        char[] chars = str.toCharArray();
        boolean isNegative = chars[0] == '-';//判断是否有负号

        int result = 0;

        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[i] == '+' || chars[i] == '-')) continue;//跳过正负号

            if (chars[i] < '0' || chars[i] > '9') return 0;

            result = result * 10 + (chars[i] - '0');
        }

        return isNegative ? -result : result;//三元
    }
}
