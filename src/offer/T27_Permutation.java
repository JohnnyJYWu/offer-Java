package offer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author JohnnyJYWu
 * 
 */

public class T27_Permutation {
	//字符串的排列
	private ArrayList<String> result = new ArrayList<>();
	
	public ArrayList<String> Permutation(String str) {
		if(str == null || str.length() == 0) return result;
		
		char[] chars = str.toCharArray();
		Arrays.sort(chars);//字典序排序
		
		permutation(chars,
				new boolean[chars.length],//用于记录当前字符是否用过
				new StringBuffer());//字符串，便于操作
		
		return result;
    }
	
	private void permutation(char[] chars, boolean[] hasUsed, StringBuffer str) {
		if(str.length() == chars.length) {//长度相同说明出结果，加入result
			result.add(str.toString());
			return;
		}
		
		for(int i = 0; i < chars.length; i++) {
			if(hasUsed[i]) continue;
	        if(i != 0 && chars[i] == chars[i - 1] && !hasUsed[i - 1]) continue;//连续两个值相同时，保证不重复
	        hasUsed[i] = true;
	        str.append(chars[i]);
	        
	        //递归对后面的字符进行排列
	        permutation(chars, hasUsed, str);
	        
	        //此步重要，去除此循环加入的字符，回退到上一步的排列，与T24中去除节点道理一样
	        str.deleteCharAt(str.length() - 1);
	        hasUsed[i] = false;
	        
		}
	}
}
