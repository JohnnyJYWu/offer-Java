package offer;

/**
 * @author JohnnyJYWu
 */

public class T44_ReverseSentence {
    //翻转单词顺序列
    public String ReverseSentence(String str) {//原理同T43
        if (str == null || str.length() == 0) return str;

        char[] chars = str.toCharArray();
        int length = chars.length;
        int startIndex = 0;//单词开始标记
        int endIndex = 0;//单词结束标记

        //翻转每个单词的字母顺序
        while (endIndex <= length) {
            if (endIndex == length || chars[endIndex] == ' ') {//遇到空格或到句末，翻转单词
                reversed(chars, startIndex, endIndex - 1);
                startIndex = endIndex + 1;
            }
            endIndex++;
        }

        //翻转整个句子的顺序
        reversed(chars, 0, length - 1);

        return new String(chars);
    }

    private void reversed(char[] chars, int start, int end) {
        while (start < end) {
            char tmp = chars[start];
            chars[start] = chars[end];
            chars[end] = tmp;

            start++;
            end--;
        }
    }
}
