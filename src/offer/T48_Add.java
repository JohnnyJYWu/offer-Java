package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T48_Add {
	//不用加减乘除做加法
	public int Add(int num1, int num2) {//a ^ b 表示没有考虑进位的情况下两数的和，(a & b) << 1 就是进位。
		while(num2 != 0) {
	        int tmp = num1 ^ num2;
	        num2 = (num1 & num2) << 1;
	        num1 = tmp;
	    }
		
	    return num1;
    }
}
