package offer;

/**
 * @author JohnnyJYWu
 */

public class T43_LeftRotateString {
    //左旋转字符串
    public String LeftRotateString(String str, int n) {
        if (str == null || str.length() == 0) return "";

        char[] chars = str.toCharArray();
        //step1：先将左边3个字符串进行翻转：[abc]XYZdef --> [cba]XYZdef
        reverse(chars, 0, n - 1);
        //step2：再将右边剩余字符串进行翻转：cba[XYZdef] --> cba[fedZYX]
        reverse(chars, n, chars.length - 1);
        //step3：最后将整个字符串进行翻转： cbafedZYX --> XYZdefabc
        reverse(chars, 0, chars.length - 1);

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;

            start++;
            end--;
        }
    }
}
