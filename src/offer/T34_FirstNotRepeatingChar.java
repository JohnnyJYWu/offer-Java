package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T34_FirstNotRepeatingChar {
	//第一个只出现一次的字符位置
	public int FirstNotRepeatingChar(String str) {
        int[] array = new int[256];//计数数组
        
        for(int i = 0; i < str.length(); i ++) {
        	array[str.charAt(i)] ++;
        }
        
        for(int i = 0; i < str.length(); i ++) {
        	if(array[str.charAt(i)] == 1) {//按str的字符顺序来，找出第一个计数次数为1的即为所求位置
        		return i;
        	}
        }
        
        return -1;
    }
}
