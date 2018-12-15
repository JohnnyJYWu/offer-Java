package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T54_1stNoRepeatingCharacter {
	//字符流中第一个不重复的字符
	
	//位置计数
	private String str = "";
	private int[] count = new int[256];//计数数组
    //Insert one char from stringstream
    public void Insert(char ch) {
        str += ch;
        count[ch] ++;
    }
	//return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
    	for(int i = 0; i < str.length(); i ++) {
    		if(count[str.charAt(i)] == 1) return str.charAt(i);
    	}
    	
    	return '#';
    }
}
