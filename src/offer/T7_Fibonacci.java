package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T7_Fibonacci {
	//斐波那契数列
	public int Fibonacci(int n) {//n<=39
		int[] array = new int[40];
		array[0] = 0;
		array[1] = 1;
		for(int i = 2; i < array.length; i ++) {
			array[i] = array[i - 1] + array[i - 2];
		}
		
		return array[n];
    }
}
