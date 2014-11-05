
public class Solution {
	
	private ArrayList<String> result = new ArrayList<String>();
	
	
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
    	//如果都没有解，那就没必要再往下求了，否则会TLE的
    	if (hasResult(s,dict)){
    		dfs(s, dict, "");
    	}
    	return result;
    }
    /*
     * 第一题 wordBreak I 判断字符串是否可由dict中的单词构成
     * 
     * */
    public boolean hasResult(String s, Set<String> dict){
    	int len = s.length();
    	if (s.length() == 0 || dict.size() == 0){
    		return false;
    	}
    	boolean[] arrays = new boolean[len+1];
    	arrays[0] = true;
    	for (int i=1; i<=len; ++i){
    		for (int j=0; j<i; ++j){
    			if (arrays[j] && dict.contains(s.substring(j,i))){
    				arrays[i] = true;
    				break;
    			}
    		}
    	}
    	
    	return arrays[len];
    }
    /**
     * 递归求解解的函数
     * @param subStr 要处理的字符串
     * @param dict   单词字典
     * @param currentStr  当前的解的字符串
     */
    public void dfs(String subStr, Set<String> dict, String currentStr){
    	/*递归结束的条件（解成立的条件）*/
    	if (subStr.length() == 0){
    		result.add(currentStr);
    	}
    	
    	for (int i=0; i<=subStr.length(); ++i){
    		String sub = subStr.substring(0,i);
    		/*包含这个子串的话，这个子串和剩余的子串有可能构成一组的解*/
    		if (dict.contains(sub)){
    			
    			//这个值是为了等下递归结束可以恢复currentStr的值
    			int subLen = currentStr.length();
    			
    			//如果不是解中的第一个单词，那么要在前加上一个空格 " "
    			if (!currentStr.equals("")){
    				currentStr += " ";
    			}
    			//加入到一个解的字符串中
    			currentStr += sub;
    			//递归
    			dfs(subStr.substring(i),dict,currentStr);
    			//恢复currentStr，继续下一个解的求解
    			currentStr = currentStr.substring(0,subLen);
    		}
    	}
    }
}
