package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T53_isNumeric {
	//表示数值的字符串
	public boolean isNumeric(char[] str) {
		//+-符号，小数点，e是否出现过
        boolean hasSign = false, hasDecimal = false, hasE = false;
        
        for(int i = 0; i < str.length; i ++) {
            if(str[i] == 'e' || str[i] == 'E') {
            	//e后面一定要接数字
                if(i == str.length - 1) return false; 
                //不能同时存在两个e
                if(hasE) return false; 
                //出现e
                hasE = true;
            } else if(str[i] == '+' || str[i] == '-') {
                //第二次出现+-符号，则必须紧接在e之后
                if(hasSign && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                //第一次出现+-符号，且不是在字符串开头，则也必须紧接在e之后
                if(!hasSign && i > 0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                //出现+-符号
                hasSign = true;
            } else if(str[i] == '.') {
                //e后面不能接小数点，小数点不能出现两次
                if(hasE || hasDecimal) return false;
                //出现小数点
                hasDecimal = true;
            } else if(str[i] < '0' || str[i] > '9') // 不合法字符
                return false;
        }
        return true;
    }
    
    /**
     * 利用正则表达式
     * [\\+\\-]?             正或负符号出现与否
     * \\d*                  整数部分是否出现，如-.34 或 +3.34均符合
     * (\\.\\d+)?            如果出现小数点，那么小数点后面必须有数字；否则一起不出现
     * ([eE][\\+\\-]?\\d+)?  如果存在指数部分，那么e或E肯定出现，+或-可以不出现，紧接着必须跟着整数；或者整个部分都不出现
     */
    public boolean isNumeric_1(char[] str) {
        return new String(str).matches("[\\+\\-]?\\d*(\\.\\d+)?([eE][\\+\\-]?\\d+)?");
    }
}
