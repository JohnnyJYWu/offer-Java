package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T31_NumberOf1Between1AndN_Solution {
	//整数中1出现的次数（从1到n整数中1出现的次数）
	public int NumberOf1Between1AndN_Solution(int n) {
		int ones = 0;
		
        for(int m = 1; m <= n; m *= 10) {
            int a = n / m, b = n % m;
            if(a % 10 == 0)
                ones += a / 10 * m;
            else if(a % 10 == 1) 
                ones += (a / 10 * m) + (b + 1);
            else
                ones += (a / 10 + 1) * m;
        }
        
        return ones;
    }
	
	//leetcode大神只用了5行的解法。。。想死
	//https://leetcode.com/problems/number-of-digit-one/discuss/64381/4-lines-olog-n-cjavapython
	public int countDigitOne(int n) {
	    int ones = 0;
	    for (long m = 1; m <= n; m *= 10)
	        ones += (n/m + 8) / 10 * m + (n/m % 10 == 1 ? n%m + 1 : 0);
	    return ones;
	}
}
