package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T02_replaceSpace {
	//替换空格
	public String replaceSpace(StringBuffer str) {
		int oldLen = str.length();
		
		for(int i = 0; i < oldLen; i ++) {
			if(str.charAt(i) == ' ') {//每出现一个空格，在结尾添加两个任意字符，扩充字符串长度
				str.append("12");
			}
		}
		
		int i = oldLen - 1;
		int j = str.length() - 1;
		
		while(i >= 0 && j > i) {
			char c = str.charAt(i);
			i --;
			
			if(c == ' ') {//每出现一个空格，替换为%20
				str.setCharAt(j, '0');
				j --;
				str.setCharAt(j, '2');
				j --;
				str.setCharAt(j, '%');
				j --;
			} else {//否则照旧
				str.setCharAt(j, c);
				j --;
			}
		}
		
		return str.toString();
	}
}
