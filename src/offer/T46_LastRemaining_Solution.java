package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T46_LastRemaining_Solution {
	//孩子们的游戏(圆圈中最后剩下的数)
	public int LastRemaining_Solution(int n, int m) {//约瑟夫环
		//公式：f(n, m) = 0                   (n = 1) 
		//f(n, m) = [f(n - 1, m) + m] % n     (n > 1)
		if(n == 0) return -1;
        if(n == 1) return 0;
	
        return (LastRemaining_Solution(n - 1, m) + m) % n;
	}
}
