package offer;

/**
 * @author JohnnyJYWu
 * 
 */

public class T52_match {
	//正则表达式匹配
    public boolean match(char[] str, char[] pattern) {
    	if(str == null || pattern == null) return false;
        if(str.length == 0 && pattern.length == 0) return true;//都空，匹配成功
        if(str.length != 0 && pattern.length == 0) return false;//第一个非空，第二个空，匹配失败（相反是有可能成功的，例如"a*a*"可匹配成""）
        if(str.length == 0){
            if((pattern.length == 2 && pattern[1] == '*')){//特殊情况
                return true;
            }else {
                return false;
            }
        }
        
        return matchCore(str, 0, pattern, 0);
    }
    
    private boolean matchCore(char[] str, int sIndex, char[] pattern, int pIndex) {
        if(sIndex == str.length && pIndex == pattern.length) return true;
        
        if(sIndex != str.length && pIndex == pattern.length) return false;
        
        if((pIndex + 1) < pattern.length && pattern[pIndex + 1] == '*') {
            if((sIndex < str.length && str[sIndex] == pattern[pIndex]) 
            		|| (pattern[pIndex] == '.' && sIndex < str.length)) {
            	
                return matchCore(str, sIndex + 1, pattern, pIndex + 2) 
                		|| matchCore(str, sIndex + 1, pattern, pIndex)
                		|| matchCore(str, sIndex, pattern, pIndex + 2);
            }else{
                return matchCore(str, sIndex, pattern, pIndex + 2);
            }
        }
        if((sIndex < str.length && str[sIndex] == pattern[pIndex])
        		|| (pattern[pIndex] == '.' && sIndex < str.length)) {
        	
            return matchCore(str, sIndex + 1, pattern, pIndex + 1);
        }else{
            return false;
        }
    }
}
